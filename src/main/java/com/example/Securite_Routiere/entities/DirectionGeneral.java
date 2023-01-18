package com.example.Securite_Routiere.entities;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity

public class DirectionGeneral {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long DgId ;

    @NotBlank(message = "nom  is mandatory")
    @Column(name = "NomDirGen")
    private String NomDirGen;

    @Column(name = "CodeDirGen")
    private int CodeDirGen;

    @Column(name = "etat")
    private int etat;

    public long getDgId() {
        return DgId;
    }

    public void setDgId(long dgId) {
        DgId = dgId;
    }

    public String getNomDirGen() {
        return NomDirGen;
    }

    public void setNomDirGen(String nomDirGen) {
        NomDirGen = nomDirGen;
    }

    public int getCodeDirGen() {
        return CodeDirGen;
    }

    public void setCodeDirGen(int codeDirGen) {
        CodeDirGen = codeDirGen;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }


    public DirectionGeneral(long dgId, String nomDirGen, int codeDirGen, int etat) {
        DgId = dgId;
        NomDirGen = nomDirGen;
        CodeDirGen = codeDirGen;
        this.etat = etat;

    }

    public DirectionGeneral() {
    }
}
