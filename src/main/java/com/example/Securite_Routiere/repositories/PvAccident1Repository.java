package com.example.Securite_Routiere.repositories;

import com.example.Securite_Routiere.entities.Delegation;
import com.example.Securite_Routiere.entities.Gouvernorat;
import com.example.Securite_Routiere.entities.PvAccident1;
import com.example.Securite_Routiere.entities.Unite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface PvAccident1Repository extends PagingAndSortingRepository<PvAccident1 ,Long> {

@Query(value = "Select delegation from  PvAccident1",nativeQuery = true)
    List<Delegation> findBydelegation(Delegation delegation);

}
