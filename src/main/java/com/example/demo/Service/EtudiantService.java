package com.example.demo.Service;

import com.example.demo.Entities.*;
import com.example.demo.Repository.IContratRepo;
import com.example.demo.Repository.IDepartementRepo;
import com.example.demo.Repository.IEquipeRepo;
import com.example.demo.Repository.IEtudiantRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@Slf4j
@Service("EtudiantService")
@RequiredArgsConstructor
public class EtudiantService implements IEtudiantService {
    @Autowired
    IEtudiantRepo edtREpo;
    @Autowired
    IContratRepo iContratRepo;
    @Autowired
    IEquipeRepo iEquipeRepo;
    @Autowired
    IDepartementRepo iDepartementRepo;
    public Etudiant addEtudiant(Etudiant e) {
       return edtREpo.save(e);

    }

    @Override
    public void removeEtudiant(Integer idEdut) {
    edtREpo.deleteById(idEdut);
    }

    @Override
    public List<Etudiant> retrieveAllEtudiants() {

        return (List<Etudiant>) edtREpo.findAll();
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return edtREpo.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(Integer idEtudiant) {
        return edtREpo.findById(idEtudiant).orElse(null);
    }

    @Override
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {

        Contrat c= iContratRepo.findById(idContrat).orElse(null);
        Equipe ep=iEquipeRepo.findById(idEquipe).orElse(null);
        System.out.println(ep);
        edtREpo.save(e);
       //affectaion avec contrat
            c.setEtudiant(e);
            iContratRepo.save(c);

        //affectation avec equipe
        e.getEquipes().add(ep);
            edtREpo.save(e);

        return e;
    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
       Etudiant e=edtREpo.findEtudiantByNomPrenom(nomE,prenomE);
       
       e.getContrats().add(ce);
       ce.setEtudiant(e);
        iContratRepo.save(ce);
        edtREpo.save(e);
       return ce;
    }


    @Override
    public List<Etudiant> bydepratement(String nameDep) {
        return edtREpo.findEtudiantByDepartement(nameDep);
    }

    @Override
    public List<Etudiant> getEtudiantsByDepartement(Integer idDepartement) {
        Departement d=iDepartementRepo.findById(idDepartement).orElse(null);
        return edtREpo.getEtudiantsByDepartement(d);
    }

@Scheduled(cron = "*/60 * * * * * ")
    void bonjour(){
        log.info("hello");
}

}
