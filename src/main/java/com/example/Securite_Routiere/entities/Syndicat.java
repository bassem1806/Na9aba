package com.example.Securite_Routiere.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Syndicat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long SynId;


    @Column(name = "NomSyndicat")
    private String NomSyndicat;

    @Column(name = "CodeSyndicat")
    private int CodeSyndicat;

    @Column(name = "etatSyn")
    private int etatSyn;


    /**** Many To many Syndicat   ****/
    @ManyToMany
    @JoinTable(name = "Agent_Syndicat",
            joinColumns = @JoinColumn(name = "syndicat_id"),
            inverseJoinColumns = @JoinColumn(name = "agent_id"))
    private Set<Agent> agents;

    public Syndicat(long synId, String nomSyndicat, int codeSyndicat, int etatSyn, Set<Agent> agents) {
        SynId = synId;
        NomSyndicat = nomSyndicat;
        CodeSyndicat = codeSyndicat;
        this.etatSyn = etatSyn;
        this.agents = agents;
    }

    public Syndicat() {
    }

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

    public Set<Agent> getAgents1() {
        return agents;
    }

    public void setAgents1(Set<Agent> agents1) {
        this.agents = agents;
    }
}
