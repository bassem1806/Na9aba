package com.example.Securite_Routiere.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class SituationRoute {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sitrouteid")
    private long sitCode;

    @NotBlank(message = "Situation de la route ")
    @Column(name = "sitroute")
    private String sitDsgar;


}
