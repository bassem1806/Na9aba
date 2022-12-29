package com.example.Securite_Routiere.entities;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Direction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int DirectionId;

    @NotBlank(message = "Code Direction  est vide ")
    @Column(name = "Code Dorection ")
    private long  CodeDirection;

    @NotBlank(message = "Libelle Direction   est obligatoire ")
    @Column(name = "LibelleDirection ")
    private String LibelleDirection;

    /**** Many To One DirectionGeneral ****/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DirectionGeneral_Id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private DirectionGeneral directionGeneral;


//****** getter and Setter***//

    public int getDirectionId() {
        return DirectionId;
    }

    public void setDirectionId(int directionId) {
        DirectionId = directionId;
    }

    public long getCodeDirection() {
        return CodeDirection;
    }

    public void setCodeDirection(long codeDirection) {
        CodeDirection = codeDirection;
    }

    public String getLibelleDirection() {
        return LibelleDirection;
    }

    public void setLibelleDirection(String libelleDirection) {
        LibelleDirection = libelleDirection;
    }

    public DirectionGeneral getDirectionGeneral() {
        return directionGeneral;
    }

    public void setDirectionGeneral(DirectionGeneral directionGeneral) {
        this.directionGeneral = directionGeneral;
    }

    public Direction(int directionId, long codeDirection, String libelleDirection, DirectionGeneral directionGeneral) {
        DirectionId = directionId;
        CodeDirection = codeDirection;
        LibelleDirection = libelleDirection;
        this.directionGeneral = directionGeneral;
    }


}
