package tn.esprit.autolocapi.sevice;

import tn.esprit.autolocapi.domain.Employe;

import java.util.List;

public interface IEmployeService {
    Employe ajouterEmploye(Employe employe);
    void supprimerEmployeById(Long id);
    Employe modifierEmploye(Employe employe);
    Employe getEmployeById(Long id);
    List<Employe> getAllEmployes();
}
