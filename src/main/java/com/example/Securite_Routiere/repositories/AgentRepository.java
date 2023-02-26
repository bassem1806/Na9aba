package com.example.Securite_Routiere.repositories;

import com.example.Securite_Routiere.entities.Agent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgentRepository<getnbagent> extends PagingAndSortingRepository<Agent, Long> {

    static Page<Agent> findsort(Pageable pageable) {

        return AgentRepository.findsort(pageable);
    }

/***** serch if existe by cnrps
 * @param CNRPS*****/
    Boolean existsByCNRPS(String CNRPS);

/******* nb abbonnée par syndicat *********/
    @Query(value = "SELECT COUNT(s.nom_syndicat) ," +
            " s.nom_syndicat" +
            " FROM syndicat01.agent a " +
            " left join syndicat01.syndicat s" +
            " ON a.syndicat_id = s.syn_id " +
            "GROUP BY s.nom_syndicat ORDER BY  COUNT(s.nom_syndicat) desc ", nativeQuery = true)

    List<Object> getCountBySyndicat();



    /******* nb abbonnée par Sous Direction *********/

    @Query(value = "SELECT COUNT(a.cnrps) ," +
   " sd.nomsdir" +

  " FROM syndicat01.agent a" +
   " left join syndicat01.sous_direction sd"+
   " ON a.sousdirection_id = sd.sd_id" +

   " GROUP BY sd.nomsdir ORDER BY  COUNT(a.cnrps) desc ",nativeQuery = true)
    List<Object> getCountBySDirection();

    /******* nb abbonnée par Grade *********/
    @Query(value = "SELECT COUNT(a.cnrps) ," +
            " g.libelle_grade" +

            " FROM syndicat01.agent a" +
            " left join syndicat01.grade g" +
            " ON a.grade_id = g.grade_id" +

            " GROUP BY g.libelle_grade ORDER BY  COUNT(a.cnrps) desc ", nativeQuery = true)
    List<Object> getCountByGrade();

    /******* nb abbonnée par periode *********/

    @Query(value = "SELECT COUNT(a.agent_id)," +
            " YEAR (a.date_inscription) ," +
            " MONTH (a.date_inscription)" +
            "FROM syndicat01.agent a" +

            "  WHERE( YEAR(a.date_inscription) = YEAR(CURDATE())     or YEAR(a.date_inscription) = YEAR(CURDATE()) - 1)" +
            "GROUP BY YEAR(a.date_inscription), MONTH (a.date_inscription)", nativeQuery = true)
    List<Object> getCountnbagentperiode();


    /******* nb abbonnée Total *********/
    @Query(value ="SELECT COUNT(a.cnrps)"+
    "FROM syndicat01.agent a" ,nativeQuery = true)

   int nbagent();

    /******* Search Bar *********/

    @Query(value =" SELECT * FROM syndicat01.agent a where (a.date_inscription like %:keyword% ) or (a.cnrps like %:keyword%) or (a.nom like %:keyword%)or (a.prenom like %:keyword%)  ;" ,nativeQuery = true)
    List<Agent> findByKeyword(@Param("keyword") String keyword);
/*
    @Query(value =" SELECT"+
            " a.cin,a.cnrps,a.date_inscription,a.nom,a.prenom,a.prenom_pere,g.libelle_grade,"+
            " d.delegation_name,gr.gouvernorat_name,sd.nomsdir,dr.nom_dir,dg.nom_dir_gen"+
            "FROM syndicat01.agent a"+
            "left join syndicat01.grade g ON a.grade_id =g.grade_id" +
            "left join syndicat01.Delegation d on a.delegation_id=d.delegation_id"+
            " left join syndicat01.Gouvernorat gr on  gr.gouvernorat_id = d.gouvernorat_id"+
            " left join syndicat01.sous_direction sd ON a.sousdirection_id = sd.sd_id"+
            " left join syndicat01.direction dr ON sd.direction_id =dr.did"+
            "left join syndicat01.direction_general dg ON dr.direction_general_id = dg.dg_id"+
            "  where a.cin like %:keyword% or " +
            "a.cnrps like %:keyword% or" +
            "(a.date_inscription like %:keyword% )or" +
            "(a.nom like %:keyword% )or" +
            "(a.prenom_pere like %:keyword%) or" +
            "(g.libelle_grade like %:keyword% )or" +
            "(d.delegation_name like %:keyword%) or" +
            "(gr.gouvernorat_name like %:keyword%) or" +
            "(sd.nomsdir like %:keyword%) or" +
            "(dr.nom_dir like %:keyword%) or" +
            "(dg.nom_dir_gen like %:keyword%) ; " ,nativeQuery = true)
    List<Agent> findByKeyword(@Param("keyword") String keyword);

    */
/* ok
    @Query(value =" SELECT"+
            " a.cin, a.cnrps, a.date_inscription, a.nom, a.prenom, a.prenom_pere, g.libelle_grade"+
            " ,a.agent_id, a.delegation_id, a.grade_id, a.sousdirection_id,a.syndicat_id" +
            " FROM syndicat01.agent as a "+
            " JOIN syndicat01.grade as g ON a.grade_id = g.grade_id" +


            " where (a.cin like %:keyword% or " +
            " a.cnrps like %:keyword% or " +
            " a.date_inscription like %:keyword% or " +
            " a.nom like %:keyword% or " +
            " a.prenom_pere like %:keyword% or " +

            " g.libelle_grade like %:keyword% )" +
            " GROUP BY a.cnrps" ,nativeQuery = true)
    List<Agent> findByKeyword(@Param("keyword") String keyword);

*/




    /*
    @Query(value =" SELECT"+
            " a.cin,a.cnrps,a.date_inscription,a.nom,a.prenom,a.prenom_pere,g.libelle_grade,"+
            " d.delegation_name,gr.gouvernorat_name,sd.nomsdir,dr.nom_dir,dg.nom_dir_gen"+
            "FROM syndicat01.agent a "+
            "left join syndicat01.grade g ON a.grade_id =: g.grade_id" +
            "left join syndicat01.Delegation d on a.delegation_id=d.delegation_id"+
            " left join syndicat01.Gouvernorat gr on  gr.gouvernorat_id = d.gouvernorat_id"+
            " left join syndicat01.sous_direction sd ON a.sousdirection_id = sd.sd_id"+
            " left join syndicat01.direction dr ON sd.direction_id =dr.did"+
            "left join syndicat01.direction_general dg ON dr.direction_general_id = dg.dg_id"+
            "  where (a.cin like %:keyword% or " +
            "a.cnrps like %:keyword% or" +
            "a.date_inscription like %:keyword% or" +
            "a.nom like %:keyword% or" +
            "a.prenom_pere like %:keyword% or" +
            "g.libelle_grade like %:keyword% or" +
            "d.delegation_name like %:keyword% or" +
            "gr.gouvernorat_name like %:keyword% or" +
            "sd.nomsdir like %:keyword% or" +
            "dr.nom_dir like %:keyword% or" +
            "dg.nom_dir_gen like %:keyword% ); " ,nativeQuery = true)
    List<Agent> findByKeyword(@Param("keyword") String keyword);
     */




}
