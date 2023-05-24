package com.example.reto3univercidadsergioarboleda.Repository;

import com.example.reto3univercidadsergioarboleda.Model.Score;
import com.example.reto3univercidadsergioarboleda.Repository.CRUD.ScoreCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {

    @Autowired

    private ScoreCrudRepository scoreCrudRepository;

    //CRUD
    //CREATE
    public Score create(Score score){
        return scoreCrudRepository.save(score);
    }
    //RETRIEVE
    public List<Score> findAll(){
        return (List<Score>) scoreCrudRepository.findAll();
    }
    public Optional<Score> findSelectScore(int id){
        return scoreCrudRepository.findById(id);
    }
    //UPDATE
    //DELETE
    public void delete(Score score){
        scoreCrudRepository.delete(score);
    }
}
