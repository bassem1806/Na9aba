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
    private String numimatric;

    @Column(name = "numbarquia")
    private long numbarquia;

    @Column(name = "addreaccid")
    private String addreaccid;


    /**** Many To One unite ****/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "unite_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Unite unite;





    /**** Many To One delegation ****/

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "delegation_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Delegation delegation;

    public Gouvernorat getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(Gouvernorat gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    /**** Many To One gov ****/

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "gouvernorat_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Gouvernorat gouvernorat;

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

    public String getNumimatric() {
        return numimatric;
    }

    public void setNumimatric(String numimatric) {
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


    public Delegation getDelegation() {
        return delegation;
    }

    public void setDelegation(Delegation delegation) {
        this.delegation = delegation;
    }


    public PvAccident1(long id, String dateaccid, String numimatric, long numbarquia, String addreaccid) {
        this.id = id;
        this.dateaccid = dateaccid;
        this.numimatric = numimatric;
        this.numbarquia = numbarquia;
        this.addreaccid = addreaccid;
    }

    public PvAccident1() {
    }
}
