package com.example.reto3univercidadsergioarboleda.Service;

import com.example.reto3univercidadsergioarboleda.Model.Car;
import com.example.reto3univercidadsergioarboleda.Model.Message;
import com.example.reto3univercidadsergioarboleda.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired

    private MessageRepository messageRepository;

    //CRUD
    //CREATE
    public Message save(Message message){
        if(message.getIdMessage()==null){
            return messageRepository.crear(message);
        }else{
            Optional<Message> messageFind = getMessage(message.getIdMessage());
            if(messageFind.isEmpty()){
                return messageRepository.crear(message);
            }else {
                return message;
            }
        }
    }
    //RETRIEVE
    public List<Message> getAll(){
        return messageRepository.findAll();
    }
    public Optional<Message> getMessage(int id){
        return messageRepository.findSelectMessage(id);
    }
    //UPDATE
    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> findMessage = getMessage(message.getIdMessage());
            if(findMessage.isPresent()){
                if (message.getMessageText()!=null){
                    findMessage.get().setMessageText(message.getMessageText());
                }

                return messageRepository.crear(findMessage.get());

            }else {return message;}
        }else {return message;}
    }
    //DELETE

    public boolean deleteMessage(int id){
        Boolean respuesta = getMessage(id).map(message -> {
            messageRepository.delet(message);
            return true;
        }).orElse(false);
        return respuesta;
    }
}
