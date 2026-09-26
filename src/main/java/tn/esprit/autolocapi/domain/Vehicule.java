package tn.esprit.autolocapi.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "vegicule")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicule;
    @Column(unique = true , nullable=false , length = 15)
    private String  immatriculation;
    @Column(length = 10, nullable = false)
    private String  marque;
    @Column(length = 10, nullable = false)
    private String  modele;
    @Enumerated(EnumType.STRING)
    private CategorieVehicule categorie;
    @Column(precision = 10, nullable = false,scale = 2)
    private BigDecimal tarifJournalier;
    @Enumerated(EnumType.STRING)
    private StatutVehicule statut;
}