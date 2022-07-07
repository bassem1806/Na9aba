package com.example.Securite_Routiere.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity

@ToString
public class Unite {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private long uniteId;


    @NotBlank(message = "le nom de l'unité est obligatoir ")
    @Column(name = "unite_name")
    private String name;

    public long getId() {
        return uniteId;
    }

    public void setId(long id) {
        this.uniteId = uniteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Unite(long uniteId, String name) {
        this.uniteId = uniteId;
        this.name = name;
    }

    public Unite() {
    }
}
