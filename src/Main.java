import action.Menu;
import action.Method;
import util.ParseUtils;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        int choice;
        Method method = new Method();
        Menu menu = new Menu();
        method.writeFileToList();
        do {
            menu.showMenu();
            System.out.print("Your choice: ");
            choice = (Integer) ParseUtils.parseFromScanner(Integer.class,"1|2|3|4|5|6|0");
            switch (choice) {
                case 1:
                    method.addToList();
                    method.writeToFile();
                    break;
                case 2:
                    method.showList();
                    break;
                case 3:
                    menu.showMenuEachDepartment();
                    System.out.print("Your choice: ");
                    int choose1 = (Integer) ParseUtils.parseFromScanner(Integer.class, "1|2|3|0");
                    switch (choose1) {
                        case 1:
                            method.showManager();
                            break;
                        case 2:
                            method.showEmployee();
                            break;
                        case 3:
                            method.showLabor();
                            break;
                    }
                    break;
                case 4:
                    menu.showMenuEditPerson();
                    System.out.print("Your choice: ");
                    int choose2 = (Integer) ParseUtils.parseFromScanner(Integer.class, "1|2|3|4|5|6|0");
                    switch (choose2) {
                        case 1:
                            method.changeName();
                            method.writeToFile();
                            break;
                        case 2:
                            method.changeDateOfBirth();
                            method.writeToFile();
                            break;
                        case 3:
                            method.changeAddress();
                            method.writeToFile();
                            break;
                        case 4:
                            method.changeGender();
                            method.writeToFile();
                            break;
                        case 5:
                            method.changeId();
                            method.writeToFile();
                            break;
                        case 6:
                            method.deletePerson();
                            method.writeToFile();
                    }
                    break;
                case 5:
                    method.findPerson();
                    break;
                case 6:
                    method.wageCalculation();
            }
        } while (choice != 0);
    }
}
