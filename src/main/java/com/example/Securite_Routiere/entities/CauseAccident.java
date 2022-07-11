package com.example.Securite_Routiere.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.validation.constraints.NotBlank;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@ToString
public class CauseAccident {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long causeaccidentId;


    @NotBlank(message = "Cause Accident est obligatoire ")
    @Column(name = "casuseaccident_name")
    private String name;

    public long getId() {
        return causeaccidentId;
    }

    public void setId(long id) {
        this.causeaccidentId = causeaccidentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CauseAccident(long causeaccId, String name) {
        this.causeaccidentId = causeaccId;
        this.name = name;
    }

    public CauseAccident() {
    }
}
