package com.vakhnenko.departments;

abstract class Entity {
    private int ID;
    private String name;
    private static int uniqueID;

    protected Entity(String name) {
        this.name = name;
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
}
