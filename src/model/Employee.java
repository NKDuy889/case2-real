package model;

import constants.Constants;

public class Employee extends Person {
    private String level;
    private String duty = "employee";

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDuty() {
        return duty;
    }

    @Override
    public void getSalary(Salary salary) {
        int x = 250000;
        if (Constants.EMPLOYEE_3_7.equals(level)) {
            x = 350000;
        }
        salary.setSalary((Constants.Salary.EMPLOYEE + x) * salary.getWorkingDays() - salary.getDayOff() * 50000);
    }

    @Override
    public String toString() {
        return super.toString() +
                "duty:  " + duty +
                " | level: " + level ;
    }
}
