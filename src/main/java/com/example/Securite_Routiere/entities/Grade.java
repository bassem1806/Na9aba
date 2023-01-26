package com.example.Securite_Routiere.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long GradeId;


    @Column(name = "Code_Grade")
    private int CodeGrade;


    @Column(name = "Libelle_Grade")
    private String LibelleGrade;

    @Column(name = "Categorie_Grade")
    private String CategorieGrade;

//********* Getter AND Setter******//


    public long getGradeId() {
        return GradeId;
    }

    public void setGradeId(long gradeId) {
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

    public String getGategorieGrade() {
        return CategorieGrade;
    }

    public void setGategorieGrade(String gategorieGrade) {
        CategorieGrade = gategorieGrade;
    }

    //********* Constructor with parameter******//

    public Grade(long gradeId, int codeGrade, String libelleGrade, String categorieGrade) {
        GradeId = gradeId;
        CodeGrade = codeGrade;
        LibelleGrade = libelleGrade;
        CategorieGrade = categorieGrade;
    }

    //********* Constructor without parameter******//


    public Grade() {
    }
}
