package com.example.Securite_Routiere.repositories;


import com.example.Securite_Routiere.entities.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectionRepository extends JpaRepository<Direction,Long> {
}
