package model;

import constants.Constants;

public class Manager extends Person {
    private String positinon;
    private String duty = "manager";

    public Manager() {
    }

    public Manager(String positinon) {
        this.positinon = positinon;
    }

    public String getPositinon() {
        return positinon;
    }

    public void setPositinon(String positinon) {
        this.positinon = positinon;
    }

    public String getDuty() {
        return duty;
    }

    @Override
    public void getSalary(Salary salary) {
        int x = 400000;
        if (Constants.MANAGER_DEPARTMENT_HEAD.equals(positinon)) {
            x = 500000;
        }
        salary.setSalary((Constants.Salary.MANAGER + x) * salary.getWorkingDays() - salary.getDayOff() * 50000);
    }

    @Override
    public String toString() {
        return super.toString() +
                "duty: " + duty +
                " | positinon: " + positinon;
    }
}
