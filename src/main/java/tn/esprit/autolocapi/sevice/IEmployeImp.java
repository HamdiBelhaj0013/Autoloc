package tn.esprit.autolocapi.sevice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolocapi.domain.Agence;
import tn.esprit.autolocapi.domain.Employe;
import tn.esprit.autolocapi.repository.AgenceRepository;
import tn.esprit.autolocapi.repository.EmployeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class IEmployeImp implements IEmployeService {

    private final EmployeRepository employeRepository;
    private final AgenceRepository agenceRepository;

    @Override
    public Employe ajouterEmploye(Employe employe) {
        employe.setAgence(loadAgence(employe.getAgence()));
        return employeRepository.save(employe);
    }

    @Override
    public void supprimerEmployeById(Long id) {
        employeRepository.deleteById(id);
    }

    @Override
    public Employe modifierEmploye(Employe employe) {
        employe.setAgence(loadAgence(employe.getAgence()));
        return employeRepository.save(employe);
    }

    @Override
    public Employe getEmployeById(Long id) {
        return employeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employe> getAllEmployes() {
        return employeRepository.findAll();
    }

    private Agence loadAgence(Agence agence) {
        if (agence == null || agence.getIdAgence() == null) {
            throw new RuntimeException("Agence obligatoire");
        }
        return agenceRepository.findById(agence.getIdAgence())
                .orElseThrow(() -> new RuntimeException("Agence introuvable"));
    }
}
