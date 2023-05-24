package com.example.reto3univercidadsergioarboleda.Service;

import com.example.reto3univercidadsergioarboleda.Model.Car;
import com.example.reto3univercidadsergioarboleda.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    //CRUD
    //CREATE
    public Car save(Car car){
        if(car.getIdCar()==null){
            return carRepository.crear(car);
        }else{
            Optional<Car> carFind = getCar(car.getIdCar());
            if(carFind.isEmpty()){
                return carRepository.crear(car);
            }else {
                return car;
            }
        }
    }
    //RETRIEVE
    public List<Car> getAll(){
        return carRepository.findAll();
    }
    public Optional<Car> getCar(int id){
        return carRepository.findSelectCar(id);
    }
    //UPDATE
    public Car update(Car car){
        if(car.getIdCar()!=null){
            Optional<Car> findCar = getCar(car.getIdCar());
            if(findCar.isPresent()){
                if (car.getBrand()!=null){
                    findCar.get().setBrand(car.getBrand());
                }
                if(car.getName()!=null){
                    findCar.get().setBrand(car.getBrand());
                }
                if (car.getGama()!=null){
                    findCar.get().setName(car.getName());
                }
                if (car.getYear()!=null){
                    findCar.get().setYear(car.getYear());
                }
                if (car.getDescription()!=null){
                    findCar.get().setDescription(car.getDescription());
                }
                return carRepository.crear(findCar.get());

                }else {return car;}
            }else {return car;}
        }
    //DELETE

    public boolean deletCar(int id){
        Boolean respuesta = getCar(id).map(car -> {
            carRepository.delet(car);
            return true;
        }).orElse(false);
        return respuesta;
    }

}
