package com.example.Securite_Routiere.repositories;

import com.example.Securite_Routiere.entities.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {

    @Query(value = "SELECT COUNT(s.nom_syndicat) ," +
            " s.nom_syndicat" +
            " FROM syndicat01.agent a " +
            " left join syndicat01.syndicat s" +
            " ON a.syndicat_id = s.syn_id " +
            "GROUP BY s.nom_syndicat ORDER BY  COUNT(s.nom_syndicat) desc ", nativeQuery = true)

    List<Object> getCountBySyndicat();




    @Query(value = "SELECT COUNT(a.cnrps) ," +
   " sd.nomsdir" +

  " FROM syndicat01.agent a" +
   " left join syndicat01.sous_direction sd"+
   " ON a.sousdirection_id = sd.sd_id" +

   " GROUP BY sd.nomsdir ORDER BY  COUNT(a.cnrps) desc ",nativeQuery = true)
    List<Object> getCountBySDirection();



}
