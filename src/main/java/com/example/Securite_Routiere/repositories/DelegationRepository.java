package com.example.Securite_Routiere.repositories;

import com.example.Securite_Routiere.entities.Delegation;
import com.example.Securite_Routiere.entities.Gouvernorat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DelegationRepository extends JpaRepository<Delegation,Long> {

    List<Delegation> findByGouvernorat(Gouvernorat gouvernorat);

   /* List<Delegation>finfByname(Delegation delegation);*/

    List<Delegation> findByGouvernorat(Optional<Gouvernorat> byId);
}
