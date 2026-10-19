package tn.esprit.autolocapi.sevice;

import tn.esprit.autolocapi.domain.Maintenance;

import java.util.List;

public interface IMaintenanceService {
    Maintenance ajouterMaintenance(Maintenance maintenance);
    void supprimerMaintenanceById(Long id);
    Maintenance modifierMaintenance(Maintenance maintenance);
    Maintenance getMaintenanceById(Long id);
    List<Maintenance> getAllMaintenances();
}
