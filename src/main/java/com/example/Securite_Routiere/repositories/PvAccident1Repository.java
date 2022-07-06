package com.example.Securite_Routiere.repositories;

import com.example.Securite_Routiere.entities.PvAccident1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PvAccident1Repository extends JpaRepository<PvAccident1 ,Long> {
}
