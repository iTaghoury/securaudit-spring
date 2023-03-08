package fr.m2i.securauditspring.repositories;

import fr.m2i.securauditspring.model.Auditeur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditeurRepository extends JpaRepository<Auditeur, Integer> {
}
