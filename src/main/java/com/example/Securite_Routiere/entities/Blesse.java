package com.example.Securite_Routiere.entities;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Blesse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long BlesseId;

    @NotBlank(message = "nom et prenom obligatoire ")
    @Column(name = "NomPrenom_Blesse")
    private String NomPrenom;

    @NotBlank(message = "Cin obligatoire ")
    @Column(name = "Cin_Blesse")
    private int CIN;

    @NotBlank(message = "Sexe obligatoire ")
    @Column(name = "sexe_Blesse")
    private String sexe;


    @NotBlank(message = "Age obligatoire ")
    @Column(name = "age_Blesse")
    private int age;

    @NotBlank(message = "Etat obligatoire ")
    @Column(name = "etat_Blesse")
    private String EtatBlesse;

    @Column(name = "observation_Blesse")
    private String Observation;


    public long getBlesseId() {
        return BlesseId;
    }

    public void setBlesseId(long blesseId) {
        BlesseId = blesseId;
    }

    public String getNomPrenom() {
        return NomPrenom;
    }

    public void setNomPrenom(String nomPrenom) {
        NomPrenom = nomPrenom;
    }

    public int getCIN() {
        return CIN;
    }

    public void setCIN(int CIN) {
        this.CIN = CIN;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEtatBlesse() {
        return EtatBlesse;
    }

    public void setEtatBlesse(String etatBlesse) {
        EtatBlesse = etatBlesse;
    }

    public String getObservation() {
        return Observation;
    }

    public void setObservation(String observation) {
        Observation = observation;
    }


    public Blesse(long blesseId, String nomPrenom, int CIN, String sexe, int age, String etatBlesse, String observation) {
        BlesseId = blesseId;
        NomPrenom = nomPrenom;
        this.CIN = CIN;
        this.sexe = sexe;
        this.age = age;
        EtatBlesse = etatBlesse;
        Observation = observation;
    }

    public Blesse() {
    }
}
