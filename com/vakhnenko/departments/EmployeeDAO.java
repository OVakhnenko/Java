package com.vakhnenko.departments;

class EmployeeDAO extends EntityDAO {

    EmployeeDAO() {
        setEmployeeStatus("Employee");
    }

    void create(String name, String type, int age, String lenguage, String metodology, String department) {
        if (search(name) != null) {
            System.out.println(getEmployeeStatus() + " \"" + name + "\" already exists");
        } else {
            employees.add(new Employee(name, type, age, department));
        }
    }
}
