
package com.example.Securite_Routiere.repositories;

import com.example.Securite_Routiere.entities.PvAccident;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PvAccidentRepository extends CrudRepository<PvAccident ,Long> {
}