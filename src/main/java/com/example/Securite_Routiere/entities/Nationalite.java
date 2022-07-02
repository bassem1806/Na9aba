package com.example.Securite_Routiere.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity

@ToString
public class Nationalite {
@Id

private long id;


    @NotBlank(message = "Nationalité est obligatoire")
    @Column(name = "nationalite_name")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelle() {
        return name;
    }

    public void setLibelle(String libelle) {
        this.name = libelle;
    }

    public Nationalite(long id, String libelle) {
        this.id = id;
        this.name = libelle;
    }

    public Nationalite() {
    }
}
