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
 /*   @ManyToMany
    @JoinTable(name = "Agent_Syndicat",
            joinColumns = @JoinColumn(name = "syndicat_id"),
            inverseJoinColumns = @JoinColumn(name = "agent_id"))
    private Set<Agent> agents1;
*/
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
/*
    public Set<Agent> getAgents() {
        return agents1;
    }

    public void setAgents(Set<Agent> agents) {
        this.agents1 = agents1;
    }
*/
    public Syndicat(long synId, String nomSyndicat, int codeSyndicat, int etatSyn) {
        SynId = synId;
        NomSyndicat = nomSyndicat;
        CodeSyndicat = codeSyndicat;
        this.etatSyn = etatSyn;
      //  this.agents1 = agents1;
    }

    public Syndicat() {
    }
}
