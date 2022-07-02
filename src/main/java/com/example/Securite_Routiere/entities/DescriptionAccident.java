package com.example.Securite_Routiere.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@ToString
public class DescriptionAccident {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
@NotBlank(message = "la description est oblogatoir ")
@Column(name="descriptionaccident_name")
    private String name;

    /**** Many To One ****/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "causeAccident_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CauseAccident causeAccident;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelle() {
        return name;
    }

    public void setLibelle(String libelle) {
        this.name = libelle;
    }

    public CauseAccident getCauseAccident() {
        return causeAccident;
    }

    public void setCauseAccident(CauseAccident causeAccident) {
        this.causeAccident = causeAccident;
    }

    public DescriptionAccident() {
    }

    public DescriptionAccident(long id, String libelle) {
        this.id = id;
        this.name = libelle;



    }
}
