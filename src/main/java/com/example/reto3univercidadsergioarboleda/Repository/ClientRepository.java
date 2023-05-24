package com.example.reto3univercidadsergioarboleda.Repository;

import com.example.reto3univercidadsergioarboleda.Model.Client;
import com.example.reto3univercidadsergioarboleda.Repository.CRUD.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;

    //CRUD Create Retrieve Update Delet
    //Crud Crear
    public Client crear(Client client){
        return clientCrudRepository.save(client);
    }
    //Retrieve - Obtener / findAll = encontarTodo
    public List<Client> findAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }
    public Optional<Client> findSelectClient(int id){
        return clientCrudRepository.findById(id);
    }
    //Update - Actualizar
    //Delet - Eliminar
    public void delet(Client client){
        clientCrudRepository.delete(client);
    }


}
