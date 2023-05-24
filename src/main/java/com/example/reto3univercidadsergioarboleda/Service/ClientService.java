package com.example.reto3univercidadsergioarboleda.Service;

import com.example.reto3univercidadsergioarboleda.Model.Client;
import com.example.reto3univercidadsergioarboleda.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    //CRUD
    //CREATE
    public Client save(Client client){
        if(client.getIdClient()==null){
            return clientRepository.crear(client);
        }else{
            Optional<Client> gamaFind = getClient(client.getIdClient());
            if(gamaFind.isEmpty()){
                return clientRepository.crear(client);
            }else {
                return client;
            }
        }

    }
    //RETRIEVE
    public List<Client> getAll(){
        return clientRepository.findAll();
    }
    public Optional<Client> getClient(int id){
        return clientRepository.findSelectClient(id);
    }
    //UPDATE
    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> findClient = getClient(client.getIdClient());
            if(findClient.isPresent()){
                if (client.getEmail()!=null){
                    findClient.get().setEmail(client.getEmail());
                }
                if(client.getPassword()!=null){
                    findClient.get().setPassword(client.getPassword());
                }
                if (client.getName()!=null){
                    findClient.get().setName(client.getName());
                }
                if (client.getAge()!=null){
                    findClient.get().setAge(client.getAge());
                }

                return clientRepository.crear(findClient.get());

            }else {return client;}
        }else {return client;}
    }

    //DELETE

    public boolean deletClient(int id){
        Boolean respuesta = getClient(id).map(client -> {
            clientRepository.delet(client);
            return true;
        }).orElse(false);
        return respuesta;
    }
}
