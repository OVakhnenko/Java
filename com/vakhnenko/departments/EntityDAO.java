package com.vakhnenko.departments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract class EntityDAO {
    protected String employeeStatus = "";
    protected List<Entity> employees = new ArrayList<>();

    List<Entity> getAll() {
        return Collections.unmodifiableList(employees);
    }

    void delete(String name) {
        Entity tmp;

        if ((tmp = search(name)) == null) {
            System.out.println(employeeStatus + " \"" + name + "\" not found!");
        } else {
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
}

