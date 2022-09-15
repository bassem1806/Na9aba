package com.example.Securite_Routiere.repositories;


import com.example.Securite_Routiere.entities.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NiveauRepository extends JpaRepository<Niveau ,Long> {
}
