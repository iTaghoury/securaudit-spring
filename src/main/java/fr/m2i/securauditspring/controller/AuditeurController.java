package fr.m2i.securauditspring.controller;

import fr.m2i.securauditspring.model.Auditeur;
import fr.m2i.securauditspring.repositories.AuditeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AuditeurController {
    @Autowired
    AuditeurRepository repository;

    @GetMapping("/auditeur/{id}")
    public ResponseEntity<Auditeur> show(@PathVariable String id) {
        int idAuditeur = Integer.parseInt(id);
        Optional<Auditeur> auditeur = repository.findById(idAuditeur);
        if(auditeur.isPresent()) {
            return new ResponseEntity<>(auditeur.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
