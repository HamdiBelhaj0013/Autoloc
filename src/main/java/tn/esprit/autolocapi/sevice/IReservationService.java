package tn.esprit.autolocapi.sevice;

import tn.esprit.autolocapi.domain.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation ajouterReservation(Reservation reservation);
    void supprimerReservationById(Long id);
    Reservation modifierReservation(Reservation reservation);
    Reservation getReservationById(Long id);
    List<Reservation> getAllReservations();
}
