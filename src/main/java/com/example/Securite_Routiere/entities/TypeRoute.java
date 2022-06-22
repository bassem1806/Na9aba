package com.example.Securite_Routiere.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class TypeRoute {
@Id
@GeneratedValue(strategy= GenerationType.AUTO)
@Column(name = "typerouteid")
    private long rteCode;

    @NotBlank(message = "Type route est obligatoire ")
    @Column(name = "typeroute")
    private String rteDsgar;


}
