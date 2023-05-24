package com.example.reto3univercidadsergioarboleda.Repository;

import com.example.reto3univercidadsergioarboleda.Model.Reservation;
import com.example.reto3univercidadsergioarboleda.Repository.CRUD.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired

    private ReservationCrudRepository reservationCrudRepository;

    //CRUD
    //CREATE
    public Reservation create(Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }
    //RETRIEVE
    public List<Reservation> findAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    public Optional<Reservation> findSelectReservation(int id){
        return reservationCrudRepository.findById(id);
    }
    //UPDATE
    //DELETE
    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }
}
