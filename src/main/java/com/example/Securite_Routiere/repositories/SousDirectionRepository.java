package com.example.Securite_Routiere.repositories;

import com.example.Securite_Routiere.entities.SousDirection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SousDirectionRepository  extends JpaRepository<SousDirection,Long> {
}
