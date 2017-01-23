package departments;

//
// Departments and Employees
//
// Create the console app that allows manipulate departments and its employees. We have many departments. Each department has many employees. Each employee has only one department.  The department has name(string) field. The employee has unique ID(number), type(string), age(number), name(string) fields. The ID should be auto generated, start with 1 and increasing step 1. For instance new employee will be assigned with ID=1, next will be assigned with ID=2 and so on so forth.Type could be “m” or “d”. There are two type of employee: Manager (m) and Developer (d). Manager has extra field “methodology”(string) when a developer has “language”(string) fields - this is only one difference between manager and developer, the rest of fields are same.
// The application starts with empty list of departments and user should create new department with command “create -d department_name”. When new department will be created the list with new department should be displayed. Next we want to create new employees for this department. We type “open -d department_name” and list of employes of this department showed. We can create new employee (must be inside of some department to perform employee creating) with command “create -e -t m -n Sammy Nasty -t m -a 35 -m Agile”. The new manager will be created and the list with this employee will be displayed. Actually, there 2 types of employee allowed in this system: Manager (m) and Developer (d). Developers have field “language” (-l) and managers have a field “methodology” (-m). We can watch details of employee by “open -e employee_id”. If this a manager then we can see field “Methodology”. If this a developer we can see “Language” field. The rest of fields for these two kind of employes are the same.
// 	We can update employe with new fields value. For instance “update -e employee_id -a age -l Java” and this employee will be updated with new language and age. If  the “language” field will be used in update/create operation for manager - the information “The manager doesn’t have a language field” should be displayed. If the field “methodology” will be used in update/create operation for developer then show message “The developer doesn’t have methodology field”. For instance “create -e -t d -n Roma Jurich -m Kanban” should raise this message cuz developers doesn’t have the field “Methodology”. All creation employee operations should be performed only inside some of department. In other words we should open some department first to create employee for this department.
// 	Persisting of departments and employees could be temporary - just in memory. Each time when program starts it has no data. We have to create departments / employees each time when program starts. But if you have some inspiration you could create some data persisting into some file and read this file when program starts.
// 	Creation of new employee requires to be inside some of department. You could improve this by enhancing the command of creation employee and adding new key “dn” that will point on specific department for new employee: “create -e -dn department_name -t d ...”.
// 	See list of commands and base steps in the image.
//
// Goals:
// 1.	Understand the concept of OOP
// 2.	Understand how to work with console app and perform commands
// 3.	Obtain base architecture skills
//
// Restrictions:
// 1.	Only base tools from rt.jar
// 2.	Third party libraries aren’t allowed
//

import departments.MRDepartment;
import departments.MRSomething;

import java.io.*;
import java.nio.charset.StandardCharsets;

class MRDepartmentsAndEmployees {
    private String fileName = new File("").getAbsolutePath() + "\\MRDepartmentsAndEmployees.txt";
    private MRSomething departments; // chain of departments
    private MRSomething odepartment; // opened (selected) department

    private static final String DEPARTMENT_CREATE_PREFIX_CMD = "CREATE-D";
    private static final String DEPARTMENT_PRINT_ALL_PREFIX_CMD = "PRINT ALL-D";
    private static final String DEPARTMENT_PRINT_ALL2_PREFIX_CMD = "DEPARTMENTS";
    private static final String DEPARTMENT_OPEN_PREFIX_CMD = "OPEN-D";
    private static final String DEPARTMENT_PRINT_OPENED_PREFIX_CMD = "PRINT OPENED-D";
    private static final String DEPARTMENT_UPDATE_PREFIX_CMD = "UPDATE-D";
    private static final String DEPARTMENT_REMOVE_PREFIX_CMD = "RM-D";
    private static final String DEPARTMENT_SAVE_PREFIX_CMD = "SAVE";
    private static final String DEPARTMENT_READ_PREFIX_CMD = "READ";

    private static final String EMPLOYEE_CREATE_PREFIX_CMD = "";

    MRDepartmentsAndEmployees() {
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

    private String getNameFromCmd(String str, String strPrefix) {
        return str.substring(str.indexOf(strPrefix) + strPrefix.length());
    }

    void createDepartment(String name) {
        MRSomething tmp;

        if (departments == null) {
            tmp = (departments = new MRDepartment(name, null));
            System.out.println("Created first " + tmp);
        } else if ((tmp = departments.search(name)) == null) {
            tmp = new MRDepartment(name, departments.getLast());
            System.out.println("Created " + tmp);
        } else {
            System.out.println("Already exists " + tmp);
        }
    }

    String shrink(String strCmd) {
        strCmd = strCmd.toUpperCase();
        strCmd = strCmd.trim();
        //strCmd = strCmd.replaceAll(" ", "");

        while (strCmd.contains("  ")) {
            strCmd = strCmd.replace("  ", " ");
        }
        while (strCmd.contains(" -")) {
            strCmd = strCmd.replace(" -", "-");
        }
        return strCmd;
    }

    void printAllDepartments() {
        if (departments == null) {
            System.out.println("Error! No departments");
        } else {
            departments.printAll();
        }
    }

    void openDepartment(String name) {
        if (departments != null) {
            odepartment = departments.search(name);
            System.out.println("Opened department - " + odepartment);
        } else {
            System.out.println("Error! No departments");
        }
    }

    void printOpenedDepartment() {
        if (odepartment != null) {
            System.out.println("Opened - " + odepartment);
        } else {

            System.out.println("Error! No opened department");
        }
    }

    void updateDepartment(String name) {
        if (odepartment == null) {
            System.out.println("Error! No opened department! Open it before update");
        } else {
            odepartment.setName(name);
            System.out.println("Updated. Now - " + odepartment);
        }
    }

    void removeDepartment(String name) {
        if (departments != null) {
            MRSomething tmp = departments.search(name);
            if (tmp != null) {
                MRSomething prev = tmp.getPrev();
                MRSomething next = tmp.getNext();

                if (prev != null) {
                    prev.setNext(next);
                } else {
                    departments = next;
                }
                if (next != null) {
                    next.setPrev(prev);
                }
                tmp.setPrev(null);
                tmp.setNext(null);
                System.out.println("Department " + tmp + " removed");
            } else {
                System.out.println("Error! Not found department " + name);
            }
        } else {
            System.out.println("Error! No departments");
        }
    }

    void saveAll() {
        boolean saved;

        if (departments == null) {
            System.out.println("Error! No departments");
        } else {
            try (FileWriter writer = new FileWriter(fileName, false)) {
                MRSomething tmp = departments.getFirst();

                do {
                    saved = tmp.save(writer, DEPARTMENT_CREATE_PREFIX_CMD);
                    if (!saved) {
                        break;
                    }
                    if (tmp.composition != null) {
                        saved = tmp.composition.saveAll(writer, EMPLOYEE_CREATE_PREFIX_CMD);
                        if (!saved) {
                            break;
                        }
                    }
                    tmp = tmp.getNext();

                } while (!(tmp == null));
                writer.close();

                if (saved) {
                    System.out.println("All data saved successfully");
                } else {
                    System.out.println("Write error!");
                }
            } catch (IOException e) {
                System.out.println("Write error!");
            }
        }
    }

    void readAll() {
        if (departments != null) {
            System.out.println("Error! Departments are exists");
        } else {
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileName), StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    readCommand(line);
                }
            } catch (IOException e) {
                System.out.println("Read error!");
            }
        }
    }

    private boolean readCommand(String strCmd) {
        strCmd = shrink(strCmd);

        if (strCmd.equals("EXIT")) {
            System.out.println("Buy!");
            return false;
        } else if (strCmd.equals("HELP")) {
            printHelp();
        } else if (strCmd.contains(DEPARTMENT_CREATE_PREFIX_CMD)) {
            createDepartment(getNameFromCmd(strCmd, DEPARTMENT_CREATE_PREFIX_CMD));
        } else if (strCmd.contains(DEPARTMENT_PRINT_ALL_PREFIX_CMD)) {
            printAllDepartments();
        } else if (strCmd.contains(DEPARTMENT_PRINT_ALL2_PREFIX_CMD)) {
            printAllDepartments();
        } else if (strCmd.contains(DEPARTMENT_OPEN_PREFIX_CMD)) {
            openDepartment(getNameFromCmd(strCmd, DEPARTMENT_CREATE_PREFIX_CMD));
        } else if (strCmd.contains(DEPARTMENT_PRINT_OPENED_PREFIX_CMD)) {
            printOpenedDepartment();
        } else if (strCmd.contains(DEPARTMENT_UPDATE_PREFIX_CMD)) {
            updateDepartment(getNameFromCmd(strCmd, DEPARTMENT_UPDATE_PREFIX_CMD));
        } else if (strCmd.contains(DEPARTMENT_REMOVE_PREFIX_CMD)) {
            removeDepartment(getNameFromCmd(strCmd, DEPARTMENT_REMOVE_PREFIX_CMD));
        } else if (strCmd.contains(DEPARTMENT_SAVE_PREFIX_CMD)) {
            saveAll();
        } else if (strCmd.contains(DEPARTMENT_READ_PREFIX_CMD)) {
            readAll();
        } else {
            System.out.println("Error! Unknown command - \"" + strCmd + "\"");
        }

        return true;
    }

    private void go() throws IOException {
        String strCmd;
        boolean noExit = true;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Departments and Employees");
        System.out.println("Type \"Help\" for commands list or type \"Exit\" for exit");
        System.out.println("");

        while (noExit) {
            strCmd = reader.readLine();
            noExit = readCommand(strCmd);
        }
    }

    public static void main(String[] args) throws IOException {
        MRDepartmentsAndEmployees mrdae = new MRDepartmentsAndEmployees();
        mrdae.go();
    }
}
