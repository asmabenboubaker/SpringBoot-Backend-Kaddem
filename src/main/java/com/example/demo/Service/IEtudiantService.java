package com.example.demo.Service;

import com.example.demo.Entities.Contrat;
import com.example.demo.Entities.Etudiant;
import com.example.demo.Entities.Option;

import java.util.List;

public interface IEtudiantService {
Etudiant addEtudiant(Etudiant e);
    void removeEtudiant(Integer idEdut);
    List<Etudiant> retrieveAllEtudiants();
    Etudiant updateEtudiant (Etudiant e);
    Etudiant retrieveEtudiant(Integer idEtudiant);
    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer
            idEquipe);
    Contrat affectContratToEtudiant (Contrat ce,String nomE, String prenomE);

    List<Etudiant> bydepratement(String nameDep);
    List<Etudiant> getEtudiantsByDepartement (Integer idDepartement);
}
