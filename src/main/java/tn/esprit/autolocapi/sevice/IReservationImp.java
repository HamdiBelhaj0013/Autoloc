package tn.esprit.autolocapi.sevice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolocapi.domain.Client;
import tn.esprit.autolocapi.domain.Reservation;
import tn.esprit.autolocapi.domain.Vehicule;
import tn.esprit.autolocapi.repository.ClientRepository;
import tn.esprit.autolocapi.repository.ReservationRepository;
import tn.esprit.autolocapi.repository.VehiculeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class IReservationImp implements IReservationService {

    private final ReservationRepository reservationRepository;
    private final ClientRepository clientRepository;
    private final VehiculeRepository vehiculeRepository;

    @Override
    public Reservation ajouterReservation(Reservation reservation) {
        reservation.setClient(loadClient(reservation.getClient()));
        reservation.setVehicule(loadVehicule(reservation.getVehicule()));
        return reservationRepository.save(reservation);
    }

    @Override
    public void supprimerReservationById(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public Reservation modifierReservation(Reservation reservation) {
        reservation.setClient(loadClient(reservation.getClient()));
        reservation.setVehicule(loadVehicule(reservation.getVehicule()));
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    private Client loadClient(Client client) {
        if (client == null || client.getIdClient() == null) {
            throw new RuntimeException("Client obligatoire");
        }
        return clientRepository.findById(client.getIdClient())
                .orElseThrow(() -> new RuntimeException("Client introuvable"));
    }

    private Vehicule loadVehicule(Vehicule vehicule) {
        if (vehicule == null || vehicule.getIdVehicule() == null) {
            throw new RuntimeException("Vehicule obligatoire");
        }
        return vehiculeRepository.findById(vehicule.getIdVehicule())
                .orElseThrow(() -> new RuntimeException("Vehicule introuvable"));
    }
}
