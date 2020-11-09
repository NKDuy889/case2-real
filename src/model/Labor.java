package model;

import constants.Constants;

public class Labor extends Person{
    private int yearOfWork;
    private String duty = "labor";

    public int getYearOfWork() {
        return yearOfWork;
    }

    public void setYearOfWork(int yearOfWork) {
        this.yearOfWork = yearOfWork;
    }

    public String getDuty() {
        return duty;
    }

    @Override
    public void getSalary(Salary salary) {
        int x = 100000;
        if (Constants.LABOR_1_YEAR_EXPERIENCE  == yearOfWork){
            x = 150000;
        } else if (Constants.LABOR_OVER_1_YEAR_EXPERIENCE == yearOfWork){
            x = 200000;
        }
        salary.setSalary((Constants.Salary.LABOR + x) * salary.getWorkingDays() - salary.getDayOff() * 50000);
    }

    @Override
    public String toString() {
        return super.toString() +
                "duty: " + duty +
                " | yearOfWork: " + yearOfWork;
    }
}
