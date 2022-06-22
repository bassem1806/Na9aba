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
public class Nationalite {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "Nationaliteid")
private long natCode;


    @NotBlank(message = "Nationalité est obligatoire")
    @Column(name = "Nationalite")
    private String natDsgar;
}
