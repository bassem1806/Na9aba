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
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CauseAccident {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "CauseAccID")
    private long cacCode;
    @NotBlank(message = "Cause Accident est obligatoire ")
    @Column(name = "CauseAccNom")
    private String cacDsgar;

}
