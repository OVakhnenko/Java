package com.vakhnenko.departments;

import java.util.UUID;

public abstract class Employee {
    protected int ID;
    protected int age;
    protected String name;
    protected String type;
    private static int uniqueID;

    public Employee(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.ID = uniqueID++;
    }

    protected int getID() {
        return ID;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getName() {
        return name;
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
}
