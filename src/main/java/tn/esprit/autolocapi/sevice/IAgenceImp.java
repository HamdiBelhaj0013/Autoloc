package tn.esprit.autolocapi.sevice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autolocapi.domain.Agence;
import tn.esprit.autolocapi.domain.Vehicule;
import tn.esprit.autolocapi.repository.AgenceRepository;
import tn.esprit.autolocapi.repository.VehiculeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class IAgenceImp implements IAgenceService {

    private final AgenceRepository agenceRepository;
    private final VehiculeRepository vehiculeRepository;

    @Override
    public Agence ajouterAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public void supprimerAgenceById(Long id) {
        agenceRepository.deleteById(id);
    }

    @Override
    public Agence modifierAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public Agence getAgenceById(Long id) {
        return agenceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Agence> getAllAgences() {
        return agenceRepository.findAll();
    }

    @Override
    @Transactional
    public Agence ajouterAgenceEtAffecterVehicules(Agence agence) {
        List<Vehicule> vehicules = agence.getVehicules() != null ? agence.getVehicules() : new ArrayList<>();
        agence.setVehicules(vehicules);
        Agence saved = agenceRepository.save(agence);
        for (Vehicule v : vehicules) {
            v.setAgence(saved); // cote proprietaire : remplit vehicule.agence_id
        }
        vehiculeRepository.saveAll(vehicules);
        return saved;
    }
}
