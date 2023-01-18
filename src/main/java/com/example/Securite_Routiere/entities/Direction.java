package com.example.Securite_Routiere.entities;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Direction {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long DId ;

    @NotBlank(message = "nom Direction is mandatory")
    @Column(name = "NomDir")
    private String NomDir;

    @NotBlank(message = "Code Dirc  is mandatory ")
    @Column(name = "CodeDir")
    private int CodeDir;

    @Column(name = "etat")
    private int etat;

    //********* many to one direction general*******//

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "directiong_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private DirectionGeneral directionGeneral ;

    public long getDId() {
        return DId;
    }

    public void setDId(long DId) {
        this.DId = DId;
    }

    public String getNomDir() {
        return NomDir;
    }

    public void setNomDir(String nomDir) {
        NomDir = nomDir;
    }

    public int getCodeDir() {
        return CodeDir;
    }

    public void setCodeDir(int codeDir) {
        CodeDir = codeDir;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public DirectionGeneral getDirectionGeneral() {
        return directionGeneral;
    }

    public void setDirectionGeneral(DirectionGeneral directionGeneral) {
        this.directionGeneral = directionGeneral;
    }


    public Direction(long DId, String nomDir, int codeDir, int etat, DirectionGeneral directionGeneral) {
        this.DId = DId;
        NomDir = nomDir;
        CodeDir = codeDir;
        this.etat = etat;
        this.directionGeneral = directionGeneral;
    }

    public Direction() {
    }
}
