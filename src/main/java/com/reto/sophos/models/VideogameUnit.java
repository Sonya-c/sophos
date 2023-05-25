package com.reto.sophos.models;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
@Entity
@Table(name = "videogame_unit")
public class VideogameUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private boolean avaliable_status;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "videogame_title_id")
    private VideogameTitle videogameTitle;
    
    public int getId() {
        return id;
    }

    public boolean getAvaliable_status() {
        return avaliable_status;
    }

    public void setAvaliable_status(boolean status) {
        this.avaliable_status = status;
    }

    public VideogameTitle getVideogameTitle() {
        return videogameTitle;
    }

    public void setVideogameTitle(VideogameTitle videogameTitle) {
        this.videogameTitle = videogameTitle;
    }
}

