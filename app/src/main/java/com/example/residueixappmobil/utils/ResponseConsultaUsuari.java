package com.example.residueixappmobil.utils;

import com.example.residueixappmobil.model.Desplegable;
import com.example.residueixappmobil.model.Residu;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseConsultaUsuari {


    @SerializedName("tipus_nom")
    private String tipusNom;
    @SerializedName("email")
    private String email;
    @SerializedName("codi_error")
    private String codiError;
    @SerializedName("id")
    private String id;
    @SerializedName("tipus")
    private String tipus;
    @SerializedName("nom")
    private String nom;
    @SerializedName("cognom1")
    private String cognom1;
    @SerializedName("cognom2")
    private String cognom2;
    @SerializedName("password")
    private String password;
    @SerializedName("telefon")
    private String telefon;
    @SerializedName("actiu")
    private String actiu;
    @SerializedName("accio")
    private String accio;
    @SerializedName("descripcio")
    private String descripcio;
    @SerializedName("carrer")
    private String carrer;
    @SerializedName("cp")
    private String cp;
    @SerializedName("poblacio")
    private String poblacio;
    @SerializedName("poblacio_nom")
    private String poblacio_nom;
    @SerializedName("nomAdherit")
    private String nomAdherit;
    @SerializedName("horari")
    private String horari;
    @SerializedName("tipusAdherit")
    private String tipusAdherit;
    @SerializedName("tipusAdherit_nom")
    private String tipusAdherit_nom;

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
}
