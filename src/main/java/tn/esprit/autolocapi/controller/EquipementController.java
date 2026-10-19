package tn.esprit.autolocapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocapi.domain.Equipement;
import tn.esprit.autolocapi.sevice.IEquipementService;

import java.util.List;

@RestController
@RequestMapping("/equipement")
@AllArgsConstructor
public class EquipementController {

    private final IEquipementService equipementService;

    @PostMapping("/add")
    public Equipement ajouterEquipement(@RequestBody Equipement equipement) {
        return equipementService.ajouterEquipement(equipement);
    }

    @PutMapping("/update")
    public Equipement modifierEquipement(@RequestBody Equipement equipement) {
        return equipementService.modifierEquipement(equipement);
    }

    @DeleteMapping("/delete/{id}")
    public void supprimerEquipement(@PathVariable Long id) {
        equipementService.supprimerEquipementById(id);
    }

    @GetMapping("/{id}")
    public Equipement getEquipementById(@PathVariable Long id) {
        return equipementService.getEquipementById(id);
    }

    @GetMapping("/all")
    public List<Equipement> getAllEquipements() {
        return equipementService.getAllEquipements();
    }
}
