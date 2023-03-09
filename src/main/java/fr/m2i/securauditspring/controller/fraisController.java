package fr.m2i.securauditspring.controller;

import fr.m2i.securauditspring.model.Frais;
import fr.m2i.securauditspring.repositories.FraisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
}
