package com.example.Securite_Routiere.entities;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
public class PvAccident1 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String dateaccid;

    @Column(name = "numimatric")
    private long numimatric;

    @Column(name = "numbarquia")
    private long numbarquia;

    @Column(name = "addreaccid")
    private String addreaccid;


    /**** Many To One unite ****/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "unite_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Unite unite;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDateaccid() {
        return dateaccid;
    }

    public void setDateaccid(String dateaccid) {
        this.dateaccid = dateaccid;
    }

    public long getNumimatric() {
        return numimatric;
    }

    public void setNumimatric(long numimatric) {
        this.numimatric = numimatric;
    }

    public long getNumbarquia() {
        return numbarquia;
    }

    public void setNumbarquia(long numbarquia) {
        this.numbarquia = numbarquia;
    }

    public String getAddreaccid() {
        return addreaccid;
    }

    public void setAddreaccid(String addreaccid) {
        this.addreaccid = addreaccid;
    }

    public Unite getUnite() {
        return unite;
    }

    public void setUnite(Unite unite) {
        this.unite = unite;
    }

    public PvAccident1(long id, String dateaccid, long numimatric, long numbarquia, String addreaccid) {
        this.id = id;
        this.dateaccid = dateaccid;
        this.numimatric = numimatric;
        this.numbarquia = numbarquia;
        this.addreaccid = addreaccid;
    }

    public PvAccident1() {
    }
}
