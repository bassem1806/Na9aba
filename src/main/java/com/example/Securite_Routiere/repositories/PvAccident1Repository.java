package com.example.Securite_Routiere.repositories;

import com.example.Securite_Routiere.entities.Delegation;
import com.example.Securite_Routiere.entities.Gouvernorat;
import com.example.Securite_Routiere.entities.PvAccident1;
import com.example.Securite_Routiere.entities.Unite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface PvAccident1Repository extends PagingAndSortingRepository<PvAccident1 ,Long> {
/*
@Query(value ="Select * From  pv_accident1 pv where gouvernorat_name=:gouvernorat_name",
        countQuery = "SELECT count(*) FROM pv_accident1 where gouvernorat_name=:gouvernorat_name",
        nativeQuery = true)
List<Delegation> findByGouvernorat(Gouvernorat gouvernorat);
*/

    @Query(value="SELECT delegation, count(*) FROM pv_accident1 GROUP BY delegation",
            nativeQuery=true)
    List<Delegation> getAccidentByDelegation();



}
