package com.example.Securite_Routiere.repositories;


import com.example.Securite_Routiere.entities.DirectionGeneral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectionGeneralRepository  extends JpaRepository<DirectionGeneral,Long> {


}
