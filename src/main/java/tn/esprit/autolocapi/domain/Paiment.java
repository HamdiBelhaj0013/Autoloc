package tn.esprit.autolocapi.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaiment;
    private BigDecimal montant;
    private LocalDate datePaiment;
    @Enumerated(EnumType.STRING)
    private ModePaiement modePariment;
}