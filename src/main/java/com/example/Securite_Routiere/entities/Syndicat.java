package com.example.Securite_Routiere.entities;

import javax.persistence.*;

@Entity
public class Syndicat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long synId;


    @Column(name = "NomSyndicat")
    private String nomSyndicat;

    @Column(name = "CodeSyndicat")
    private int codeSyndicat;

    @Column(name = "etatSyn")
    private int etatSyn;


    /**** Many To many Syndicat   ****/
 /*   @ManyToMany
    @JoinTable(name = "Agent_Syndicat",
            joinColumns = @JoinColumn(name = "syndicat_id"),
            inverseJoinColumns = @JoinColumn(name = "agent_id"))
    private Set<Agent> agents;
*/

    public long getSynId() {
        return synId;
    }

    public void setSynId(long synId) {
        this.synId = synId;
    }

    public String getNomSyndicat() {
        return nomSyndicat;
    }

    public void setNomSyndicat(String nomSyndicat) {
        this.nomSyndicat = nomSyndicat;
    }

    public int getCodeSyndicat() {
        return codeSyndicat;
    }

    public void setCodeSyndicat(int codeSyndicat) {
        this.codeSyndicat = codeSyndicat;
    }

    public int getEtatSyn() {
        return etatSyn;
    }

    public void setEtatSyn(int etatSyn) {
        this.etatSyn = etatSyn;
    }

    public Syndicat(long synId, String nomSyndicat, int codeSyndicat, int etatSyn) {
        this.synId = synId;
        this.nomSyndicat = nomSyndicat;
        this.codeSyndicat = codeSyndicat;
        this.etatSyn = etatSyn;
    }

    public Syndicat() {
    }
}
