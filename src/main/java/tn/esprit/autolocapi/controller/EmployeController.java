package tn.esprit.autolocapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocapi.domain.Employe;
import tn.esprit.autolocapi.sevice.IEmployeService;

import java.util.List;

@RestController
@RequestMapping("/employe")
@AllArgsConstructor
public class EmployeController {

    private final IEmployeService employeService;

    @PostMapping("/add")
    public Employe ajouterEmploye(@RequestBody Employe employe) {
        return employeService.ajouterEmploye(employe);
    }

    @PutMapping("/update")
    public Employe modifierEmploye(@RequestBody Employe employe) {
        return employeService.modifierEmploye(employe);
    }

    @DeleteMapping("/delete/{id}")
    public void supprimerEmploye(@PathVariable Long id) {
        employeService.supprimerEmployeById(id);
    }

    @GetMapping("/{id}")
    public Employe getEmployeById(@PathVariable Long id) {
        return employeService.getEmployeById(id);
    }

    @GetMapping("/all")
    public List<Employe> getAllEmployes() {
        return employeService.getAllEmployes();
    }
}
