package fr.m2i.securauditspring.repositories;

import fr.m2i.securauditspring.model.Auditeur;
import fr.m2i.securauditspring.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {

}
