package fr.m2i.securauditspring.repositories;

import fr.m2i.securauditspring.model.Frais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraisRepository extends JpaRepository<Frais, Integer> {
}
