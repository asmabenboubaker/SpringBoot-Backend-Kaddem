package com.example.demo.Controller;

import com.example.demo.Entities.Contrat;
import com.example.demo.Entities.Departement;
import com.example.demo.Entities.Etudiant;
import com.example.demo.Service.IDepartementService;
import com.example.demo.Service.IEtudiantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name="student management")
@RestController
@RequestMapping("/etudiant")
@RequiredArgsConstructor
public class EtudiantRestController {
    private final IEtudiantService iEtudiantService;
    //couplage faibles
    //Id : @RequiredArgsConstructor
//http://localhost:8080/test/etudiant/all

    @Operation(description = "Retrieve all students ")
    @GetMapping("/all")
    @ResponseBody
    public List<Etudiant> getEtudiants(){
        return iEtudiantService.retrieveAllEtudiants();
    }
    @PostMapping("/add")
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant){
        return  iEtudiantService.addEtudiant(etudiant);
    }
    @PutMapping ("/update")
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant){
        return  iEtudiantService.addEtudiant(etudiant);
    }
    @GetMapping("/get/{id-etudiant}")

    public Etudiant getById(@PathVariable("id-etudiant") Integer id){
       return iEtudiantService.retrieveEtudiant(id);
    }
    @DeleteMapping("/remove/{id-etudiant}")
    public void removeEtudiant(@PathVariable("id-etudiant") Integer id){
        iEtudiantService.removeEtudiant(id);
    }

    @PutMapping ("/addparasso/{idContrat}/{idEquie}")
    public Etudiant addEtudiantparasso(@RequestBody Etudiant etudiant,@PathVariable("idContrat") Integer idContrat,@PathVariable("idEquie") Integer idEquipe){
        return  iEtudiantService.addAndAssignEtudiantToEquipeAndContract(etudiant,idContrat,idEquipe);
    }
    @PutMapping ("/affectContratToEtudiant/{nom}/{prenom}")
    public Contrat affectContratToEtudiant(@RequestBody Contrat c, @PathVariable("nom") String nom, @PathVariable("prenom") String prenom) {
        return iEtudiantService.affectContratToEtudiant(c,nom,prenom);
    }

    @GetMapping("/get/bydep/{name}")
    public List<Etudiant> getByNamedep(@PathVariable("name") String name){
        return iEtudiantService.bydepratement(name);
    }

    @GetMapping("/getEtudiantsByDepartement/{iddep}")
    public List<Etudiant> getEtudiantsByDepartement(@PathVariable("iddep") Integer iddep){
      //  Departement d=iDepartementService.retrieveDepartement(iddep);
        return iEtudiantService.getEtudiantsByDepartement(iddep);
    }
}
