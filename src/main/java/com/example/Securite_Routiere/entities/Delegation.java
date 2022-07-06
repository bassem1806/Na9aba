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
public class Delegation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long delegationId;

    @NotBlank(message = "Delegation nom est oblogatoire ")
    @Column(name = "delegation_name")
    private String name;






    /**** Many To One  gov****/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "gouvernoratId", referencedColumnName="gouvernoratId" ,nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private  Gouvernorat gouvernorat;


    public long getDelegation_id() {
        return delegationId;
    }

    public void setDelegation_id(long delegation_id) {
        this.delegationId = delegation_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Delegation( String name) {

        this.name = name;

    }

    public Delegation() {
    }
}
