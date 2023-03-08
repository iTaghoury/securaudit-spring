package fr.m2i.securauditspring.model;


import java.sql.Date;

import jakarta.persistence.*;
@Entity
@Table(name = "categorie")
public class Categorie {

    @Id
    @Column(name = "idCategorie")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String libelle;

    //region CONSTRUCTORS
    public Categorie() {
    }

    public Categorie(String libelle) {
        this.libelle = libelle;
    }

    public Categorie(int id, String libelle) {
        this.libelle = libelle;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}

