package com.vakhnenko.departments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract class EntityDAO {
    protected List<Entity> employees = new ArrayList<>();
    private String employeeStatus = "";

    void add(Entity entiny) {
        employees.add(entiny);
    }

    void delete(String name) {
        Entity tmp;

        if ((tmp = search(name)) == null) {
            System.out.println(employeeStatus + " \"" + name + "\" not found!");
        } else {
            System.out.println(employeeStatus + " \"" + name + "\" removed.");
            employees.remove(tmp);
        }
    }

    Entity search(String name) {
        Entity result = null;
        for (Entity employee : employees) {
            if (employee.getName().equals(name)) {
                result = employee;
                break;
            }
        }
        return result;
    }

    boolean exists(String name) {
        return search(name) != null;
    }

    void printAll() {
        if (employees.size() > 0) {
            for (Entity employee : employees) {
                print(employee);
            }

        } else {
            System.out.println("No " + employeeStatus.toLowerCase() +
                    ". Type \"create\" for create first " + employeeStatus.toLowerCase() + ".");
        }
    }

    private void print(Entity employee) {
        System.out.println(employeeStatus + " name \"" + employee.getName() + "\"");
    }

    void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    String getEmployeeStatus() {
        return employeeStatus;
    }

    int getSize() {
        return employees.size();
    }

    List<Entity> getAll() {
        return Collections.unmodifiableList(employees);
    }
}

