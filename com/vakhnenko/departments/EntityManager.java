package com.vakhnenko.departments;

class EntityManager extends Entity {

    EntityManager(String name, Entity something) {
        this.name = name.trim();

        if (something != null) {
            //something.setNext(this);
            //setPrev(something);
        }
    }

}
