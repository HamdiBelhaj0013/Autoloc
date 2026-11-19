package tn.esprit.autolocapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocapi.domain.Contrat;
import tn.esprit.autolocapi.sevice.IContratService;

import java.util.List;

@RestController
@RequestMapping("/contrat")
@AllArgsConstructor
@Tag(name="gestion de contrats",description = "Crud")
public class ContratController {

    private final IContratService contratService;
    @Operation (summary = "ajouter un contrat")
    @PostMapping("/add")
    public Contrat ajouterContrat(@RequestBody Contrat contrat) {
        return contratService.ajouterContrat(contrat);
    }

    @PutMapping("/update")
    public Contrat modifierContrat(@RequestBody Contrat contrat) {
        return contratService.modifierContrat(contrat);
    }

    @DeleteMapping("/delete/{id}")
    public void supprimerContrat(@PathVariable Long id) {
        contratService.supprimerContratById(id);
    }

    @GetMapping("/{id}")
    public Contrat getContratById(@PathVariable Long id) {
        return contratService.getContratById(id);
    }

    @GetMapping("/all")
    public List<Contrat> getAllContrats() {
        return contratService.getAllContrats();
    }
}
