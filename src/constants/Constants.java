package constants;

public interface Constants {
    public static final String EMPLOYEE_3_7 = "3/7";
    public static final String EMPLOYEE_4_7 = "4/7";
    public static final String MANAGER_DEPARTMENT_HEAD = "Department head";
    public static final String MANAGER_DEPUTY = "Deputy";
    public static final int LABOR_LESS_1_YEAR_EXPERIENCE = 0;
    public static final int LABOR_1_YEAR_EXPERIENCE = 1;
    public static final int LABOR_OVER_1_YEAR_EXPERIENCE = 2;

    public static interface Salary {
        static final int MANAGER = 500000;
        static final int EMPLOYEE = 200000;
        static final int LABOR = 100000;
    }

}
