package com.example.demo.Repository;


import com.example.demo.Entities.DetailEquipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IDetailEquipeRepo extends CrudRepository<DetailEquipe, Integer> {
}
