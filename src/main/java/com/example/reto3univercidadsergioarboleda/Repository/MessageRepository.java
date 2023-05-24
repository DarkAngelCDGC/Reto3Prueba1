package com.example.reto3univercidadsergioarboleda.Repository;

import com.example.reto3univercidadsergioarboleda.Model.Message;
import com.example.reto3univercidadsergioarboleda.Repository.CRUD.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {
    @Autowired
    private MessageCrudRepository messageCrudRepository;

    //CRUD
    //CREATE
    public Message crear(Message message){

        return messageCrudRepository.save(message);
    }
    //RETRIEVE
    public List<Message> findAll(){

        return (List<Message>) messageCrudRepository.findAll();
    }
    public Optional<Message> findSelectMessage(int id){

        return messageCrudRepository.findById(id);
    }
    //Update
    //Delet
    public void delet(Message message){
        messageCrudRepository.delete(message);
    }

}
