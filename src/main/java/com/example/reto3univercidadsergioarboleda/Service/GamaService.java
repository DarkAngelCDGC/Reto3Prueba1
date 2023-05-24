package com.example.reto3univercidadsergioarboleda.Service;

import com.example.reto3univercidadsergioarboleda.Model.Gama;
import com.example.reto3univercidadsergioarboleda.Repository.GamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamaService {

    @Autowired
    private GamaRepository gamaRepository;

    //CRUD
    //CREATE
    public Gama save(Gama gama){
        if(gama.getIdGama()==null){
            return gamaRepository.crear(gama);
        }else{
            Optional<Gama> gamaFind = getGama(gama.getIdGama());
            if(gamaFind.isEmpty()){
                return gamaRepository.crear(gama);
            }else {
                return gama;
            }
        }
    }
    //RETRIEVE
    public List<Gama> getAll(){
        return gamaRepository.findAll();
    }
    public Optional<Gama> getGama(int id){
        return gamaRepository.findSelectGama(id);
    }
    //UPDATE
    public Gama update(Gama gama){
        if(gama.getIdGama()!=null){
            Optional<Gama> findGama = getGama(gama.getIdGama());
            if(findGama.isPresent()){
                if (gama.getName()!=null){
                    findGama.get().setName(gama.getName());
                }
                if(gama.getDescription()!=null){
                    findGama.get().setDescription(gama.getDescription());
                }

                return gamaRepository.crear(findGama.get());

            }else {return gama;}
        }else {return gama;}
    }
    //DELETE

    public boolean deletGama(int id){
        Boolean respuesta = getGama(id).map(gama -> {
            gamaRepository.delet(gama);
            return true;
        }).orElse(false);
        return respuesta;
    }

}
