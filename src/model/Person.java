package model;

import util.ParseUtils;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Person implements Serializable {
    private String name;
    private Date dateOfBirth;
    private String address;
    private String gender;
    private int idPerson;
    private Date dayBeginWork;
    private HashMap<String, Salary> hashMap = new HashMap<>();

    public Person() {}

    public Date getDayBeginWork() {
        return dayBeginWork;
    }

    public void setDayBeginWork(Date dayBeginWork) {
        this.dayBeginWork = dayBeginWork;
    }

    public HashMap<String, Salary> getHashMap() {
        return hashMap;
    }

    public void setHashMap(HashMap<String, Salary> hashMap) {
        this.hashMap = hashMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public static <T extends Person> T create(Class<T> clazz, List<Person> personList) {
        try {
            T t = (T) clazz.newInstance();
            System.out.println("Enter the name: ");
            t.setName(ParseUtils.parseFromScanner(String.class).toString());
            System.out.println("Enter date of birth(dd/MM/yyyy): ");
            t.setDateOfBirth(checkOverDateOfBirth());
            System.out.println("Enter address: ");
            t.setAddress(ParseUtils.parseFromScanner(String.class).toString());
            System.out.println("Enter gender(male/female): ");
            t.setGender(ParseUtils.parseFromScanner(String.class).toString());
            int id;
            do {
                System.out.println("Enter id: ");
                id = (Integer) ParseUtils.parseFromScanner(Integer.class);
                t.setIdPerson(id);
            } while (checkId(personList, id));
            System.out.println("Enter day begin work(dd/MM/yyyy): ");
            t.setDayBeginWork(checkOverDayBeginWork());
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date checkOverDateOfBirth() {
        Date date = (Date) ParseUtils.parseFromScanner(Date.class);
        int a = Integer.parseInt(new SimpleDateFormat("yyyy").format(date.getTime()));
        Date nowDate = java.util.Calendar.getInstance().getTime();
        int b = Integer.parseInt(new SimpleDateFormat("yyyy").format(nowDate.getTime()));
        int c = b - a;
        if (c >= 18) {
            return date;
        }
        System.out.println("Company need person at least 18 year old");
        System.out.println("Now date: " + nowDate);
        return checkOverDateOfBirth();
    }

    public static Date checkOverDayBeginWork() {
        Date date = (Date) ParseUtils.parseFromScanner(Date.class);
        int a = Integer.parseInt(new SimpleDateFormat("dd").format(date.getTime()));
        int b = Integer.parseInt(new SimpleDateFormat("MM").format(date.getTime()));
        int c = Integer.parseInt(new SimpleDateFormat("yyyy").format(date.getTime()));
        Date nowDate = java.util.Calendar.getInstance().getTime();
        int d = Integer.parseInt(new SimpleDateFormat("dd").format(nowDate.getTime()));
        int e = Integer.parseInt(new SimpleDateFormat("MM").format(nowDate.getTime()));
        int f = Integer.parseInt(new SimpleDateFormat("yyyy").format(nowDate.getTime()));
        if ((a <= d && b == e && c == f) || (b < e && c <= f)) {
            return date;
        }
        System.out.println("Wrong time. Try again: ");
        System.out.println("Now date: " + nowDate);
        return checkOverDayBeginWork();
    }

    static boolean checkId(List<Person> personList, int id) {
        for (Person person : personList) {
            if (person.getIdPerson() == id) {
                System.out.println("Id exist. Try again: ");
                return true;
            }
        }
        return false;
    }

    public void getSalary(Salary salary) {
    }


    @Override
    public String toString() {
        return "Name: " + name +
                " | dateOfBirth: " + dateOfBirth +
                " | address: " + address +
                " | gender: " + gender +
                " | idPerson: " + idPerson +
                " | dayBeginWork: " + dayBeginWork + ", ";
    }

}
