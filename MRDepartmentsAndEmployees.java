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

import java.io.*;

public class MRDepartmentsAndEmployees {

    private void printHelp() {
        System.out.println("Commands list:");
        System.out.println("");
        System.out.println("HELP - help");
        System.out.println("EXIT - exit");
        System.out.println("");
    }
    private boolean readCommand(String strCmd) {
        strCmd = strCmd.toUpperCase();

        if (strCmd.equals("EXIT")) {
            System.out.println("Buy!");
            return false;
        } else if (strCmd.equals("HELP")) {
            printHelp();
            return true;
        }

        System.out.println("Error! Unknown command - " + strCmd);
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
