package com.example.residueixappmobil.model;

import com.google.gson.annotations.SerializedName;

public class UsuariConsulta {
    private String tipusNom;
    private String email;
    private String codiError;
    private String id;
    private String tipus;
    private String nom;
    private String cognom1;
    private String cognom2;
    private String password;
    private String telefon;
    private String actiu;
    private String accio;
    private String descripcio;
    private String carrer;
    private String cp;
    private String poblacio;
    private String poblacio_nom;
    private String nomAdherit;
    private String horari;
    private String tipusAdherit;
    private String tipusAdherit_nom;

    public UsuariConsulta() {

    }

    public String getTipusNom() {
        return tipusNom;
    }

    public void setTipusNom(String tipusNom) {
        this.tipusNom = tipusNom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodiError() {
        return codiError;
    }

    public void setCodiError(String codiError) {
        this.codiError = codiError;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom1() {
        return cognom1;
    }

    public void setCognom1(String cognom1) {
        this.cognom1 = cognom1;
    }

    public String getCognom2() {
        return cognom2;
    }

    public void setCognom2(String cognom2) {
        this.cognom2 = cognom2;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getActiu() {
        return actiu;
    }

    public void setActiu(String actiu) {
        this.actiu = actiu;
    }

    public String getAccio() {
        return accio;
    }

    public void setAccio(String accio) {
        this.accio = accio;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public String getCarrer() {
        return carrer;
    }

    public void setCarrer(String carrer) {
        this.carrer = carrer;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getPoblacio() {
        return poblacio;
    }

    public void setPoblacio(String poblacio) {
        this.poblacio = poblacio;
    }

    public String getPoblacio_nom() {
        return poblacio_nom;
    }

    public void setPoblacio_nom(String poblacio_nom) {
        this.poblacio_nom = poblacio_nom;
    }

    public String getNomAdherit() {
        return nomAdherit;
    }

    public void setNomAdherit(String nomAdherit) {
        this.nomAdherit = nomAdherit;
    }

    public String getHorari() {
        return horari;
    }

    public void setHorari(String horari) {
        this.horari = horari;
    }

    public String getTipusAdherit() {
        return tipusAdherit;
    }

    public void setTipusAdherit(String tipusAdherit) {
        this.tipusAdherit = tipusAdherit;
    }

    public String getTipusAdherit_nom() {
        return tipusAdherit_nom;
    }

    public void setTipusAdherit_nom(String tipusAdherit_nom) {
        this.tipusAdherit_nom = tipusAdherit_nom;
    }

    public UsuariConsulta(String tipusNom, String email, String codiError, String id, String tipus,
                          String nom, String cognom1, String cognom2, String password, String telefon,
                          String actiu, String accio, String descripcio, String carrer, String cp,
                          String poblacio, String poblacio_nom, String nomAdherit, String horari,
                          String tipusAdherit, String tipusAdherit_nom) {
        this.tipusNom = tipusNom;
        this.email = email;
        this.codiError = codiError;
        this.id = id;
        this.tipus = tipus;
        this.nom = nom;
        this.cognom1 = cognom1;
        this.cognom2 = cognom2;
        this.password = password;
        this.telefon = telefon;
        this.actiu = actiu;
        this.accio = accio;
        this.descripcio = descripcio;
        this.carrer = carrer;
        this.cp = cp;
        this.poblacio = poblacio;
        this.poblacio_nom = poblacio_nom;
        this.nomAdherit = nomAdherit;
        this.horari = horari;
        this.tipusAdherit = tipusAdherit;
        this.tipusAdherit_nom = tipusAdherit_nom;
    }
}
