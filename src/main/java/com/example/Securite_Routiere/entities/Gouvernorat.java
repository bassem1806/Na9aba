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

    private long id;
    @NotBlank(message = "Cause Accident est obligatoire ")
    @Column(name = "gouvernorat_name")
   private String name;


    /**** one To many part****/
    @OneToMany
    @JoinColumn(name = "gouvernorat_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Delegation> delegation =new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Gouvernorat(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Gouvernorat() {
    }
}
