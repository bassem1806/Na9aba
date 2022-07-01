package com.example.Securite_Routiere.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "participanid")
    private long prtCode;

    @NotBlank(message = "Participant obligatoir ")
    @Column(name = "participannom")
    private String prtDsgar;


    public long getPrtCode() {
        return prtCode;
    }

    public void setPrtCode(long prtCode) {
        this.prtCode = prtCode;
    }

    public String getPrtDsgar() {
        return prtDsgar;
    }

    public void setPrtDsgar(String prtDsgar) {
        this.prtDsgar = prtDsgar;
    }
}
