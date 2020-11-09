package action;

public class Menu {
    public void showMenu(){
        System.out.println("------MENU------");
        System.out.println("1. Add persons");
        System.out.println("2. Show list");
        System.out.println("3. Show each department");
        System.out.println("4. Edit person");
        System.out.println("5. Find person");
        System.out.println("6. Show/Caculation salary");
        System.out.println("0. Exit");
    }

    public void showMenuEditPerson(){
        System.out.println("-----CHOOSE EDIT-----");
        System.out.println("1. Change name");
        System.out.println("2. Change date of birth");
        System.out.println("3. Change address");
        System.out.println("4. Change gender");
        System.out.println("5. Change id person");
        System.out.println("6. Delete person");
        System.out.println("0. Exit");
    }

    public void showMenuEachDepartment(){
        System.out.println("-----CHOOSE DEPARTMENT-----");
        System.out.println("1. Show list manager");
        System.out.println("2. Show list employee");
        System.out.println("3. Show list labor");
        System.out.println("0. Exit");
    }
}
