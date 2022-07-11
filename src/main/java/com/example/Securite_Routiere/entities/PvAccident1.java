package com.example.Securite_Routiere.entities;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.List;

@Entity
public class PvAccident1 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long pvaccidId;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String dateaccid;

    @Column(name = "numimatric")
    private String numimatric;

    @Column(name = "numbarquia")
    private long numbarquia;

    @Column(name = "addreaccid")
    private String addreaccid;

    public String getDateimatric() {
        return dateimatric;
    }

    public void setDateimatric(String dateimatric) {
        this.dateimatric = dateimatric;
    }

    @Column(name = "dateimatric")
    private String dateimatric;


    @Column(name = "pointKmaccid")
    private String pointKmaccid;


    /**** Many To One unite ****/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "unite_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Unite unite;





    /**** Many To One delegation ****/

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "delegation_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Delegation delegation;


    public SignauxCirculation getSignauxCirculation() {
        return signauxCirculation;
    }

    public void setSignauxCirculation(SignauxCirculation signauxCirculation) {
        this.signauxCirculation = signauxCirculation;
    }

    /**** Many To One Signaux de circulation ****/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "signe_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SignauxCirculation signauxCirculation;


    /**** Many To One type de route ****/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "typeroute_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private TypeRoute typeRoute;

    /**** Many To One Situation de la route ****/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "situationroute_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SituationRoute situationRoute;


    /**** Many To One temps ****/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "temps_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Temps temps;

    /**** Many To One cause accident ****/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "causeaccident_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CauseAccident causeAccident;





   public long getId() {
        return pvaccidId;
    }

    public void setId(long pvaccidId) {
        this.pvaccidId = pvaccidId;
    }

    public String getDateaccid() {
        return dateaccid;
    }

    public void setDateaccid(String dateaccid) {
        this.dateaccid = dateaccid;
    }

    public String getNumimatric() {
        return numimatric;
    }

    public void setNumimatric(String numimatric) {
        this.numimatric = numimatric;
    }

    public long getNumbarquia() {
        return numbarquia;
    }

    public void setNumbarquia(long numbarquia) {
        this.numbarquia = numbarquia;
    }

    public String getAddreaccid() {
        return addreaccid;
    }

    public void setAddreaccid(String addreaccid) {
        this.addreaccid = addreaccid;
    }

    public Unite getUnite() {
        return unite;
    }

    public void setUnite(Unite unite) {
        this.unite = unite;
    }


    public Delegation getDelegation() {
        return delegation;
    }

    public void setDelegation(Delegation delegation) {
        this.delegation = delegation;
    }


    public String getPointKmaccid() {
        return pointKmaccid;
    }

    public void setPointKmaccid(String pointKmaccid) {
        this.pointKmaccid = pointKmaccid;
    }

    public TypeRoute getTypeRoute() {
        return typeRoute;
    }

    public void setTypeRoute(TypeRoute typeRoute) {
        this.typeRoute = typeRoute;
    }

    public SituationRoute getSituationRoute() {
        return situationRoute;
    }

    public void setSituationRoute(SituationRoute situationRoute) {
        this.situationRoute = situationRoute;
    }

    public Temps getTemps() {
        return temps;
    }

    public void setTemps(Temps temps) {
        this.temps = temps;
    }

    public CauseAccident getCauseAccident() {
        return causeAccident;
    }

    public void setCauseAccident(CauseAccident causeAccident) {
        this.causeAccident = causeAccident;
    }

    public PvAccident1(long pvaccidId, String dateaccid, String numimatric, long numbarquia, String addreaccid, String dateimatric, String pointKmaccid) {
        this.pvaccidId = pvaccidId;
        this.dateaccid = dateaccid;
        this.numimatric = numimatric;
        this.numbarquia = numbarquia;
        this.addreaccid = addreaccid;
        this.dateimatric = dateimatric;
        this.pointKmaccid = pointKmaccid;
    }

    public PvAccident1() {
    }


}
