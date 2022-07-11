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

    public CauseAccident(long causeaccidentId, String name) {
        this.causeaccidentId = causeaccidentId;
        this.name = name;
    }

    public CauseAccident() {
    }

    public long getCauseaccidentId() {
        return causeaccidentId;
    }

    public void setCauseaccidentId(long causeaccidentId) {
        this.causeaccidentId = causeaccidentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
