package com.example.Securite_Routiere.repositories;


import com.example.Securite_Routiere.entities.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface GradeRepository extends JpaRepository<Grade, Long> {
}
