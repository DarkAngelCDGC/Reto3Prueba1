package com.example.reto3univercidadsergioarboleda.Repository;

import com.example.reto3univercidadsergioarboleda.Model.Gama;
import com.example.reto3univercidadsergioarboleda.Repository.CRUD.GamaCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GamaRepository {
    @Autowired

    private GamaCrudRepository gamaCrudRepository;

    //CRUD
    //CREATE
    public Gama crear(Gama gama){
        return gamaCrudRepository.save(gama);
    }
    //RETRIEVE
    public List<Gama> findAll(){
        return (List<Gama>) gamaCrudRepository.findAll();
    }
    public Optional<Gama> findSelectGama(int id){
        return gamaCrudRepository.findById(id);
    }
    //UPDATE
    //DELET
    public void delet(Gama gama){
        gamaCrudRepository.delete(gama);
    }

}
