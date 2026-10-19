package tn.esprit.autolocapi.sevice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolocapi.domain.Contrat;
import tn.esprit.autolocapi.domain.Paiement;
import tn.esprit.autolocapi.repository.ContratRepository;
import tn.esprit.autolocapi.repository.PaiementRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class IPaiementImp implements IPaiementService {

    private final PaiementRepository paiementRepository;
    private final ContratRepository contratRepository;

    @Override
    public Paiement ajouterPaiement(Paiement paiement) {
        paiement.setContrat(loadContrat(paiement.getContrat()));
        return paiementRepository.save(paiement);
    }

    @Override
    public void supprimerPaiementById(Long id) {
        paiementRepository.deleteById(id);
    }

    @Override
    public Paiement modifierPaiement(Paiement paiement) {
        paiement.setContrat(loadContrat(paiement.getContrat()));
        return paiementRepository.save(paiement);
    }

    @Override
    public Paiement getPaiementById(Long id) {
        return paiementRepository.findById(id).orElse(null);
    }

    @Override
    public List<Paiement> getAllPaiements() {
        return paiementRepository.findAll();
    }

    private Contrat loadContrat(Contrat contrat) {
        if (contrat == null || contrat.getIdContrat() == null) {
            throw new RuntimeException("Contrat obligatoire");
        }
        return contratRepository.findById(contrat.getIdContrat())
                .orElseThrow(() -> new RuntimeException("Contrat introuvable"));
    }
}
