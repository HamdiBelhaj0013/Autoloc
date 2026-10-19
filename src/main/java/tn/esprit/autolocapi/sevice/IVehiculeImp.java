package tn.esprit.autolocapi.sevice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolocapi.domain.Agence;
import tn.esprit.autolocapi.domain.Vehicule;
import tn.esprit.autolocapi.repository.AgenceRepository;
import tn.esprit.autolocapi.repository.VehiculeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class IVehiculeImp implements IVehiculeService {

    private final VehiculeRepository vehiculeRepository;
    private final AgenceRepository agenceRepository;

    @Override
    public Vehicule ajouterVehicule(Vehicule vehicule) {
        vehicule.setAgence(loadAgence(vehicule.getAgence()));
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public void supprimerVehiculeById(Long id) {
        vehiculeRepository.deleteById(id);
    }

    @Override
    public Vehicule modifierVehicule(Vehicule vehicule) {
        vehicule.setAgence(loadAgence(vehicule.getAgence()));
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule getVehiculeById(Long id) {
        return vehiculeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Vehicule> getAllVehicules() {
        return vehiculeRepository.findAll();
    }

    private Agence loadAgence(Agence agence) {
        if (agence == null || agence.getIdAgence() == null) {
            throw new RuntimeException("Agence obligatoire");
        }
        return agenceRepository.findById(agence.getIdAgence())
                .orElseThrow(() -> new RuntimeException("Agence introuvable"));
    }
}
