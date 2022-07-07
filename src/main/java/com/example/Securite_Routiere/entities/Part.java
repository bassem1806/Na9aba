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

    private long partId;

    @NotBlank(message = "Participant obligatoir ")
    @Column(name = "part_name")
    private String name;

    public long getId() {
        return partId;
    }

    public void setId(long id) {
        this.partId = partId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Part(long partId, String name) {
        this.partId = partId;
        this.name = name;
    }

    public Part() {
    }
}
