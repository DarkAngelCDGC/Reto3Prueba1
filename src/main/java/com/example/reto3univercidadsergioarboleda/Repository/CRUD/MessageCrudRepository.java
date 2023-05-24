package com.example.reto3univercidadsergioarboleda.Repository.CRUD;

import com.example.reto3univercidadsergioarboleda.Model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
