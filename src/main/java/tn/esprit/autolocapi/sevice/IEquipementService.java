package tn.esprit.autolocapi.sevice;

import tn.esprit.autolocapi.domain.Equipement;

import java.util.List;

public interface IEquipementService {
    Equipement ajouterEquipement(Equipement equipement);
    void supprimerEquipementById(Long id);
    Equipement modifierEquipement(Equipement equipement);
    Equipement getEquipementById(Long id);
    List<Equipement> getAllEquipements();
}
