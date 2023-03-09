package fr.m2i.securauditspring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categorie")
public class Categorie {
    @Id
    @Column(name = "idCategorie")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCategorie;

    @Column(name = "libelle")
    private String libelle;

    //region CONSTRUCTORS
    public Categorie() {
    }

    public Categorie(String libelle) {
        this.libelle = libelle;
    }

    public Categorie(int idCategorie, String libelle) {
        this.libelle = libelle;
        this.idCategorie = idCategorie;
    }

    public long getidCategorie() {
        return idCategorie;
    }

    public void setidCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
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
                "idCategorie=" + idCategorie +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
