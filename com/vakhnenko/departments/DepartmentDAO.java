package com.vakhnenko.departments;

class DepartmentDAO extends EmployeeDAO {

    DepartmentDAO() {
        setEmployeeStatus("Department");
    }

    void create(String name) {
        if (search(name) != null) {
            System.out.println(getEmployeeStatus() + " \"" + name + "\" already exists");
        } else {
            employees.add(new Department(name));
        }
    }

}
