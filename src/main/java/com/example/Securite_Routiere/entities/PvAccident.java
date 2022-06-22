package com.example.Securite_Routiere.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;


@Entity
public class PvAccident {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long numpv;

    /**** Many To One cause accident ****/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cacCode", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CauseAccident causeAccident;

    /**** Many To One delegation ****/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "delegid", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Delegation delegation;


    /**** Many To One part****/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "prtCode", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Part part;


    /**** Many To One Signaux de circulation ****/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sigCode", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SignauxCirculation signauxCirculation;

    /**** Many To One situation route ****/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sitCode", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SituationRoute situationRoute;

    /**** Many To One temps ****/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tmpCode", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Temps temps;

    /**** Many To One type route ****/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rteCode", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private TypeRoute typeRoute;

    /**** Many To One unite ****/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "untCode", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Unite unite;

}
