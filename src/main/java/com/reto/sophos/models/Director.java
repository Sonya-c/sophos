
package com.reto.sophos.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

}
