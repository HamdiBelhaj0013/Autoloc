package tn.esprit.autolocapi.repository;
import tn.esprit.autolocapi.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratRepository extends JpaRepository<Contrat, Long> {
}