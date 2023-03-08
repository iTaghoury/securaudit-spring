package fr.m2i.securauditspring.repositories;

import fr.m2i.securauditspring.model.Industrie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndustrieRepository extends JpaRepository<Industrie, Integer> {
}
