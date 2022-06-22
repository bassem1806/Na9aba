package com.example.Securite_Routiere.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class mois {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long MOI_CODE;
    private String MOI_DSGAR;

}

