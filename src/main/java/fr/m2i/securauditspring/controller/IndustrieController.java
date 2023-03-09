package fr.m2i.securauditspring.controller;

import fr.m2i.securauditspring.Exception.ResourceNotFoundException;
import fr.m2i.securauditspring.model.Industrie;
import fr.m2i.securauditspring.repositories.IndustrieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/industrie")
public class IndustrieController {
    @Autowired
    IndustrieRepository industrieRepository;

    @PostMapping("/add")
    public  ResponseEntity<Industrie> addIndustrie(@RequestBody Industrie industrie) {
        try {
            Industrie _Industrie = industrieRepository.save(new Industrie(industrie.getSiret(), industrie.getRaisonSociale()));
            return new ResponseEntity<>(_Industrie, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Industrie>> getIndustrieFromDB() {
        try {
            return new ResponseEntity<List<Industrie>>(industrieRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Industrie> getIndustrieById(@PathVariable String id) {
        int idIndustrie = Integer.parseInt(id);
        Optional<Industrie> industrie = industrieRepository.findById(idIndustrie);
        if(industrie.isPresent()) {
            return new ResponseEntity<>(industrie.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Industrie> updateIndustrie(@PathVariable("id") Integer id, @RequestBody Industrie industrie) {
        Optional<Industrie> IndustrieData = industrieRepository.findById(id);
        if (IndustrieData.isPresent()) {
            Industrie _Industrie = IndustrieData.get();
            _Industrie.setSiret(industrie.getSiret());
            _Industrie.setRaisonSociale(industrie.getRaisonSociale());
            return new ResponseEntity<>(industrieRepository.save(_Industrie), HttpStatus.OK);
        } else {
            // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            throw new ResourceNotFoundException(" Industrie with id : " + id + " not found ");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteIndustrie(@PathVariable("id") Integer id) {
        try {
            industrieRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}