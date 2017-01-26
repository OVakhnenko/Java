package com.vakhnenko.departments;

public abstract class Entity {
    protected int ID;
    protected String name;
    private static int uniqueID;

    protected Entity(String name) {//, String type, int age) {
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
