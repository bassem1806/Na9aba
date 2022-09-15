package com.example.Securite_Routiere.entities;


import javax.persistence.*;

@Entity
public class Specialite {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long SpecialiteId;


    @Column(name = "Specialite")
    private String Specialitename;

    public long getSpecialiteId() {
        return SpecialiteId;
    }

    public void setSpecialiteId(long specialiteId) {
        SpecialiteId = specialiteId;
    }

    public String getSpecialitename() {
        return Specialitename;
    }

    public void setSpecialitename(String specialitename) {
        Specialitename = specialitename;
    }

    public Specialite(long specialiteId, String specialitename) {
        SpecialiteId = specialiteId;
        Specialitename = specialitename;
    }

    public Specialite() {
    }
}
