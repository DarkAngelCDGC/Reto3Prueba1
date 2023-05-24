package com.example.reto3univercidadsergioarboleda.Service;

import com.example.reto3univercidadsergioarboleda.Model.Car;
import com.example.reto3univercidadsergioarboleda.Model.Reservation;
import com.example.reto3univercidadsergioarboleda.Model.Score;
import com.example.reto3univercidadsergioarboleda.Repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    //CRUD
    //CREATE
    public Score save(Score score){
        if(score.getIdScore()==null){
            return scoreRepository.create(score);
        }else{
            Optional<Score> scoreFind = getScore(score.getIdScore());
            if(scoreFind.isEmpty()){
                return scoreRepository.create(score);
            }else {
                return score;
            }
        }
    }
    //RETRIEVE
    public List<Score> getAll(){
        return scoreRepository.findAll();
    }
    public Optional<Score> getScore(int id){
        return scoreRepository.findSelectScore(id);
    }
    //UPDATE
    public Score update(Score score){
        if(score.getIdScore()!=null){
            Optional<Score> findScore = getScore(score.getIdScore());
            if(findScore.isPresent()){
                if (score.getMessageText()!=null){
                    findScore.get().setMessageText(score.getMessageText());
                }
                if(score.getStars()!=null){
                    findScore.get().setStars(score.getStars());
                }
                return scoreRepository.create(findScore.get());

            }else {return score;}
        }else {return score;}
    }
    //DELETE

    public boolean deleteScore(int id){
        Boolean respuesta = getScore(id).map(score -> {
            scoreRepository.delete(score);
            return true;
        }).orElse(false);
        return respuesta;
    }

}
