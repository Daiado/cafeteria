package com.cafeteria.order.model;


import jakarta.persistence.Entity;

import java.util.UUID;


@Entity(name ="account")
public class User extends EntityBase {

    public User(){}

    public User(UUID id){
        this.setId(id);
    }

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
