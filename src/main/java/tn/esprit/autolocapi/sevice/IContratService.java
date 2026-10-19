package tn.esprit.autolocapi.sevice;

import tn.esprit.autolocapi.domain.Contrat;

import java.util.List;

public interface IContratService {
    Contrat ajouterContrat(Contrat contrat);
    void supprimerContratById(Long id);
    Contrat modifierContrat(Contrat contrat);
    Contrat getContratById(Long id);
    List<Contrat> getAllContrats();
}
