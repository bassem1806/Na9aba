package com.example.Securite_Routiere.entities;


import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
@Entity
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long AgentId;

    @NotBlank(message = "CIN ")
    @Column(name = "CIN")
    private long  CIN;

    @NotBlank(message = "CNRPS ")
    @Column(name = "CNRPS")
    private long  CNRPS;

    @NotBlank(message = "nom est obligatoire ")
    @Column(name = "NOM")
    private String Nom;

    @NotBlank(message = "Prenom est obligatoire ")
    @Column(name = "Prenom")
    private String Prenom;

    @NotBlank(message = "Prenom Pere est obligatoire ")
    @Column(name = "Prenom_Pere")
    private String Prenom_Pere;

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

//********* Getter AND Setter******//
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


}
