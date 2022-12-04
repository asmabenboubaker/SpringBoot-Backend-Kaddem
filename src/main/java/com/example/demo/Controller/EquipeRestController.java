package com.example.demo.Controller;

import com.example.demo.Entities.Equipe;

import com.example.demo.Service.IEquipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipe")
@RequiredArgsConstructor
public class EquipeRestController {
    private final IEquipeService iEquipeService;
    @GetMapping("/all")
    @ResponseBody
    public List<Equipe> getAllEquipes(){
        return  iEquipeService.retrieveAllEquipes();
    }
    @PostMapping("/add")
    public Equipe addEquipe(@RequestBody Equipe equipe){
        return  iEquipeService.addEquipe(equipe);
    }
    @PutMapping ("/update")
    public Equipe updateEquipe(@RequestBody Equipe equipe){
        return iEquipeService.updateEquipe(equipe);
    }
    @GetMapping("/get/{id-equipe}")
    public Equipe getById(@PathVariable("id-equipe") Integer id){
        return iEquipeService.retrieveEquipe(id);
    }

}
