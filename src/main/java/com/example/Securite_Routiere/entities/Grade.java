package com.example.Securite_Routiere.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long GradeId;


    @Column(name = "Code_Grade")
    private int CodeGrade;


    @Column(name = "Libelle_Grade")
    private String LibelleGrade;

    @Column(name = "Categorie_Grade")
    private String CategorieGrade;



//********* Getter AND Setter******//


    public Long getGradeId() {
        return GradeId;
    }

    public void setGradeId(Long gradeId) {
        GradeId = gradeId;
    }

    public int getCodeGrade() {
        return CodeGrade;
    }

    public void setCodeGrade(int codeGrade) {
        CodeGrade = codeGrade;
    }

    public String getLibelleGrade() {
        return LibelleGrade;
    }

    public void setLibelleGrade(String libelleGrade) {
        LibelleGrade = libelleGrade;
    }

    public String getCategorieGrade() {
        return CategorieGrade;
    }

    public void setCategorieGrade(String categorieGrade) {
        CategorieGrade = categorieGrade;
    }

    public Grade(Long gradeId, int codeGrade, String libelleGrade, String categorieGrade) {
        GradeId = gradeId;
        CodeGrade = codeGrade;
        LibelleGrade = libelleGrade;
        CategorieGrade = categorieGrade;
    }

    public Grade() {
    }


}
