package com.example.Securite_Routiere.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class AgentR {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long agentRId;


    @Column(name = "CIN")
    private long cinR;


    @Column(name = "CNRPS")
    private String cnrpsR;


    @Column(name = "NOM")
    private String nomR;

    @NotBlank(message = "Prenom est obligatoire ")
    @Column(name = "Prenom")
    private String prenomR;

    @NotBlank(message = "Prenom Pere est obligatoire ")
    @Column(name = "Prenom_Pere")
    private String prenomPereR;





    @Column(name = "DirectionGenearl")
    private String directionGeneralR;

    @Column(name = "Direction")
    private String directionR;

    @Column(name = "sousDirection")
    private String sousDirectionR;

    @Column(name = "Grade")
    private String gradeR;


    @Column(name = "dateInsecription")
    private String dateR;

    public long getAgentRId() {
        return agentRId;
    }

    public void setAgentRId(long agentRId) {
        this.agentRId = agentRId;
    }

    public long getCinR() {
        return cinR;
    }

    public void setCinR(long cinR) {
        this.cinR = cinR;
    }

    public String getCnrpsR() {
        return cnrpsR;
    }

    public void setCnrpsR(String cnrpsR) {
        this.cnrpsR = cnrpsR;
    }

    public String getNomR() {
        return nomR;
    }

    public void setNomR(String nomR) {
        this.nomR = nomR;
    }

    public String getPrenomR() {
        return prenomR;
    }

    public void setPrenomR(String prenomR) {
        this.prenomR = prenomR;
    }

    public String getPrenomPereR() {
        return prenomPereR;
    }

    public void setPrenomPereR(String prenomPereR) {
        this.prenomPereR = prenomPereR;
    }



    public String getDirectionGeneralR() {
        return directionGeneralR;
    }

    public void setDirectionGeneralR(String directionGeneralR) {
        this.directionGeneralR = directionGeneralR;
    }

    public String getDirectionR() {
        return directionR;
    }

    public void setDirectionR(String directionR) {
        this.directionR = directionR;
    }

    public String getSousDirectionR() {
        return sousDirectionR;
    }

    public void setSousDirectionR(String sousDirectionR) {
        this.sousDirectionR = sousDirectionR;
    }

    public String getGradeR() {
        return gradeR;
    }

    public void setGradeR(String gradeR) {
        this.gradeR = gradeR;
    }

    public String getDateR() {
        return dateR;
    }

    public void setDateR(String dateR) {
        this.dateR = dateR;
    }

    public AgentR(long agentRId, long cinR, String cnrpsR, String nomR, String prenomR, String prenomPereR, String directionGeneralR, String directionR, String sousDirectionR, String gradeR, String dateR) {
        this.agentRId = agentRId;
        this.cinR = cinR;
        this.cnrpsR = cnrpsR;
        this.nomR = nomR;
        this.prenomR = prenomR;
        this.prenomPereR = prenomPereR;
        this.directionGeneralR = directionGeneralR;
        this.directionR = directionR;
        this.sousDirectionR = sousDirectionR;
        this.gradeR = gradeR;
        this.dateR = dateR;
    }

    public AgentR() {
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "AgentR{" +
                "agentRId=" + agentRId +
                ", cinR=" + cinR +
                ", cnrpsR='" + cnrpsR + '\'' +
                ", nomR='" + nomR + '\'' +
                ", prenomR='" + prenomR + '\'' +
                ", prenomPereR='" + prenomPereR + '\'' +
                ", directionGeneralR='" + directionGeneralR + '\'' +
                ", directionR='" + directionR + '\'' +
                ", sousDirectionR='" + sousDirectionR + '\'' +
                ", gradeR='" + gradeR + '\'' +
                ", dateR='" + dateR + '\'' +
                '}';
    }
}
