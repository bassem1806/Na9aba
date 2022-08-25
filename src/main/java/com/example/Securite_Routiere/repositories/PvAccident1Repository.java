package com.example.Securite_Routiere.repositories;

import com.example.Securite_Routiere.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import static org.hibernate.loader.Loader.SELECT;

@Repository
public interface PvAccident1Repository extends JpaRepository<PvAccident1,Long> {

    @Query(value = "SELECT COUNT(g.gouvernorat_name) ," +
            " g.gouvernorat_name " +
            " FROM sec_routierev0.pv_accident1 p " +
            " left join sec_routiereV0.Delegation d " +
            " on p.delegation_id=d.delegation_id " +
            " left join sec_routierev0.Gouvernorat g " +
            " on  g.gouvernorat_id = d.gouvernorat_id " +
            "GROUP BY g.gouvernorat_name ", nativeQuery = true)
    Object[] countTotalaccidByGov();


    /*@Query("SELECT c.year, COUNT(c.year)
    FROM Comment AS c
    GROUP BY c.year
    ORDER BY c.year DESC")
List<Object[]> countTotalCommentsByYear();*/
}



