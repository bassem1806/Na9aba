package com.example.Securite_Routiere.entities;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
public class Candidat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long candidatId;


    @Column(name = "NumCandidat")
    private String NumCandidat;

    @Column(name = "NomCandidat")
    private String Nom;


    @Column(name = "PrenomCandidat")
    private String Prenom;

    @Column(name = "PrenomPere")
    private String Pere;

    @Column(name = "PrenomGPere")
    private String GPere;

    @Column(name = "PrenomMere")
    private String Mere;

    @Column(name = "SexeCandidat")
    private String Sexe;

    @Column(name = "EtatCandidat")
    private String Etat;


    @Column(name = "FilsCandidat")
    private String Fils;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String DateAnniv;

    @Column(name = "LieuxNaissanceCandidat")
    private String lieux;

    @Column(name = "CinCandidat")
    private String Cin;

    @Column(name = "EmprinteCandidat")
    private String Emprinte;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String DateCin;

    @Column(name = "AdresseCandidat")
    private String Adresse;

    @Column(name = "TelCandidat")
    private String telephone;

    @Column(name = "EmailCandidat")
    private String Email;




    @Column(name = "Bureaudemplois")
    private String Bureaudemplois;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String DateInsBureau;

    @Column(name = "SituationMilitaire")
    private String SituationMilitaire;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String DateInscrit;

    @Column(name = "Unite")
    private String Unite;


    @Column(name = "Paiement")
    private String paiement;

    @Column(name = "Permis")
    private String Permis;

    @Column(name = "NumPermis")
    private String NumPermis;

    @Column(name = "ServiceCivil")
    private String ServiceCivil;

    @Column(name = "DureServiceCivil")
    private String Dureservicecivil;


    public String getDatesaissie() {
        return datesaissie;
    }

    public void setDatesaissie(String datesaissie) {
        this.datesaissie = datesaissie;
    }

    @Column(name = "datesaissie")
    private String datesaissie;

    public String getAgentsaissie() {
        return agentsaissie;
    }

    public void setAgentsaissie(String agentsaissie) {
        this.agentsaissie = agentsaissie;
    }

    @Column(name = "agentsaissie")
    private String agentsaissie;

    /**** Many To One delegation ****/

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "delegation_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Delegation delegation;


    public Concour getConcour() {
        return concour;
    }

    public String getServiceCivil() {
        return ServiceCivil;
    }

    public void setServiceCivil(String serviceCivil) {
        ServiceCivil = serviceCivil;
    }

    public String getDureservicecivil() {
        return Dureservicecivil;
    }

    public void setDureservicecivil(String dureservicecivil) {
        Dureservicecivil = dureservicecivil;
    }

    public void setConcour(Concour concour) {
        this.concour = concour;
    }

    /**** Many To One concour ****/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "concour_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Concour concour;


    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    /**** Many To One niveau ****/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "niveau_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Niveau niveau;

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    /**** Many To One Specialite ****/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "specialite_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Specialite specialite;

    public long getCandidatId() {
        return candidatId;
    }

    public void setCandidatId(long candidatId) {
        this.candidatId = candidatId;
    }

    public String getNumCandidat() {
        return NumCandidat;
    }

    public void setNumCandidat(String numCandidat) {
        NumCandidat = numCandidat;
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

    public String getPere() {
        return Pere;
    }

    public void setPere(String pere) {
        Pere = pere;
    }

    public String getGPere() {
        return GPere;
    }

    public void setGPere(String GPere) {
        this.GPere = GPere;
    }

    public String getMere() {
        return Mere;
    }

    public void setMere(String mere) {
        Mere = mere;
    }

    public String getSexe() {
        return Sexe;
    }

    public void setSexe(String sexe) {
        Sexe = sexe;
    }

    public String getEtat() {
        return Etat;
    }

    public void setEtat(String etat) {
        Etat = etat;
    }

    public String getFils() {
        return Fils;
    }

    public void setFils(String fils) {
        Fils = fils;
    }

    public String getDateAnniv() {
        return DateAnniv;
    }

    public void setDateAnniv(String dateAnniv) {
        DateAnniv = dateAnniv;
    }

    public String getLieux() {
        return lieux;
    }

    public void setLieux(String lieux) {
        this.lieux = lieux;
    }

    public String getCin() {
        return Cin;
    }

    public void setCin(String cin) {
        Cin = cin;
    }

    public String getEmprinte() {
        return Emprinte;
    }

    public void setEmprinte(String emprinte) {
        Emprinte = emprinte;
    }

    public String getDateCin() {
        return DateCin;
    }

    public void setDateCin(String dateCin) {
        DateCin = dateCin;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }







    public String getBureaudemplois() {
        return Bureaudemplois;
    }

    public void setBureaudemplois(String bureaudemplois) {
        Bureaudemplois = bureaudemplois;
    }

    public String getDateInsBureau() {
        return DateInsBureau;
    }

    public void setDateInsBureau(String dateInsBureau) {
        DateInsBureau = dateInsBureau;
    }

    public String getSituationMilitaire() {
        return SituationMilitaire;
    }

    public void setSituationMilitaire(String situationMilitaire) {
        SituationMilitaire = situationMilitaire;
    }

    public String getDateInscrit() {
        return DateInscrit;
    }

    public void setDateInscrit(String dateInscrit) {
        DateInscrit = dateInscrit;
    }

    public String getUnite() {
        return Unite;
    }

    public void setUnite(String unite) {
        Unite = unite;
    }

    public String getPaiement() {
        return paiement;
    }

    public void setPaiement(String paiement) {
        this.paiement = paiement;
    }

    public String getPermis() {
        return Permis;
    }

    public void setPermis(String permis) {
        Permis = permis;
    }

    public String getNumPermis() {
        return NumPermis;
    }

    public void setNumPermis(String numPermis) {
        NumPermis = numPermis;
    }

    public Delegation getDelegation() {
        return delegation;
    }

    public void setDelegation(Delegation delegation) {
        this.delegation = delegation;
    }


    public Candidat(long candidatId, String numCandidat, String nom, String prenom, String pere, String GPere, String mere, String sexe, String etat, String fils, String dateAnniv, String lieux, String cin, String emprinte, String dateCin, String adresse, String telephone, String email, String bureaudemplois, String dateInsBureau, String situationMilitaire, String dateInscrit, String unite, String paiement, String permis, String numPermis, String serviceCivil, String dureservicecivil, String datesaissie, String agentsaissie, Delegation delegation, Concour concour, Niveau niveau, Specialite specialite) {
        this.candidatId = candidatId;
        NumCandidat = numCandidat;
        Nom = nom;
        Prenom = prenom;
        Pere = pere;
        this.GPere = GPere;
        Mere = mere;
        Sexe = sexe;
        Etat = etat;
        Fils = fils;
        DateAnniv = dateAnniv;
        this.lieux = lieux;
        Cin = cin;
        Emprinte = emprinte;
        DateCin = dateCin;
        Adresse = adresse;
        this.telephone = telephone;
        Email = email;
        Bureaudemplois = bureaudemplois;
        DateInsBureau = dateInsBureau;
        SituationMilitaire = situationMilitaire;
        DateInscrit = dateInscrit;
        Unite = unite;
        this.paiement = paiement;
        Permis = permis;
        NumPermis = numPermis;
        ServiceCivil = serviceCivil;
        Dureservicecivil = dureservicecivil;
        this.datesaissie = datesaissie;
        this.agentsaissie = agentsaissie;
        this.delegation = delegation;
        this.concour = concour;
        this.niveau = niveau;
        this.specialite = specialite;
    }

    public Candidat() {
    }
}
