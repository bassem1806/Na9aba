package com.example.Securite_Routiere.repositories;


import com.example.Securite_Routiere.entities.Concour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcourRepository extends JpaRepository<Concour,Long> {
}
