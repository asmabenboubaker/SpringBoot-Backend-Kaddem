package com.example.demo.Controller;

import com.example.demo.Entities.Departement;
import com.example.demo.Entities.Etudiant;
import com.example.demo.Entities.ImageModel;
import com.example.demo.Entities.Universite;
import com.example.demo.Repository.IDepartementRepo;
import com.example.demo.Service.IDepartementService;
import com.example.demo.Service.IUniversiteService;
import com.example.demo.Service.UniversiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.criteria.CriteriaBuilder;
import java.awt.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RequestMapping("/univer")
@RequiredArgsConstructor

public class UniversiteRestController {
    @Autowired
    private  final IUniversiteService iUniversiteService;

    @GetMapping("/all")
    @ResponseBody
    public List<Universite> getAllUni(){
        return iUniversiteService.retrieveAllUniversites();
    }
    @GetMapping("/maxid")
    @ResponseBody
    public int getmaxid(){
        return iUniversiteService.getmaxid();
    }

    @PostMapping("/add")
    public Universite addUniversite(@RequestBody Universite universite){
        return iUniversiteService.addUniversite(universite);
    }
   // @PostMapping(value = {"/addWithImage"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
   @RequestMapping(value = "/addWithImage", method = RequestMethod.POST, consumes = {"multipart/form-data"})

   public Universite addWithImage (@RequestPart("universite") Universite universite,
                                    @RequestPart("imageFile")MultipartFile[] file){
        try{
           // Set<ImageModel> images= uploadImage
            Set<ImageModel> images=uploadImage(file);
            universite.setImages(images);
           return iUniversiteService.addUniversite(universite);
        }catch(Exception e){
        System.out.println(e.getMessage());
            return null;
        }

    }

    public Set<ImageModel>  uploadImage(MultipartFile[] multipartFiles)throws IOException {
        Set<ImageModel> imageModels=new HashSet<>();
        for(MultipartFile file:multipartFiles){
            ImageModel imageModel=new ImageModel(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            imageModels.add(imageModel);
        }
        return imageModels;
    }
    @PutMapping ("/update")
    public Universite updateUni(@RequestBody Universite universite){
        return iUniversiteService.updateUniversite(universite);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUniv(@PathVariable("id") Integer id){
        iUniversiteService.deleteUniversite(id);
    }
    @GetMapping("/get/{id-uni}")
    public Universite getById(@PathVariable("id-uni")Integer id){
        return iUniversiteService.retrieveUniversite(id);

    }
@GetMapping("/retrieveDepartementsByUniversite/{idUni}")
    public List<Departement> retrieveDepartementsByUniversite(@PathVariable("idUni") Integer idUni){
       // System.out.println(iUniversiteService.retrieveDepartementsByUniversite(idUni));
        return  iUniversiteService.retrieveDepartementsByUniversite(idUni);

}

}
