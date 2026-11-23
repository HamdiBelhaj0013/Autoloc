package tn.esprit.autolocapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Agence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;
    private String nom;
    private String ville;
    private String adresse;
    private String telephone;

    @JsonIgnore
    @OneToMany(mappedBy = "agence")
    private List<Employe> employes = new ArrayList<>();

    @JsonIgnoreProperties("agence")
    @OneToMany(mappedBy = "agence")
    private List<Vehicule> vehicules = new ArrayList<>();
}