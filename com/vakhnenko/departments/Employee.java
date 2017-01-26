package com.vakhnenko.departments;

public class Employee extends Entity {
    protected int age;
    protected String type;

    protected Employee(String name, String type, int age) {
        super(name);
        this.age = age;
        this.type = type;
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
