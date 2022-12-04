package com.example.demo.Service;

import com.example.demo.Entities.Departement;
import com.example.demo.Entities.Universite;
import com.example.demo.Repository.IDepartementRepo;
import com.example.demo.Repository.IUniversiteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("UniversiteService")
@RequiredArgsConstructor
public class UniversiteService implements IUniversiteService{

   @Autowired
   IUniversiteRepo iUniversiteRepo;
    @Autowired
    IDepartementRepo iDepartementRepo;
    @Override
    public List<Universite> retrieveAllUniversites() {
        return (List<Universite>)iUniversiteRepo.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return iUniversiteRepo.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return iUniversiteRepo.save(u);
    }

    @Override
    public Universite retrieveUniversite(Integer idUniversite) {
        return iUniversiteRepo.findById(idUniversite).get();
    }

    @Override
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
        return iUniversiteRepo.retrieveDepartementsByUniversite(idUniversite);
    }

    @Override
    public int getmaxid() {
        return iUniversiteRepo.getmaxId();
    }

    @Override
    public void deleteUniversite(Integer idUniversite) {
       Universite u= iUniversiteRepo.findById(idUniversite).get();
        iUniversiteRepo.delete(u);
    }


}
