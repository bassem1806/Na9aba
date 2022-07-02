package com.example.Securite_Routiere.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity

@ToString
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long ig;

    @NotBlank(message = "Participant obligatoir ")
    @Column(name = "part_name")
    private String name;

    public long getIg() {
        return ig;
    }

    public void setIg(long ig) {
        this.ig = ig;
    }

    public String getLibelle() {
        return name;
    }

    public void setLibelle(String libelle) {
        this.name = libelle;
    }

    public Part(long ig, String libelle) {
        this.ig = ig;
        this.name = libelle;
    }

    public Part() {
    }
}
