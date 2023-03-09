package fr.m2i.securauditspring.Services;

import fr.m2i.securauditspring.model.Categorie;
import fr.m2i.securauditspring.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class categorieservice {

    @Autowired
    private CategorieRepository categorieRepository;

    // CREATE
    public Categorie createCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    // READ
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    public Categorie getCategorieById(int id) {
        Optional<Categorie> optionalCategorie = categorieRepository.findById(id);
        if (optionalCategorie.isPresent()) {
            return optionalCategorie.get();
        } else {
            return null;
        }
    }

    // UPDATE
    public Categorie updateCategorie(int id, Categorie updatedCategorie) {
        Optional<Categorie> optionalCategorie = categorieRepository.findById(id);
        if (optionalCategorie.isPresent()) {
            Categorie categorie = optionalCategorie.get();
            categorie.setLibelle(updatedCategorie.getLibelle());
            return categorieRepository.save(categorie);
        } else {
            return null;
        }
    }

    // DELETE
    public boolean deleteCategorie(int id) {
        Optional<Categorie> optionalCategorie = categorieRepository.findById(id);
        if (optionalCategorie.isPresent()) {
            categorieRepository.delete(optionalCategorie.get());
            return true;
        } else {
            return false;
        }
    }
}
