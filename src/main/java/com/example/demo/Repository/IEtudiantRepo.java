package com.example.demo.Repository;
import com.example.demo.Entities.Departement;
import com.example.demo.Entities.Etudiant;
import com.example.demo.Entities.Option;
import com.sun.org.apache.bcel.internal.generic.LUSHR;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface IEtudiantRepo extends CrudRepository<Etudiant, Integer> {
 //List<Etudiant> findByPrenomENotNull();


    @Query("select e from Etudiant e where e.nomE=?1 and e.prenomE=?2 ")
    Etudiant findEtudiantByNomPrenom(String nom,String prenom);
   /*
    @Query("select e FROM  Etudiant e where  e.option = :option")
    Etudiant findEtudiantByNomPrenom(@Param("option")Option op)

    List<Etudiant> findAllByOption(Option p);
    //// hethi ::
    @Query("select e from Etudiant e where e.departement.nomDepart=:nomdep")
    List<Etudiant> retrieveStudentByDepar(@Param("nomdep") String nomDepartement);*/
    //wala hethii :::
   @Query("select e from Etudiant e inner join e.departement ee where ee.nomDepart = ?1")
   List<Etudiant> findEtudiantByDepartement(String nomDep);
/*
List<Etudiant> findEtudiantByDepartement_NomDepart(String nomDepartement);*/

    List<Etudiant> getEtudiantsByDepartement(Departement Departement);


}
