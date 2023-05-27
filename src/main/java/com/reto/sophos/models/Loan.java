package com.reto.sophos.models;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;

@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date loanDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date returnDate;

    private boolean status; 
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "videogame_unit_id")
    private VideogameUnit videogameUnit;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName="id")
    private Client client;

    public int getId() {
        return id;
    }
    
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date date) {
        loanDate = date;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date date) {
        returnDate = date;
    }

    public VideogameUnit getVideogameUnit() {
        return videogameUnit;
    }

    public void setVideogameUnit(VideogameUnit videogameUnit) {
        this.videogameUnit = videogameUnit;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
