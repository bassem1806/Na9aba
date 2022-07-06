package com.example.Securite_Routiere.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
public class Gouvernorat {
@Id
 @GeneratedValue(strategy = GenerationType.AUTO)

    public long gouvernoratId;
    @NotBlank(message = "Cause Accident est obligatoire ")
    @Column(name = "gouvernorat_name")
   private String name;


    /**** one To many delegation****/
  /*  @OneToMany
    @JoinColumn(name = "delegationId",referencedColumnName="delegationId" ,nullable = false )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Delegation> delegations;*/

   /* public long getGouvernoratId() {
        return gouvernoratId;
    }

    public void setGouvernoratId(long gouvernoratId) {
        this.gouvernoratId = gouvernoratId;
    }

    */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gouvernorat(String name) {

        this.name = name;
    }

    public Gouvernorat() {
    }
}
