package com.vakhnenko.departments;

import java.io.FileWriter;
import java.io.IOException;

import static com.vakhnenko.departments.Constants.*;

class Developer extends Employee {
    private String language;

    protected Developer(String name, String type, int age, String department, String language) {
        super(name, type, age, department);
        this.language = language;
    }

    protected void setLanguage(String language) {
        this.language = language;
    }

    protected String getLanguage() {
        return language;
    }

    boolean save(FileWriter writer) throws IOException {
        super.save(writer);
        try {
            writer.write(LANGUAGE_EMPLOYEE_KEY + " " + getLanguage() + " ");
            writer.flush();
            return true;
        } catch (IOException e) {
            System.out.println("Write error!");
            return false;
        }
    }
}
