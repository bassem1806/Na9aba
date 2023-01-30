package com.example.Securite_Routiere.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Syndicat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long SynId ;


    @Column(name = "NomSyndicat")
    private String NomSyndicat;

    @Column(name = "CodeSyndicat")
    private int CodeSyndicat;

    @Column(name = "etatSyn")
    private int etatSyn;



    /**** Many To many Syndicat   ****/
    @ManyToMany
    @JoinTable(name = "Agent_Syndicat",
            joinColumns = @JoinColumn(name = "Agent_id"),
            inverseJoinColumns = @JoinColumn(name = "Syndicat_id"))
    private Set<Syndicat> syndicats;

    public long getSynId() {
        return SynId;
    }

    public void setSynId(long synId) {
        SynId = synId;
    }

    public String getNomSyndicat() {
        return NomSyndicat;
    }

    public void setNomSyndicat(String nomSyndicat) {
        NomSyndicat = nomSyndicat;
    }

    public int getCodeSyndicat() {
        return CodeSyndicat;
    }

    public void setCodeSyndicat(int codeSyndicat) {
        CodeSyndicat = codeSyndicat;
    }

    public int getEtatSyn() {
        return etatSyn;
    }

    public void setEtatSyn(int etatSyn) {
        this.etatSyn = etatSyn;
    }

    public Set<Syndicat> getSyndicats() {
        return syndicats;
    }

    public void setSyndicats(Set<Syndicat> syndicats) {
        this.syndicats = syndicats;
    }

    public Syndicat(long synId, String nomSyndicat, int codeSyndicat, int etatSyn, Set<Syndicat> syndicats) {
        SynId = synId;
        NomSyndicat = nomSyndicat;
        CodeSyndicat = codeSyndicat;
        this.etatSyn = etatSyn;
        this.syndicats = syndicats;
    }

    public Syndicat() {
    }
}
