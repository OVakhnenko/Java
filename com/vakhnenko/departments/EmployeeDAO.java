package com.vakhnenko.departments;

public class EmployeeDAO extends EntityDAO {

    EmployeeDAO() {
        employeeStatus = "Employee";
    }

    void create(String name, String type, int age, String lenguage, String metodology) {
        if (search(name) != null) {
            System.out.println(employeeStatus + " \"" + name + "\" already exists");
        } else {
            employees.add(new Employee(name, type, age));
        }
    }
}
