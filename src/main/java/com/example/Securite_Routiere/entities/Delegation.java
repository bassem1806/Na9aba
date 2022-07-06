package com.example.Securite_Routiere.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity

@ToString
public class Delegation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;

    @NotBlank(message = "Delegation nom est oblogatoire ")
    @Column(name = "delegation_name")
    private String name;


    public PvAccident1 getPvAccident1() {
        return pvAccident1;
    }

    public void setPvAccident1(PvAccident1 pvAccident1) {
        this.pvAccident1 = pvAccident1;
    }

    /**** Many To One  pv accident****/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PvAccident1_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private  PvAccident1 pvAccident1;


    /**** Many To One  gov****/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "gouvernorat_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private  Gouvernorat gouvernorat;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Delegation(long id, String name) {
        this.id = id;
        this.name = name;

    }

    public Delegation() {
    }
}
