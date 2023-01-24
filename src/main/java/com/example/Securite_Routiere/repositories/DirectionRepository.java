package com.example.Securite_Routiere.repositories;


import com.example.Securite_Routiere.entities.Direction;
import com.example.Securite_Routiere.entities.DirectionGeneral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectionRepository extends JpaRepository<Direction,Long> {

    List<Direction> findByDirectionGeneral(DirectionGeneral directionGeneral);
}
