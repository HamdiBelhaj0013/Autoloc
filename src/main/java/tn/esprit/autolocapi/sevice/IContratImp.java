package tn.esprit.autolocapi.sevice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolocapi.domain.Contrat;
import tn.esprit.autolocapi.domain.Reservation;
import tn.esprit.autolocapi.repository.ContratRepository;
import tn.esprit.autolocapi.repository.ReservationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class IContratImp implements IContratService {

    private final ContratRepository contratRepository;
    private final ReservationRepository reservationRepository;

    @Override
    public Contrat ajouterContrat(Contrat contrat) {
        contrat.setReservation(loadReservation(contrat.getReservation()));
        return contratRepository.save(contrat);
    }

    @Override
    public void supprimerContratById(Long id) {
        contratRepository.deleteById(id);
    }

    @Override
    public Contrat modifierContrat(Contrat contrat) {
        // On met a jour l'entite existante pour ne pas vider la liste paiements
        // (ignoree en JSON, et orphanRemoval = true supprimerait les paiements)
        Contrat existant = contratRepository.findById(contrat.getIdContrat())
                .orElseThrow(() -> new RuntimeException("Contrat introuvable"));
        existant.setDateSignature(contrat.getDateSignature());
        existant.setMontantTotal(contrat.getMontantTotal());
        existant.setValide(contrat.isValide());
        existant.setReservation(loadReservation(contrat.getReservation()));
        return contratRepository.save(existant);
    }

    @Override
    public Contrat getContratById(Long id) {
        return contratRepository.findById(id).orElse(null);
    }

    @Override
    public List<Contrat> getAllContrats() {
        return contratRepository.findAll();
    }

    private Reservation loadReservation(Reservation reservation) {
        if (reservation == null || reservation.getIdReservation() == null) {
            throw new RuntimeException("Reservation obligatoire");
        }
        return reservationRepository.findById(reservation.getIdReservation())
                .orElseThrow(() -> new RuntimeException("Reservation introuvable"));
    }
}
