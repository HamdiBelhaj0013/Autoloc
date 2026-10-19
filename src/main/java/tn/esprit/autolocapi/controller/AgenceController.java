package tn.esprit.autolocapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocapi.domain.Agence;
import tn.esprit.autolocapi.sevice.IAgenceService;

import java.util.List;

@RestController
@RequestMapping("/agence")
@AllArgsConstructor
public class AgenceController {

    private final IAgenceService agenceService;

    @PostMapping("/add")
    public Agence ajouterAgence(@RequestBody Agence agence) {
        return agenceService.ajouterAgence(agence);
    }

    @PutMapping("/update")
    public Agence modifierAgence(@RequestBody Agence agence) {
        return agenceService.modifierAgence(agence);
    }

    @DeleteMapping("/delete/{id}")
    public void supprimerAgence(@PathVariable Long id) {
        agenceService.supprimerAgenceById(id);
    }

    @GetMapping("/{id}")
    public Agence getAgenceById(@PathVariable Long id) {
        return agenceService.getAgenceById(id);
    }

    @GetMapping("/all")
    public List<Agence> getAllAgences() {
        return agenceService.getAllAgences();
    }
}
