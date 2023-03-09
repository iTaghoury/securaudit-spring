package fr.m2i.securauditspring.model;

import jakarta.persistence.*;

@Entity
public class Industrie {

    @Id
    @GeneratedValue
    private int idIndustrie;
    private String siret;
    private String raisonSociale;


    //region CONSTRUCTORS
    public Industrie(){}
    public Industrie(String siret, String raisonSociale) {
        this.siret = siret;
        this.raisonSociale = raisonSociale;
    }
    public Industrie(int idIndustrie, String siret, String raisonSociale) {
        this.idIndustrie = idIndustrie;
        this.siret = siret;
        this.raisonSociale = raisonSociale;
    }
    //endregion

    //region GETTERS AND SETTERS
    public int getIdIndustrie() {
        return idIndustrie;
    }
    public void setIdIndustrie(int idIndustrie) {
        this.idIndustrie = idIndustrie;
    }
    public String getSiret() {
        return siret;
    }
    public void setSiret(String siret) {
        this.siret = siret;
    }
    public String getRaisonSociale() {
        return raisonSociale;
    }
    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }
    //endregion
}
