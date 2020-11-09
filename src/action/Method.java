package action;

import constants.Constants;
import model.*;
import util.ParseUtils;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Method {
    private List<Person> list = new ArrayList<>();

    public void addEmployee() {
        System.out.println("Enter number of employee: ");
        int numberEmployee = (Integer) ParseUtils.parseFromScanner(Integer.class);
        for (int i = 0; i < numberEmployee; i++) {
            Employee employee = Person.create(Employee.class, list);
            System.out.println("Enter level: ");
            System.out.println("1. level 3/7");
            System.out.println("2. Level 4/7");
            int lv = (Integer) ParseUtils.parseFromScanner(Integer.class, "1|2");
            switch (lv) {
                case 1:
                    employee.setLevel(Constants.EMPLOYEE_3_7);
                    break;
                case 2:
                    employee.setLevel(Constants.EMPLOYEE_4_7);
                    break;
            }
            list.add(employee);
        }
    }

    public void addManager() {
        System.out.println("Enter number of manager: ");
        int numberManager = (Integer) ParseUtils.parseFromScanner(Integer.class);
        for (int i = 0; i < numberManager; i++) {
            Manager manager = Person.create(Manager.class, list);
            System.out.println("Enter position: ");
            System.out.println("1. Department head");
            System.out.println("2. Deputy");
            int position = (Integer) ParseUtils.parseFromScanner(Integer.class, "1|2");
            switch (position) {
                case 1:
                    manager.setPositinon(Constants.MANAGER_DEPARTMENT_HEAD);
                    break;
                case 2:
                    manager.setPositinon(Constants.MANAGER_DEPUTY);
                    break;
            }
            list.add(manager);
        }
    }

    public void addLabor() {
        System.out.println("Enter number of labor: ");
        int numberLabor = (Integer) ParseUtils.parseFromScanner(Integer.class);
        for (int i = 0; i < numberLabor; i++) {
            Labor labor = Person.create(Labor.class, list);
            System.out.println("Enter experience of work: ");
            System.out.println("1. Less than 1 year of experience");
            System.out.println("2. 1 year of experience");
            System.out.println("3. Over 1 year of experience");
            int experience = (Integer) ParseUtils.parseFromScanner(Integer.class, "1|2|3");
            switch (experience) {
                case 1:
                    labor.setYearOfWork(Constants.LABOR_LESS_1_YEAR_EXPERIENCE);
                    break;
                case 2:
                    labor.setYearOfWork(Constants.LABOR_1_YEAR_EXPERIENCE);
                    break;
                case 3:
                    labor.setYearOfWork(Constants.LABOR_OVER_1_YEAR_EXPERIENCE);
                    break;
            }
            list.add(labor);
        }
    }

    public void addToList() {
        addEmployee();
        addManager();
        addLabor();
    }

    public void showList() {
        if (list.isEmpty()) {
            System.out.println("                            -----LIST EMPTY-----");
        } else {
            System.out.println("                    --------------- LIST ---------------  ");
            for (Person person : list) {
                System.out.println(person);
            }
            System.out.println("                    ------------------------------------ ");
        }
    }

    public void showEmployee() {
        boolean checkEmployee = false;
        for (Person person : list) {
            if (person instanceof Employee) {
                System.out.println(person.toString());
                checkEmployee = true;
            }
        }
        if (checkEmployee == false) {
            System.out.println("                        ----- DON'T HAVE ANY EMPLOYEE -----");
        }
    }

    public void showManager() {
        boolean checkManager = false;
        for (Person person : list) {
            if (person instanceof Manager) {
                System.out.println(person.toString());
                checkManager = true;
            }
        }
        if (checkManager == false) {
            System.out.println("                        ----- DON'T HAVE ANY MANAGER -----");
        }
    }

    public void showLabor() {
        boolean checkLabor = false;
        for (Person person : list) {
            if (person instanceof Labor) {
                System.out.println(person.toString());
                checkLabor = true;
            }
        }
        if ( checkLabor == false){
            System.out.println("                        ----- DON'T HAVE ANY LABOR -----");
        }
    }

    public Person getPersonById() {
        if (list.isEmpty()) {
            System.out.println("                    -----  LIST IS EMPTY. PLEASE ADD PERSON  -----");
            return null;
        }
        System.out.println("Enter id: ");
        int id = (Integer) ParseUtils.parseFromScanner(Integer.class);
        for (Person person : list) {
            if (id == person.getIdPerson()) {
                return person;
            }
        }
        System.out.println("Don't have this employee. Try again ");
        return getPersonById();
    }

    public void changeName() {
        Person person = getPersonById();
        if (!Objects.isNull(person)) {
            System.out.println("Rename to: ");
            person.setName((String) ParseUtils.parseFromScanner(String.class));
        }
    }

    public void changeDateOfBirth() {
        Person person = getPersonById();
        if (!Objects.isNull(person)) {
            System.out.println("Rename to: ");
            person.setDateOfBirth((Date) ParseUtils.parseFromScanner(Date.class));
        }
    }

    public void changeAddress() {
        Person person = getPersonById();
        if (!Objects.isNull(person)) {
            System.out.println("Rename to: ");
            person.setAddress((String) ParseUtils.parseFromScanner(String.class));
        }
    }


    public void changeGender() {
        Person person = getPersonById();
        if (!Objects.isNull(person)) {
            System.out.println("Rename to: ");
            person.setGender((String) ParseUtils.parseFromScanner(String.class));
        }
    }

    public void changeId() {
        Person person = getPersonById();
        if (!Objects.isNull(person)) {
            System.out.println("Rename to: ");
            person.setIdPerson((Integer) ParseUtils.parseFromScanner(Integer.class));
        }
    }


    public void deletePerson() {
        Person person = getPersonById();
        if (!Objects.isNull(person)) {
            list.remove(person);
        }
    }

    public void findPerson() {
        Person person = getPersonById();
        if (!Objects.isNull(person)) {
            System.out.println(person);
        }
    }


    public void writeToFile() {
        try {
            FileOutputStream fos = new FileOutputStream("src/List.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeFileToList() {
        try {
            FileInputStream fis = new FileInputStream("src/List.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Person> listFile = (List<Person>) ois.readObject();
            for (int i = 0; i < listFile.size(); i++) {
                list.add(listFile.get(i));
            }
        } catch (Exception e) {
            System.out.println("                      -----FILE IS EMPTY-----");
        }
    }

    public void wageCalculation() throws ParseException {
        Salary salary = new Salary();
        Person person = getPersonById();
        if (!Objects.isNull(person)) {
                DateFormat df = new SimpleDateFormat("MM/yyyy");
                System.out.println("Enter month/year want to show salary: ");
                Calendar calendar = Calendar.getInstance();
                calendar.setTime((Date) ParseUtils.parseFromScanner(Date.class, "MM/yyyy", "^(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$"));
                if (person.getHashMap().containsKey(df.format(calendar.getTime()))) {
                    System.out.println("Name: " + person.getName() + ", " + "IdPerson: " + person.getIdPerson() + ", " + person.getHashMap().get(df.format(calendar.getTime())));
                } else {
                    int dayWork = dayWorking(person, salary, calendar.getTime());
                    System.out.println("Enter number day off: ");
                    salary.setDayOff((Integer) ParseUtils.parseFromScanner(Integer.class));
                    salary.setWorkingDays(dayWork - salary.getDayOff());
                    person.getSalary(salary);
                    System.out.println("salary: " + salary.getSalary() + ", name: " + person.getName() + ", IdPerson: " + person.getIdPerson());
                    writeToFile();
                }
            }
        }


    public int dayWorking(Person person, Salary salary, Date calendar) throws ParseException {
        DateFormat df = new SimpleDateFormat("MM/yyyy");
        Calendar cld = Calendar.getInstance();
        cld.setTime(calendar);
        int countDays = 0;
        int dayOfMonth = cld.getActualMaximum(Calendar.DAY_OF_MONTH);
        Date dayStart = df.parse(df.format(person.getDayBeginWork()));
        int result = cld.getTime().compareTo(dayStart);
        if (result == -1) {
            System.out.println("At that time he/she had not worked. Try again: ");
            return dayWorking(person, salary, calendar);
        } else {
            int startDate = 1;
            int yearStart = Integer.parseInt(new SimpleDateFormat("yyyy").format(cld.getTime()));
            int monthStart = Integer.parseInt(new SimpleDateFormat("MM").format(cld.getTime()));
            if (result == 0) {
                startDate = Integer.parseInt(new SimpleDateFormat("dd").format(person.getDayBeginWork()));
            }
            for (int i = startDate; i <= dayOfMonth; i++) {
                cld.set(yearStart, monthStart - 1, i);
                int dayOfWeeks = cld.get(Calendar.DAY_OF_WEEK);
                if (dayOfWeeks != Calendar.SUNDAY) {
                    countDays++;
                }
            }
        }
        person.getHashMap().put(df.format(cld.getTime()), salary);
        return countDays;
    }

}


