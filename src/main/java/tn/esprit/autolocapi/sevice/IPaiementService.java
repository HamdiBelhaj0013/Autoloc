package tn.esprit.autolocapi.sevice;

import tn.esprit.autolocapi.domain.Paiement;

import java.util.List;

public interface IPaiementService {
    Paiement ajouterPaiement(Paiement paiement);
    void supprimerPaiementById(Long id);
    Paiement modifierPaiement(Paiement paiement);
    Paiement getPaiementById(Long id);
    List<Paiement> getAllPaiements();
}
