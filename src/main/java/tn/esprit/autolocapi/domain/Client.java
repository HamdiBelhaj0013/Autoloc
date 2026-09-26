package tn.esprit.autolocapi.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idClient;
    @Column(unique = false, nullable = false)
    private String nom;
    @Column(unique = false, nullable = false)
    private String prenom;
    @Column(unique = true, nullable = false , length = 50)
    @Email(message = "invalid email")
    private String email;
    @Column(unique = true, nullable = false)
    private String telephone;
    @Column(unique = true, nullable = false)
    private String numPermis;
    private LocalDate dateInscription;

}
