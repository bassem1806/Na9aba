package com.example.Securite_Routiere.repositories;


import com.example.Securite_Routiere.entities.Syndicat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SyndicatRepository  extends JpaRepository <Syndicat , Long> {
}
