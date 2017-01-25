package com.vakhnenko.departments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.vakhnenko.departments.Constants.*;

class Application {

    private boolean readCommand(String command) {
        command = shrink(command);
        String[] commands = command.split(" ");

        switch (commands[COMMAND_POSITION]) {
            case EXIT_COMMAND:
                return false;
            case HELP_COMMAND:
                printHelp();
                break;
            case CREATE_COMMAND:
                create(commands);
                break;
            default:
                System.out.println("Error! Unknown command - \"" + command + "\"");
        }
        return true;
    }

    private void create(String[] commands) {
        switch (commands[FIRST_KEY_POSITION]) {
            case DEPARTMENT_KEY:
                createDepartment(commands);
                break;
            default:
                System.out.println("Syntax Error! - \"" + commands[COMMAND_POSITION] + " " +
                        commands[FIRST_KEY_POSITION] + "\"");
        }
    }

    private void createDepartment(String[] commands) {
        String name = getStringFromManyWords(commands, FIRST_KEY_POSITION);

        if (!name.equals("")) {
            System.out.println("Department name " + name);
        } else {
            System.out.println("Error! Name is empty");
        }

            /*if (departments == null) {
                tmp = (departments = new MRDepartment(name, null));
                System.out.println("Created first " + tmp);
            } else if ((tmp = departments.search(name)) == null) {
                tmp = new MRDepartment(name, departments.getLast());
                System.out.println("Created " + tmp);
            } else {
                System.out.println("Already exists " + tmp);
            }*/
    }

    private void printHelp() {
        System.out.println("commanrds list:");
        System.out.println("");
        System.out.println("create department - \"create -d department_name\"");
        System.out.println("print all departments - \"print all -d\" or \"departments\"");
        System.out.println("open (select) department - \"open -d department_name\"");
        System.out.println("print opened (selected) department - \"print opened -d\"");
        System.out.println("update department - \"update -d department_name\"");
        System.out.println("remove department - \"rm -d department_name\"");
        System.out.println("");
        System.out.println("save date - \"save\"");
        System.out.println("read date - \"read\"");
        System.out.println("");
        System.out.println("exit");
        System.out.println("");
    }

    private void run() throws IOException {
        String command;
        boolean noExit = true;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Departments and Employees");
        System.out.println("Type \"Help\" for commands list or type \"Exit\" for exit");
        System.out.println("");

        /*while (noExit) {
            command = reader.readLine();
            noExit = readCommand(command);
        }*/

        command = shrink("   create  -d  111 1111 dep      ");
        readCommand(command);
        command = shrink("   create  -d  222 2222 dep      -D");
        readCommand(command);
        command = shrink("   create  -d");
        readCommand(command);
    }

    private String getStringFromManyWords(String[] commands, int cindex) {
        String result = "";

        if ((cindex + 1 < commands.length) && (!commands[cindex + 1].contains("-"))) {
            result = commands[cindex + 1] + " " + getStringFromManyWords(commands, cindex + 1);
        }
        return result;
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
