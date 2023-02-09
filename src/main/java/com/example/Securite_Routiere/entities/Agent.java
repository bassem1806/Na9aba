package com.example.Securite_Routiere.entities;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
public class Agent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long AgentId;


    @Column(name = "CIN")
    private long CIN;


    @Column(name = "CNRPS")
    private long CNRPS;


    @Column(name = "NOM")
    private String Nom;

    @NotBlank(message = "Prenom est obligatoire ")
    @Column(name = "Prenom")
    private String Prenom;

    @NotBlank(message = "Prenom Pere est obligatoire ")
    @Column(name = "Prenom_Pere")
    private String Prenom_Pere;


    @Column(name = "Date_inscription")
    private String DateInscription;

    /**** Many To One delegation ****/

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "delegation_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Delegation delegation;


    /**** Many To One Grade ****/

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "grade_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Grade grade;



    /**** Many To One Sousdirection****/

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sousdirection_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SousDirection sousDirection;

    /**** Many To One syndicat ****/

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "syndicat_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Syndicat syndicat;

    public Agent(long agentId, long CIN, long CNRPS, String nom, String prenom, String prenom_Pere, String dateInscription, Delegation delegation, Grade grade, SousDirection sousDirection, Syndicat syndicat) {
        AgentId = agentId;
        this.CIN = CIN;
        this.CNRPS = CNRPS;
        Nom = nom;
        Prenom = prenom;
        Prenom_Pere = prenom_Pere;
        DateInscription = dateInscription;
        this.delegation = delegation;
        this.grade = grade;
        this.sousDirection = sousDirection;
        this.syndicat = syndicat;
    }

    /**** Many To Many  syndicat****/

/*
    @ManyToMany
    @JoinTable(name = "Agent_Syndicat",
            joinColumns = @JoinColumn(name = "agent_id"),
            inverseJoinColumns = @JoinColumn(name = "syndicat_id"))
    private Set<Syndicat> syndicats;
*/
//********* Getter AND Setter******//




    public Agent() {
    }


    public long getAgentId() {
        return AgentId;
    }

    public void setAgentId(long agentId) {
        AgentId = agentId;
    }

    public long getCIN() {
        return CIN;
    }

    public void setCIN(long CIN) {
        this.CIN = CIN;
    }

    public long getCNRPS() {
        return CNRPS;
    }

    public void setCNRPS(long CNRPS) {
        this.CNRPS = CNRPS;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getPrenom_Pere() {
        return Prenom_Pere;
    }

    public void setPrenom_Pere(String prenom_Pere) {
        Prenom_Pere = prenom_Pere;
    }

    public String getDateInscription() {
        return DateInscription;
    }

    public void setDateInscription(String dateInscription) {
        DateInscription = dateInscription;
    }

    public Delegation getDelegation() {
        return delegation;
    }

    public void setDelegation(Delegation delegation) {
        this.delegation = delegation;
    }

    public SousDirection getSousDirection() {
        return sousDirection;
    }

    public void setSousDirection(SousDirection sousDirection) {
        this.sousDirection = sousDirection;
    }


    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Syndicat getSyndicat() {
        return syndicat;
    }

    public void setSyndicat(Syndicat syndicat) {
        this.syndicat = syndicat;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "AgentId=" + AgentId +
                ", CIN=" + CIN +
                ", CNRPS=" + CNRPS +
                ", Nom='" + Nom + '\'' +
                ", Prenom='" + Prenom + '\'' +
                ", Prenom_Pere='" + Prenom_Pere + '\'' +
                ", DateInscription='" + DateInscription + '\'' +
                ", delegation=" + delegation +
                ", grade=" + grade +
                ", sousDirection=" + sousDirection +
                ", syndicat=" + syndicat +
                '}';
    }
}
