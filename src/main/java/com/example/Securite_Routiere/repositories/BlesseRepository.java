package com.example.Securite_Routiere.repositories;


import com.example.Securite_Routiere.entities.Blesse;
import com.example.Securite_Routiere.entities.PvAccident1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BlesseRepository extends JpaRepository<Blesse,Long> {







}
