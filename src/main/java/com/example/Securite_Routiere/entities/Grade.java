package com.example.Securite_Routiere.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long GradeId;

    @NotBlank(message = "Code_Grade ")
    @Column(name = "Code_Grade")
    private int CodeGrade;

    @NotBlank(message = "Libelle_Grade est obligatoire ")
    @Column(name = "Libelle_Grade")
    private String LibelleGrade;

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
    //********* Constructor with parameter******//
    public Grade(long gradeId, int codeGrade, String libelleGrade) {
        GradeId = gradeId;
        CodeGrade = codeGrade;
        LibelleGrade = libelleGrade;
    }
    //********* Constructor without parameter******//


    public Grade() {
    }
}
