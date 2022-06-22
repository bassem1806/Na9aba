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
public class Gouvernorat {
@Id
 @GeneratedValue(strategy = GenerationType.AUTO)

    private long gvrCode;
    @NotBlank(message = "Cause Accident est obligatoire ")
   private String gvrDsgar;
 

}
