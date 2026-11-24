package tn.esprit.autolocapi.sevice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autolocapi.domain.Agence;
import tn.esprit.autolocapi.domain.Equipement;
import tn.esprit.autolocapi.domain.Vehicule;
import tn.esprit.autolocapi.repository.AgenceRepository;
import tn.esprit.autolocapi.repository.EquipementRepository;
import tn.esprit.autolocapi.repository.VehiculeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class IVehiculeImp implements IVehiculeService {

    private final VehiculeRepository vehiculeRepository;
    private final AgenceRepository agenceRepository;
    private final EquipementRepository equipementRepository;

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

    @Override
    @Transactional
    public Vehicule affecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule v = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new RuntimeException("Vehicule introuvable : " + idVehicule));
        Equipement e = equipementRepository.findById(idEquipement)
                .orElseThrow(() -> new RuntimeException("Equipement introuvable : " + idEquipement));
        boolean dejaAffecte = v.getEquipments().stream()
                .anyMatch(eq -> eq.getIdEquipement().equals(idEquipement));
        if (!dejaAffecte) {
            v.getEquipments().add(e); // Vehicule = proprietaire de vehicule_equipement
        }
        return vehiculeRepository.save(v);
    }

    @Override
    @Transactional
    public Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule v = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new RuntimeException("Vehicule introuvable : " + idVehicule));
        equipementRepository.findById(idEquipement)
                .orElseThrow(() -> new RuntimeException("Equipement introuvable : " + idEquipement));
        v.getEquipments().removeIf(eq -> eq.getIdEquipement().equals(idEquipement));
        return vehiculeRepository.save(v);
    }

    private Agence loadAgence(Agence agence) {
        if (agence == null || agence.getIdAgence() == null) {
            throw new RuntimeException("Agence obligatoire");
        }
        return agenceRepository.findById(agence.getIdAgence())
                .orElseThrow(() -> new RuntimeException("Agence introuvable"));
    }
}
