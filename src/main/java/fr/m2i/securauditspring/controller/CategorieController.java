package fr.m2i.securauditspring.controller;

import fr.m2i.securauditspring.Exception.ResourceNotFoundException;
import fr.m2i.securauditspring.model.Categorie;
import fr.m2i.securauditspring.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorie")
public class CategorieController {

    @Autowired                                // injection de dependance
    CategorieRepository categorieRepository;  // instance singleton de CRUD categorie

    @GetMapping("/select")
    public ResponseEntity<List<Categorie>> getAllcategories() {
        try {
            return new ResponseEntity<List<Categorie>>(categorieRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/select/{id}")
    public ResponseEntity<Categorie> getcategorieById(@PathVariable("id") Integer id)  {
        Optional<Categorie> categorieData = categorieRepository.findById(id);

        if (categorieData.isPresent()) {
            return new ResponseEntity<>(categorieData.get(), HttpStatus.OK);
        } else {
            // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            throw new ResourceNotFoundException(" categorie with id : " + id + " not found ");
        }
    }


    @PostMapping("/add")
    public  ResponseEntity<Categorie> createcategorie(@RequestBody Categorie categorie) {
        try {
            Categorie _categorie = categorieRepository.save(new Categorie(categorie.getLibelle()));
            return new ResponseEntity<>(_categorie, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Categorie> updatecategorie(@PathVariable("id") Integer id, @RequestBody Categorie categorie) {
        Optional<Categorie> categorieData = categorieRepository.findById(id);

        if (categorieData.isPresent()) {
            Categorie _categorie = categorieData.get();
            _categorie.setLibelle(categorie.getLibelle());

            return new ResponseEntity<>(categorieRepository.save(_categorie), HttpStatus.OK);
        } else {
            // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            throw new ResourceNotFoundException(" categorie with id : " + id + " not found ");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deletecategorie(@PathVariable("id") Integer id) {
        try {
            categorieRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        try {
            categorieRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}





