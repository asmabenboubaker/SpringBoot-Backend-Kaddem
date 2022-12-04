package com.example.demo.Repository;


import com.example.demo.Entities.Departement;
import com.example.demo.Entities.Universite;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface IUniversiteRepo extends CrudRepository<Universite, Integer> {

    @Query("select e.departements from Universite e where e.idUniv=?1")
    List<Departement> retrieveDepartementsByUniversite(int idUni);
    @Query("select max(idUniv) from Universite ")
    int getmaxId();
}
