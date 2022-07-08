package com.example.Securite_Routiere.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity

@ToString

public class SituationRoute {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)

    private long situationrouteId;

    @NotBlank(message = "Situation de la route ")
    @Column(name = "sitroute_name")
    private String name;


    public long getId() {
        return situationrouteId;
    }

    public void setId(long id) {
        this.situationrouteId = situationrouteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SituationRoute(long sitrouteId, String name) {
        this.situationrouteId = sitrouteId;
        this.name = name;
    }

    public SituationRoute() {
    }
}
