package tn.esprit.autolocapi.sevice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolocapi.domain.Maintenance;
import tn.esprit.autolocapi.domain.Vehicule;
import tn.esprit.autolocapi.repository.MaintenanceRepository;
import tn.esprit.autolocapi.repository.VehiculeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class IMaintenanceImp implements IMaintenanceService {

    private final MaintenanceRepository maintenanceRepository;
    private final VehiculeRepository vehiculeRepository;

    @Override
    public Maintenance ajouterMaintenance(Maintenance maintenance) {
        maintenance.setVehicule(loadVehicule(maintenance.getVehicule()));
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public void supprimerMaintenanceById(Long id) {
        maintenanceRepository.deleteById(id);
    }

    @Override
    public Maintenance modifierMaintenance(Maintenance maintenance) {
        maintenance.setVehicule(loadVehicule(maintenance.getVehicule()));
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public Maintenance getMaintenanceById(Long id) {
        return maintenanceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Maintenance> getAllMaintenances() {
        return maintenanceRepository.findAll();
    }

    private Vehicule loadVehicule(Vehicule vehicule) {
        if (vehicule == null || vehicule.getIdVehicule() == null) {
            throw new RuntimeException("Vehicule obligatoire");
        }
        return vehiculeRepository.findById(vehicule.getIdVehicule())
                .orElseThrow(() -> new RuntimeException("Vehicule introuvable"));
    }
}
