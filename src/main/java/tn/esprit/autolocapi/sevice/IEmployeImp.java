package tn.esprit.autolocapi.sevice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    @Override
    @Transactional
    public Employe desaffecterEmploye(Long idEmploye) {
        Employe e = employeRepository.findById(idEmploye)
                .orElseThrow(() -> new RuntimeException("Employe introuvable : " + idEmploye));
        e.setAgence(null);
        return employeRepository.save(e);
    }

    @Override
    @Transactional
    public Employe affecterEmploye(Long idEmploye, Long idAgence) {
        Employe e = employeRepository.findById(idEmploye)
                .orElseThrow(() -> new RuntimeException("Employe introuvable : " + idEmploye));
        Agence a = agenceRepository.findById(idAgence)
                .orElseThrow(() -> new RuntimeException("Agence introuvable : " + idAgence));
        e.setAgence(a);
        return employeRepository.save(e);
    }

    private Agence loadAgence(Agence agence) {
        if (agence == null || agence.getIdAgence() == null) {
            throw new RuntimeException("Agence obligatoire");
        }
        return agenceRepository.findById(agence.getIdAgence())
                .orElseThrow(() -> new RuntimeException("Agence introuvable"));
    }
}
