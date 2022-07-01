package com.example.Securite_Routiere.repositories;

import com.example.Securite_Routiere.entities.Delegation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DelegationRepository extends JpaRepository<Delegation ,Long> {
}
