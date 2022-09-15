package com.example.Securite_Routiere.entities;


import javax.persistence.*;

@Entity
public class Niveau {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long NiveautId;


    @Column(name = "Niveau")
    private String Niveauname;

    public long getNiveautId() {
        return NiveautId;
    }

    public void setNiveautId(long niveautId) {
        NiveautId = niveautId;
    }

    public String getNiveauname() {
        return Niveauname;
    }

    public void setNiveauname(String niveauname) {
        Niveauname = niveauname;
    }

    public Niveau(long niveautId, String niveauname) {
        NiveautId = niveautId;
        Niveauname = niveauname;
    }

    public Niveau() {
    }

}
