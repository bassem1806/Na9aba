package com.example.Securite_Routiere.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class DirectionGeneral {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int DirectionGeneralId;

    @NotBlank(message = "Code Direction generale est vide ")
    @Column(name = "Code Dorection General")
    private long  CodeDirectionGeneral;

    @NotBlank(message = "Libelle Direction  General est obligatoire ")
    @Column(name = "LibelleDirection General")
    private String LibelleDirectionGeneral;




}
