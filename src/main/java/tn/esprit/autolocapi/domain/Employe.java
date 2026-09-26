package tn.esprit.autolocapi.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEmploye;
    @Column(unique = true, nullable = false)
    private String nom;
    @Column(unique = true, nullable = false)
    private String prenom;
    @Enumerated(EnumType.STRING)
    private RoleEmploye role;
}