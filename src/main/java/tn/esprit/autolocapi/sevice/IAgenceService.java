package tn.esprit.autolocapi.sevice;

import tn.esprit.autolocapi.domain.Agence;

import java.util.List;

public interface IAgenceService {
    Agence ajouterAgence(Agence agence);
    void supprimerAgenceById(Long id);
    Agence modifierAgence(Agence agence);
    Agence getAgenceById(Long id);
    List<Agence> getAllAgences();
}
