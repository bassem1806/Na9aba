package com.example.Securite_Routiere.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class SousDirection implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sdId;


    @Column(name = "NomSDir")
    private String nomSDir;


    @Column(name = "CodeSDir")
    private Integer codeSDir;

    @Column(name = "etatSD")
    private Integer etatSD;

    /**** Many To One direction ****/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "direction_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Direction direction;


    public SousDirection(long sdId, String nomSDir, int codeSDir, int etatSD, Direction direction) {
        this.sdId = sdId;
        this.nomSDir = nomSDir;
        this.codeSDir = codeSDir;
        this.etatSD = etatSD;
        this.direction = direction;

    }

    public Long getSdId() {
        return sdId;
    }

    public void setSdId(Long sdId) {
        this.sdId = sdId;
    }

    public String getNomSDir() {
        return nomSDir;
    }

    public void setNomSDir(String nomSDir) {
        this.nomSDir = nomSDir;
    }

    public Integer getCodeSDir() {
        return codeSDir;
    }

    public void setCodeSDir(Integer codeSDir) {
        this.codeSDir = codeSDir;
    }

    public Integer getEtatSD() {
        return etatSD;
    }

    public void setEtatSD(Integer etatSD) {
        this.etatSD = etatSD;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public SousDirection() {
    }

    @Override
    public String toString() {
        return "SousDirection [" + sdId + ']';
    }
}
