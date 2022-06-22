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
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Delegation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "delegid")
    private long dlgCode;

    @NotBlank(message = "Delegation nom est oblogatoire ")
    @Column(name = "delegation")
    private String dlgDsgar;


    /**** Many To One ****/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "gvrCode", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Gouvernorat gouvernorat;

}
