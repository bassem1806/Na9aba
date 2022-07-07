package com.example.Securite_Routiere.repositories;

import com.example.Securite_Routiere.entities.Delegation;
import com.example.Securite_Routiere.entities.Gouvernorat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DelegationRepository extends JpaRepository<Delegation ,Long> {

    /* List<Delegation> findByGouvernorat(Gouvernorat gouvernorat);*/
}
