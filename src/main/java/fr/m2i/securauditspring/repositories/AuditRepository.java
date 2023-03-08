package fr.m2i.securauditspring.repositories;

import fr.m2i.securauditspring.model.Audit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRepository extends JpaRepository<Audit, Integer> {
}
