package com.example.Securite_Routiere.entities;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class SousDirection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long SdId ;

    @NotBlank(message = "nom Sous Direction is mandatory")
    @Column(name = "NomSDir")
    private String NomSDir;

    @NotBlank(message = "Code Sous Dir  is mandatory ")
    @Column(name = "CodeSDir")
    private int CodeDir;

    @Column(name = "etat")
    private int etat;

    /**** Many To One direction ****/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "direction_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private  Direction direction;

    /**** Many To One direction general ****/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "directiong_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private DirectionGeneral directionGeneral;

    public long getSdId() {
        return SdId;
    }

    public void setSdId(long sdId) {
        SdId = sdId;
    }

    public String getNomSDir() {
        return NomSDir;
    }

    public void setNomSDir(String nomSDir) {
        NomSDir = nomSDir;
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

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public DirectionGeneral getDirectionGeneral() {
        return directionGeneral;
    }

    public void setDirectionGeneral(DirectionGeneral directionGeneral) {
        this.directionGeneral = directionGeneral;
    }

    public SousDirection(long sdId, String nomSDir, int codeDir, int etat, Direction direction, DirectionGeneral directionGeneral) {
        SdId = sdId;
        NomSDir = nomSDir;
        CodeDir = codeDir;
        this.etat = etat;
        this.direction = direction;
        this.directionGeneral = directionGeneral;
    }

    public SousDirection() {
    }
}
