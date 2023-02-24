package com.example.Securite_Routiere.repositories;


import com.example.Securite_Routiere.entities.AgentR;
import com.example.Securite_Routiere.entities.Delegation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AgentRRepository extends JpaRepository<AgentR, Long> {



    @Query(value ="SELECT  * FROM syndicat01.agentr  ar    " ,nativeQuery = true)
    List<AgentR>  FindByCNRPSAgentR();


    @Query(value ="SELECT  * FROM syndicat01.agentr  ar where  ar.cnrps  like  %:keywordd% ;" ,nativeQuery = true)
    List<AgentR>  findbyCNRPSAGRkey(@Param("keywordd") String keywordd);

}

