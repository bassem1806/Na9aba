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

    private long id;

    @NotBlank(message = "Participant obligatoir ")
    @Column(name = "part_name")
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

    public Part(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Part() {
    }
}
