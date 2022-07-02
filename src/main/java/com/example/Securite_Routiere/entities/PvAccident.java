package com.example.Securite_Routiere.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotNull;
import javax.persistence.*;
import java.util.Date;


@Entity
public class PvAccident {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull
    private Date dateaccid;

    @Column(name = "numimatric")
    private long numimatric;

    public long getNumimatric() {
        return numimatric;
    }

    public void setNumimatric(long numimatric) {
        this.numimatric = numimatric;
    }

    public Date getDateimatric() {
        return dateimatric;
    }

    public void setDateimatric(Date dateimatric) {
        this.dateimatric = dateimatric;
    }

    public long getNumbarquia() {
        return numbarquia;
    }

    public void setNumbarquia(long numbarquia) {
        this.numbarquia = numbarquia;
    }

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull
    @Column(name = "dateimatric")
    private Date dateimatric;

    @Column(name = "numbarquia")
    private long numbarquia;


    /**** Many To One cause accident ****/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "causeaccident_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CauseAccident causeAccident;

    /**** Many To One delegation ****/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "delegation_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Delegation delegation;


    /**** Many To One part****/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "part_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Part part;


    /**** Many To One Signaux de circulation ****/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "signanxcirculation_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SignauxCirculation signauxCirculation;

    /**** Many To One situation route ****/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "situationroute_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SituationRoute situationRoute;

    /**** Many To One temps ****/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "temps_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Temps temps;

    /**** Many To One type route ****/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "typeroute_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private TypeRoute typeRoute;

    /**** Many To One unite ****/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "unite_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Unite unite;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateaccid() {
        return dateaccid;
    }

    public void setDateaccid(Date dateaccid) {
        this.dateaccid = dateaccid;
    }

    public CauseAccident getCauseAccident() {
        return causeAccident;
    }

    public void setCauseAccident(CauseAccident causeAccident) {
        this.causeAccident = causeAccident;
    }

    public Delegation getDelegation() {
        return delegation;
    }

    public void setDelegation(Delegation delegation) {
        this.delegation = delegation;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public SignauxCirculation getSignauxCirculation() {
        return signauxCirculation;
    }

    public void setSignauxCirculation(SignauxCirculation signauxCirculation) {
        this.signauxCirculation = signauxCirculation;
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

    public TypeRoute getTypeRoute() {
        return typeRoute;
    }

    public void setTypeRoute(TypeRoute typeRoute) {
        this.typeRoute = typeRoute;
    }

    public Unite getUnite() {
        return unite;
    }

    public void setUnite(Unite unite) {
        this.unite = unite;
    }

    public PvAccident(long id, Date dateaccid, long numimatric, Date dateimatric, long numbarquia) {
        this.id = id;
        this.dateaccid = dateaccid;
        this.numimatric = numimatric;
        this.dateimatric = dateimatric;
        this.numbarquia = numbarquia;
    }

    public PvAccident() {
    }

}
