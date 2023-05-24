package com.example.reto3univercidadsergioarboleda.Repository;

import com.example.reto3univercidadsergioarboleda.Model.Car;
import com.example.reto3univercidadsergioarboleda.Repository.CRUD.CarCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public class CarRepository {

    @Autowired
    private CarCrudRepository carCrudRepository;

    //CRUD Create Retrieve Update Delet
    //Crud Crear
    public Car crear(Car car){
        return carCrudRepository.save(car);
    }
    //Retrieve - Obtener / findAll = encontarTodo
    public List<Car> findAll(){
        return (List<Car>) carCrudRepository.findAll();
    }
    public Optional<Car> findSelectCar(int id){
        return carCrudRepository.findById(id);
    }
    //Update - Actualizar
    //Delet - Eliminar
    public void delet(Car car){
        carCrudRepository.delete(car);
    }

}
