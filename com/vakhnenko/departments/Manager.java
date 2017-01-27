package com.vakhnenko.departments;

import java.io.FileWriter;
import java.io.IOException;

import static com.vakhnenko.departments.Constants.*;

class Manager extends Employee {
    private String methodology;

    protected Manager(String name, String type, int age, String department, String methodology) {
        super(name, type, age, department);
        this.methodology = methodology;
    }

    protected void setMethodology(String methodology) {
        this.methodology = methodology;
    }

    protected String getMethodology() {
        return methodology;
    }

    boolean save(FileWriter writer) throws IOException {
        super.save(writer);
        try {
            writer.write(METHODOLOGY_EMPLOYEE_KEY + " " + getMethodology() + " ");
            writer.flush();
            return true;
        } catch (IOException e) {
            System.out.println("Write error!");
            return false;
        }
    }
}
