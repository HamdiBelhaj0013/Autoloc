package tn.esprit.autolocapi.sevice;

import tn.esprit.autolocapi.domain.Vehicule;

import java.util.List;

public interface IVehiculeService {
    Vehicule ajouterVehicule(Vehicule vehicule);
    void supprimerVehiculeById(Long id);
    Vehicule modifierVehicule(Vehicule vehicule);
    Vehicule getVehiculeById(Long id);
    List<Vehicule> getAllVehicules();
}