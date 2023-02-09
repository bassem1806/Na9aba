package com.example.Securite_Routiere.entities;

import javax.persistence.*;

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
 /*   @ManyToMany
    @JoinTable(name = "Agent_Syndicat",
            joinColumns = @JoinColumn(name = "syndicat_id"),
            inverseJoinColumns = @JoinColumn(name = "agent_id"))
    private Set<Agent> agents;
*/
    public Syndicat(long synId, String nomSyndicat, int codeSyndicat, int etatSyn) {
        SynId = synId;
        NomSyndicat = nomSyndicat;
        CodeSyndicat = codeSyndicat;
        this.etatSyn = etatSyn;

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


}
