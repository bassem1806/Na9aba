package com.example.Securite_Routiere.repositories;

import com.example.Securite_Routiere.entities.Direction;

import com.example.Securite_Routiere.entities.SousDirection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SousDirectionRepository  extends JpaRepository<SousDirection,Long> {

     List <SousDirection> findByDirection(Direction direction);
    // List<Direction> findByDirectionGeneral(DirectionGeneral directionGeneral);
}
