package fr.m2i.securauditspring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Auditeur")
public class Auditeur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idAuditeur;

    @Column(name = "civilite")
    private String civilite;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    public Auditeur(int idAuditeur, String civilite, String nom, String prenom) {
        this.idAuditeur = idAuditeur;
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Auditeur(String civilite, String nom, String prenom) {
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Auditeur() {}

    public int getIdAuditeur() {
        return idAuditeur;
    }

    public void setIdAuditeur(int idAuditeur) {
        this.idAuditeur = idAuditeur;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
