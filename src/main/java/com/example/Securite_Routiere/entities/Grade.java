package com.example.Securite_Routiere.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gradeId;


    @Column(name = "Code_Grade")
    private int codeGrade;


    @Column(name = "Libelle_Grade")
    private String libelleGrade;

    @Column(name = "Categorie_Grade")
    private String categorieGrade;



//********* Getter AND Setter******//


    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public int getCodeGrade() {
        return codeGrade;
    }

    public void setCodeGrade(int codeGrade) {
        this.codeGrade = codeGrade;
    }

    public String getLibelleGrade() {
        return libelleGrade;
    }

    public void setLibelleGrade(String libelleGrade) {
        this.libelleGrade = libelleGrade;
    }

    public String getCategorieGrade() {
        return categorieGrade;
    }

    public void setCategorieGrade(String categorieGrade) {
        this.categorieGrade = categorieGrade;
    }

    public Grade() {
    }


    public Grade(Long gradeId, int codeGrade, String libelleGrade, String categorieGrade) {
        this.gradeId = gradeId;
        this.codeGrade = codeGrade;
        this.libelleGrade = libelleGrade;
        this.categorieGrade = categorieGrade;
    }
}
