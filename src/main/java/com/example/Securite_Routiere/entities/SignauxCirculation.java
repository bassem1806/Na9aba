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
public class SignauxCirculation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Signecirculationid")
    private long sigCode;

    @NotBlank(message = "Cause Accident est obligatoire ")
    @Column(name = "SigneCirculation")
    private String sigDsgar;

}
