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
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DescriptionAccident {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="descrpaccdid")
    private long dacCode;
@NotBlank(message = "la description est oblogatoir ")
@Column(name="descrpaccd")
    private String dacDsgar;

    /**** Many To One ****/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cacCode", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CauseAccident causeAccident;


}
