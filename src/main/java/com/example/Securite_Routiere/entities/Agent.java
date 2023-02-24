package com.example.Securite_Routiere.entities;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

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
    private String dateInscription;


    @Column(name = "agent_saisie")
    private String agentSaisie;

    @Column(name = "date_saisie")
    private String dateSaisie;

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

    public Agent(long agentId, long CIN, long CNRPS, String nom, String prenom,String agentSaisie,String dateSaisie ,String prenom_Pere, String dateInscription ,Delegation delegation, Grade grade, SousDirection sousDirection, Syndicat syndicat) {
        AgentId = agentId;
        this.CIN = CIN;
        this.CNRPS = CNRPS;
        Nom = nom;
        Prenom = prenom;
        Prenom_Pere = prenom_Pere;
       this.dateInscription = dateInscription;
        this.delegation = delegation;
        this.grade = grade;
        this.sousDirection = sousDirection;
        this.syndicat = syndicat;

        this.agentSaisie = agentSaisie;
        this.dateSaisie =dateSaisie;
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

    public void setCNRPS(long cnrpsR) {
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
        return dateInscription;
    }

    public void setDateInscription(String dateInscription) {
        this.dateInscription = dateInscription;
    }

    public Delegation getDelegation() {
        return delegation;
    }

    public void setDelegation(Delegation delegation) {
        this.delegation = delegation;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public SousDirection getSousDirection() {
        return sousDirection;
    }

    public void setSousDirection(SousDirection sousDirection) {
        this.sousDirection = sousDirection;
    }

    public Syndicat getSyndicat() {
        return syndicat;
    }

    public void setSyndicat(Syndicat syndicat) {
        this.syndicat = syndicat;
    }

    public String getAgentSaisie() {
        return agentSaisie;
    }

    public void setAgentSaisie(String agentSaisie) {
        this.agentSaisie = agentSaisie;
    }

    public String getDateSaisie() {
        return dateSaisie;
    }

    public void setDateSaisie(String dateSaisie) {
        this.dateSaisie = dateSaisie;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "delegation=" + delegation +
                ", grade=" + grade +
                ", sousDirection=" + sousDirection +
                ", syndicat=" + syndicat +
                '}';
    }

    public void setDateSaisie(DateTimeFormatter ofLocalizedTime) {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agent agent = (Agent) o;
        return AgentId == agent.AgentId && CIN == agent.CIN && CNRPS == agent.CNRPS && Objects.equals(Nom, agent.Nom) && Objects.equals(Prenom, agent.Prenom) && Objects.equals(Prenom_Pere, agent.Prenom_Pere) && Objects.equals(dateInscription, agent.dateInscription) && Objects.equals(agentSaisie, agent.agentSaisie) && Objects.equals(dateSaisie, agent.dateSaisie) && Objects.equals(delegation, agent.delegation) && Objects.equals(grade, agent.grade) && Objects.equals(sousDirection, agent.sousDirection) && Objects.equals(syndicat, agent.syndicat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(AgentId, CIN, CNRPS, Nom, Prenom, Prenom_Pere, dateInscription, agentSaisie, dateSaisie, delegation, grade, sousDirection, syndicat);
    }

    public void setCIN() {
    }

    public void setCNRPS() {


    }

    public void setGrade() {
    }

    public void setSousDirection(String sousDirectionR) {
    }




}
