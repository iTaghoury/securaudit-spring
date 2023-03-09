package fr.m2i.securauditspring.controller;

import fr.m2i.securauditspring.model.Frais;
import fr.m2i.securauditspring.repositories.FraisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/frais")
public class fraisController {

    @Autowired                        // injection de dependance
    FraisRepository fraisRepository;  // instance singleton de CRUD Frais

    @GetMapping("/select")
    public ResponseEntity<List<Frais>> getAllFraiss() {
        try {
            return new ResponseEntity<List<Frais>>(fraisRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/select/{id}")
    public ResponseEntity<Frais> getFraisById(@PathVariable("id") Integer id) {
        Optional<Frais> FraisData = fraisRepository.findById(id);

        if (FraisData.isPresent()) {
            return new ResponseEntity<>(FraisData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/add")
    public  ResponseEntity<Frais> createFrais(@RequestBody Frais Frais) {
        try {
            Frais _Frais = fraisRepository.save(new Frais(Frais.getDateFrais(), Frais.getEstRembourse(), Frais.getMontant(), Frais.getIdAudit(), Frais.getIdCategorie() ));
            return new ResponseEntity<>(_Frais, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Frais> updateFrais(@PathVariable("id") Integer id, @RequestBody Frais Frais) {
        Optional<Frais> FraisData = fraisRepository.findById(id);

        if (FraisData.isPresent()) {
            Frais _Frais = FraisData.get();
            _Frais.setMontant(Frais.getMontant());
            _Frais.setDateFrais(Frais.getDateFrais());
            _Frais.setEstRembourse(Frais.getEstRembourse());
            _Frais.setIdCategorie(Frais.getIdCategorie());
            _Frais.setIdAudit(Frais.getIdAudit());

            return new ResponseEntity<>(fraisRepository.save(_Frais), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteFrais(@PathVariable("id") Integer id) {
        try {
            fraisRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        try {
            fraisRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}





