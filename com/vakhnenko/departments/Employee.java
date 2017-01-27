package com.vakhnenko.departments;

import java.io.FileWriter;
import java.io.IOException;

import static com.vakhnenko.departments.Constants.*;

class Employee extends Entity {
    private int age;
    private String type;
    private String department;

    protected Employee(String name, String type, int age, String department) {
        super(name);
        this.age = age;
        this.type = type;
        this.department = department;
    }

    protected void setAge(int age) {
        this.age = age;
    }

    protected int getAge() {
        return age;
    }

    protected void setType(String type) {
        this.type = type;
    }

    protected String getType() {
        return type;
    }

    protected void setDepartment(String department) {
        this.department = department;
    }

    protected String getDepartment() {
        return department;
    }

    boolean save(FileWriter writer) throws IOException {
        //  create -e -n Ivan3 Ivanovich3 -t d -a 23 -l Java -dn 222 2222 22222"
        try {
            writer.write(CREATE_COMMAND + " " + EMPLOYEE_KEY + " " + NAME_EMPLOYEE_KEY + " " + getName() + " ");
            writer.write(TYPE_EMPLOYEE_KEY + " " + getType() + " ");
            writer.write(AGE_EMPLOYEE_KEY + " " + getAge() + " ");
            writer.write(DEPARTMENT_EMPLOYEE_KEY + " " + getDepartment() + " ");
            writer.flush();
            return true;
        } catch (IOException e) {
            System.out.println("Write error!");
            return false;
        }
    }

    void writeln(FileWriter writer) throws IOException {
        try {
            writer.write("\n");
        } catch (IOException e) {
            System.out.println("WriteLn error!");
        }
    }
}
