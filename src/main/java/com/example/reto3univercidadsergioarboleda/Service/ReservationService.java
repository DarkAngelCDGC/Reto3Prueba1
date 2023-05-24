package com.example.reto3univercidadsergioarboleda.Service;

import com.example.reto3univercidadsergioarboleda.Model.Reservation;
import com.example.reto3univercidadsergioarboleda.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    //CRUD
    //CREATE
    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return reservationRepository.create(reservation);
        }else{
            Optional<Reservation> reservationFind = getReservation(reservation.getIdReservation());
            if(reservationFind.isEmpty()){
                return reservationRepository.create(reservation);
            }else {
                return reservation;
            }
        }
    }
    //RETRIEVE
    public List<Reservation> getAll(){
        return reservationRepository.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.findSelectReservation(id);
    }
    //UPDATE
    public Reservation update(Reservation reservation){
        if(reservation.getStarDate()!=null){
            Optional<Reservation> findReservation = getReservation(reservation.getIdReservation());
            if(findReservation.isPresent()){
                if (reservation.getStarDate()!=null){
                    findReservation.get().setStarDate(reservation.getStarDate());
                }
                if(reservation.getDevolitionDate()!=null){
                    findReservation.get().setDevolitionDate(reservation.getDevolitionDate());
                }
                if (reservation.getStatus()!=null){
                    findReservation.get().setStatus(reservation.getStatus());
                }

                return reservationRepository.create(findReservation.get());

            }else {return reservation;}
        }else {return reservation;}
    }
    //DELETE

    public boolean deletReervation(int id){
        Boolean respuesta = getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return respuesta;
    }

}
