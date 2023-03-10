package com.example.Securite_Routiere.entities;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
public class Direction implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long DId;

    @NotBlank(message = "nom Direction is mandatory")
    @Column(name = "NomDir")
    private String NomDir;


    @Column(name = "CodeDir")
    private int CodeDir;

    @Column(name = "etatD")
    private int etatD;

    //********* many to one direction general*******//

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DirectionGeneral_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private DirectionGeneral directionGeneral;

    public Direction(long DId, String nomDir, int codeDir, int etatD, DirectionGeneral directionGeneral) {
        this.DId = DId;
        this.NomDir = nomDir;
       this.CodeDir = codeDir;
        this.etatD = etatD;
        this.directionGeneral = directionGeneral;
    }

    public Direction() {
    }

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

    public int getEtatD() {
        return etatD;
    }

    public void setEtatD(int etatD) {
        this.etatD = etatD;
    }

    public DirectionGeneral getDirectionGeneral() {
        return directionGeneral;
    }

    public void setDirectionGeneral(DirectionGeneral directionGeneral) {
        this.directionGeneral = directionGeneral;
    }
}
