package com.vakhnenko.departments;

public class DepartmentDAO extends EmployeeDAO {

    DepartmentDAO() {
        employeeStatus = "Department";
    }

    void create(String name) {
        if (search(name) != null) {
            System.out.println(employeeStatus + " \"" + name + "\" already exists");
        } else {
            employees.add(new Department(name));
        }
    }

}
