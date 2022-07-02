package com.example.Securite_Routiere.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity

@ToString
public class SignauxCirculation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;

    @NotBlank(message = "Cause Accident est obligatoire ")
    @Column(name = "SigneCirculation_name")
    private String name;

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

    public SignauxCirculation(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public SignauxCirculation() {
    }
}
