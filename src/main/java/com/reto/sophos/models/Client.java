package com.reto.sophos.models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client {
    @Id
    private int id;
    private String username;
    private String names;
    private String lastnames;
    private String email;
    private String cellphone;
    private String address;
    private Date birthdate;

    public int getId() {
        return id;
    }

    public String getNames() {
        return names;
    }
    
    public void setNames(String names) {
        this.names = names;
    }

    public String getLastnames() {
        return lastnames;
    }

    public String getUsername() {
        return username;
    }
    
    public void setLastnames(String lastnames) {
        this.lastnames = lastnames;
    }

    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthdate() {
        return birthdate;
    }
    
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
}