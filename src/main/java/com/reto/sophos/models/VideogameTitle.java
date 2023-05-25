package com.reto.sophos.models;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
@Entity
@Table(name = "videogame_title")
public class VideogameTitle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "realise_date")
    private Date realiseDate;
    
    private double loanPrice;

    private String protagonists;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "director_id")
    private Director director;
  
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "producer_id")
    private Producer producer;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "platform_id")
    private Platform platform;

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getRealiseDate(){
        return realiseDate;
    }

    public double getLoanPrice() {
        return loanPrice;
    }

    public String getProtagonists() {
        return protagonists;
    }

    public Director getDirector() {
        return director;
    }

    public Producer getProducer() {
        return producer;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRealiseDate(Date realiseDate) { 
        this.realiseDate = realiseDate;
    }

    public void setLoanPrice(double loanPrice) {
        this.loanPrice = loanPrice;
    }

    public void setProtagonists(String protagonists) {
        this.protagonists = protagonists;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }
} 
