package com.vakhnenko.departments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.vakhnenko.departments.Constants.*;

public class Application {
    private DepartmentDAO departmentDAO;
    private EmployeeDAO employeeDAO;

    Application() {
        departmentDAO = new DepartmentDAO();
        employeeDAO = new EmployeeDAO();
    }

    private void run() throws IOException {
        String command;
        boolean noExit = true;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        printFirstScreen();

        /*while (noExit) {
            command = reader.readLine();
            noExit = readCommand(command);
        }*/

        readCommand("create -d 111 1111 11111");
        readCommand("create -d 222 2222 22222");
        readCommand("create -d 333 3333 33333");
        System.out.println("");
        /*readCommand("rm -d 444 4444 44444");
        System.out.println("");
        readCommand("rm -d 222 2222 22222");
        System.out.println("");
        readCommand("rm -d 333 3333 33333");
        System.out.println("");
        readCommand("rm -d 111 1111 11111");
        System.out.println("");
        readCommand("departments");*/
        readCommand("create -e -n Ivan Ivanovich -t m -a 22 -m Scrum -dn 222 2222 22222");
        readCommand("create -e -n Ivan Ivanovich -t m -a 22 -m Scrum -dn 222 2222 22222-");
    }

    private boolean readCommand(String command) {
        command = shrink(command);
        String[] commands = command.split(" ");

        switch (commands[COMMAND_POSITION]) {
            case EXIT_COMMAND:
                printBye();
                return false;
            case HELP_COMMAND:
                printHelp();
                break;
            case CREATE_COMMAND:
                create(commands);
                break;
            case REMOVE_COMMAND:
                remove(commands);
                break;
            case PRINT_ALL_DEPARTMENTS_COMMAND:
                printAllDepartments();
                break;
            default:
                System.out.println("Error! Unknown command - \"" + command + "\" type \"help\" for commands list");
        }
        return true;
    }

    private void create(String[] commands) {
        switch (getCommands(commands, FIRST_KEY_POSITION)) {
            case DEPARTMENT_KEY:
                createDepartment(commands);
                break;
            case EMPLOYEE_KEY:
                createEmployee(commands);
                break;
            default:
                printSyntaxError(commands);
        }
    }

    private void createDepartment(String[] commands) {
        String name = getStringFromManyWords(commands, FIRST_KEY_POSITION);

        if (!name.equals("")) {
            departmentDAO.create(name);
            printAllDepartments();
        } else {
            System.out.println("Error! Name is empty");
        }
    }

    private void createEmployee(String[] commands) {
        int positionOfKey;

        positionOfKey = searchKeyInArray(commands, DEPARTMENT_EMPLOYEE_KEY);
        String department = getStringFromManyWords(commands, positionOfKey);

        if (department.equals("")) {
            System.out.println("Error! Department is empty");
            return;
        }

        positionOfKey = searchKeyInArray(commands, NAME_EMPLOYEE_KEY);
        String name = getStringFromManyWords(commands, positionOfKey);

        if (name.equals("")) {
            System.out.println("Error! Name is empty");
            return;
        }

        String type = getKeyFromArray(commands, TYPE_EMPLOYEE_KEY);
        String lenguage = getKeyFromArray(commands, LENGUAGE_EMPLOYEE_KEY);
        String methodology = getKeyFromArray(commands, METHODOLOGY_EMPLOYEE_KEY);

        if (type.equals(EMPLOYEE_MANAGER_TYPE) && (!(lenguage.equals("")))) {
            System.out.println("Error! The manager doesn’t have lenguage field");
            return;
        } else if (type.equals(EMPLOYEE_DEVELOPER_TYPE) && (!(methodology.equals("")))) {
            System.out.println("Error! The developer doesn’t have methodology field");
            return;
        }

        int age = Integer.valueOf(getKeyFromArray(commands, AGE_EMPLOYEE_KEY));

        employeeDAO.create(name, type, age, lenguage, methodology, department);
        //printAllDepartments();
    }

    private void remove(String[] commands) {
        switch (getCommands(commands, FIRST_KEY_POSITION)) {
            case DEPARTMENT_KEY:
                removeDepartment(commands);
                break;
            default:
                printSyntaxError(commands);
        }
    }

    private void removeDepartment(String[] commands) {
        String name = getStringFromManyWords(commands, FIRST_KEY_POSITION);

        if (!name.equals("")) {
            departmentDAO.delete(name);
            printAllDepartments();
        } else {
            System.out.println("Error! Name is empty");
        }
    }

    private void printAllDepartments() {
        departmentDAO.printAll();
    }

    private void printFirstScreen() {
        System.out.println("Departments and Employees");
        System.out.println("Type \"help\" for commands list or type \"exit\" for exit");
        System.out.println("");
    }

    private void printHelp() {
        System.out.println("commanrds list:");
        System.out.println("");
        System.out.println("type \"departments\" for print list of all departments");
        System.out.println("type \"create -d department_name\" for create department \"department_name\"");
        System.out.println("type \"rm -d department_name\" for remove  department \"department_name\"");
        System.out.println("");
        System.out.println("type \"create -e -n employee_name -t m -a age -m methodology\" for for create manager of");
        System.out.println("type \"create -e -n employee_name -t d -a age -l language \" for for create developer");
        //System.out.println("save date - \"save\"");
        //System.out.println("read date - \"read\"");
        System.out.println("");
        System.out.println("type \"help\" for commands list");
        System.out.println("type \"exit\" for exit");
        System.out.println("");
    }

    private void printSyntaxError(String[] commands) {
        System.out.println("Syntax Error! - \"" + getAllArrayStrings(commands) + "\" type \"help\" for commands list");
    }

    private void printBye() {
        System.out.println("Bye!");
    }

    private String getAllArrayStrings(String[] strings) {
        String result = "";
        for (String string : strings) result += string;
        return result;
    }

    private String getCommands(String[] commands, int index) {
        if (index < commands.length) {
            return commands[index];
        } else {
            return getAllArrayStrings(commands);
        }
    }

    private int searchKeyInArray(String[] commands, String key) {
        int result = -1;

        for (int i = 0; i < commands.length; i++) {
            if (commands[i].equals(key)) {
                result = i;
                break;
            }
        }
        return result;
    }

    private String getKeyFromArray(String[] commands, String key) {
        String result = "";
        int index;

        index = searchKeyInArray(commands, key);
        if ((index != -1) && (index < commands.length - 1)) {
            result = commands[index + 1];
        }
        return result;
    }

    private String getStringFromManyWords(String[] commands, int cindex) {
        String result = "";

        if (cindex == -1) {
            return result;
        }
        if ((cindex + 1 < commands.length) && (!commands[cindex + 1].contains("-"))) {
            result = commands[cindex + 1] + " " + getStringFromManyWords(commands, cindex + 1);
        }
        return result.trim();
    }

    private String shrink(String command) {
        String result = command.toUpperCase().trim();

        while (result.contains("  ")) {
            result = result.replace("  ", " ");
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        Application app = new Application();
        app.run();
    }
}
