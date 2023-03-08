package fr.m2i.securauditspring.model;

import java.sql.Date;
import jakarta.persistence.*;
@Entity
@Table(name = "audit")
public class Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idAudit;
    @Column(name = "dateAudit")
    private Date dateAudit;
    @Column(name = "dureeAudit")
    private int dureeAudit;
    @Column(name = "coutJour")
    private int coutJour;
    @Column(name = "idIndustrie")
    private int idIndustrie;
    @Column(name = "idAuditeur")
    private int idAuditeur;
    public Audit(int idAudit, Date dateAudit, int dureeAudit, int coutJour, int idIndustrie, int idAuditeur) {
        this.idAudit = idAudit;
        this.dateAudit = dateAudit;
        this.dureeAudit = dureeAudit;
        this.coutJour = coutJour;
        this.idIndustrie = idIndustrie;
        this.idAuditeur = idAuditeur;
    }
    public Audit( Date dateAudit, int dureeAudit, int coutJour, int idIndustrie, int idAuditeur) {
        this.dateAudit = dateAudit;
        this.dureeAudit = dureeAudit;
        this.coutJour = coutJour;
        this.idIndustrie = idIndustrie;
        this.idAuditeur = idAuditeur;
    }
    public Audit() {}    public int getIdAudit() {
        return idAudit;
    }
    public void setIdAudit(int idAudit) {
        this.idAudit = idAudit;
    }
    public  Date getDateAudit() {
        return dateAudit;
    }
    public void setDateAudit(Date dateAudit) {
        this.dateAudit = dateAudit;
    }
    public  int getDureeAudit() {
        return dureeAudit;
    }
    public void setDureeAudit(int dureeAudit) {
        this.dureeAudit = dureeAudit;
    }
    public  int getCoutJour() {
        return coutJour;
    }
    public void setCoutJour(int coutJour) {
        this.coutJour = coutJour;
    }
    public  int getIdIndustrie() {
        return idIndustrie;
    }
    public void setIdIndustrie(int idIndustrie) {
        this.idIndustrie = idIndustrie;
    }
    public  int getidAuditeur() {
        return idAuditeur;
    }
    public void setidAuditeur(int idAuditeur) {
        idAuditeur = idAuditeur;
    }
}
