package com.example.Securite_Routiere.repositories;


import com.example.Securite_Routiere.entities.Blesse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface Blesserepository extends JpaRepository<Blesse,Long> {


}
