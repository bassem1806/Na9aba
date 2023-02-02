package com.example.Securite_Routiere.entities;

import javax.persistence.*;

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


    //********* many to one Agent*******//
/*
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Agent_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Agent agent ;
*/
//********* Getter AND Setter******//

    public Grade(long gradeId, int codeGrade, String libelleGrade, String categorieGrade) {
        GradeId = gradeId;
        CodeGrade = codeGrade;
        LibelleGrade = libelleGrade;
        CategorieGrade = categorieGrade;

    }

    public Grade() {
    }

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

    public String getCategorieGrade() {
        return CategorieGrade;
    }


    //********* Constructor without parameter******//

    public void setCategorieGrade(String categorieGrade) {
        CategorieGrade = categorieGrade;
    }
}
