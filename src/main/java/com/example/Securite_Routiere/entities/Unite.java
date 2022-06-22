package com.example.Securite_Routiere.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Unite {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "Uniteid")
    private long untCode;
    @NotBlank(message = "le nom de l'unité est obligatoir ")
    @Column(name = "unitenom")
    private String untDsgar;


}
