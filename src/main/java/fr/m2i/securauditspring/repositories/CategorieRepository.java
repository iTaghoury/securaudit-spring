package fr.m2i.securauditspring.repositories;

import fr.m2i.securauditspring.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.ArrayList;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
}
