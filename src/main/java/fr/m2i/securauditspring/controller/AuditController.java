package fr.m2i.securauditspring.controller;

import fr.m2i.securauditspring.Exception.ResourceNotFoundException;
import fr.m2i.securauditspring.model.Audit;
import fr.m2i.securauditspring.model.Categorie;
import fr.m2i.securauditspring.model.Frais;
import fr.m2i.securauditspring.repositories.AuditRepository;
import fr.m2i.securauditspring.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/Audit")
public class AuditController {
    @Autowired
    AuditRepository auditRepository;
    @GetMapping("/select")
    public ResponseEntity<List<Audit>> getAllaudits() {
        try {
            return new ResponseEntity<List<Audit>>(auditRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/select/{id}")
    public ResponseEntity<Audit> getauditById(@PathVariable("id") Integer id)  {
        Optional<Audit> auditData = auditRepository.findById(id);

        if (auditData.isPresent()) {
            return new ResponseEntity<>(auditData.get(), HttpStatus.OK);
        } else {
            // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            throw new ResourceNotFoundException(" Audit with id : " + id + " not found ");
        }
    }

    @PostMapping("/add")
    public  ResponseEntity<Audit> createaudit(@RequestBody Audit audit) {
        try {
            Audit _audit = auditRepository.save(new Audit(audit.getCoutJour(),audit.getDateAudit(),
                    audit.getDureeAudit(), audit.getIdIndustrie(), audit.getidAuditeur()));
            return new ResponseEntity<>(_audit, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Audit> updateAudit(@PathVariable("id") Integer id, @RequestBody Audit audit) {
        Optional<Audit> AuditData = auditRepository.findById(id);

        if (AuditData.isPresent()) {
            Audit _audit = AuditData.get();
            _audit.setCoutJour(audit.getCoutJour());
            _audit.setDateAudit(audit.getDateAudit());
            _audit.setDureeAudit(audit.getDureeAudit());
            _audit.setIdIndustrie(audit.getIdIndustrie());
            _audit.setidAuditeur(audit.getidAuditeur());

            return new ResponseEntity<>(auditRepository.save(_audit), HttpStatus.OK);
        } else {
            // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            throw new ResourceNotFoundException(" Audit with id : " + id + " not found ");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteAudit(@PathVariable("id") Integer id) {
        try {
            auditRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
