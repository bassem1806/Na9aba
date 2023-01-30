package com.example.Securite_Routiere.entities;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class SousDirection{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long SdId ;


    @Column(name = "NomSDir")
    private String NomSDir;


    @Column(name = "CodeSDir")
    private int CodeSDir;

    @Column(name = "etatSD")
    private int etatSD;

    /**** Many To One direction ****/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "direction_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private  Direction direction;


    public long getSdId() {
        return SdId;
    }

    public void setSdId(long sdId) {
        this.SdId = sdId;
    }


    public String getNomSDir() {
        return NomSDir;
    }

    public void setNomSDir(String nomSDir) {
        NomSDir = nomSDir;
    }

    public int getCodeSDir() {
        return CodeSDir;
    }

    public void setCodeSDir(int codeSDir) {
        CodeSDir = codeSDir;
    }

    public int getEtatSD() {
        return etatSD;
    }

    public void setEtatSD(int etatSD) {
        this.etatSD = etatSD;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
/*
    public DirectionGeneral getDirectionGeneral() {
        return directionGeneral;
    }

    public void setDirectionGeneral(DirectionGeneral directionGeneral) {
        this.directionGeneral = directionGeneral;
    }
*/
    public SousDirection(long sdId, String nomSDir, int codeSDir, int etatSD, Direction direction ) {
        SdId = sdId;
        NomSDir = nomSDir;
        CodeSDir = codeSDir;
        this.etatSD = etatSD;
        this.direction = direction;
       // this.directionGeneral = directionGeneral;
    }

    public SousDirection() {
    }


}
