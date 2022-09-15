package com.example.Securite_Routiere.entities;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Concour {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ConcourId;


    @NotBlank(message = " Concour est obligatoire ")
    @Column(name = "concour_name")
    private String name;

    public long getConcourId() {
        return ConcourId;
    }

    public void setConcourId(long concoursId) {
        ConcourId = concoursId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Concour(long concourId, String name) {
        ConcourId = concourId;
        this.name = name;
    }

    public Concour() {
    }
}
