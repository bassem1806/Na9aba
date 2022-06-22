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

public class Temps {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tempsid")
    private long tmpCode;

    @NotBlank(message = "Temps lors de l'accident ")
    @Column(name = "temps")
    private String tmpDsgar;

}
