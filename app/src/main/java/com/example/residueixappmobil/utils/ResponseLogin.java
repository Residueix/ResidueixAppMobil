package com.example.residueixappmobil.utils;

import com.example.residueixappmobil.model.Desplegable;
import com.example.residueixappmobil.model.Residu;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseLogin {
    @SerializedName("token")
    private String token;
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
    @SerializedName("error")
    private String error;
    @SerializedName("accio")
    private String accio;
    @SerializedName("descripcio")
    private String descripcio;

    @SerializedName("llistat")
    private List<Residu> llistat;
    @SerializedName("permis")
    private int permis;

    @SerializedName("llistat_poblacio")
    private List<Desplegable> llistatPoblacio;

    @SerializedName("llistat_tipusAdherit")
    private List<Desplegable> llistatTipusAdherit;


    public List<Desplegable> getLlistatPoblacio() {
        return llistatPoblacio;
    }

    public void setLlistatTipusAdherit(List<Desplegable> llistatTipusAdherit) {
        this.llistatTipusAdherit = llistatTipusAdherit;
    }

    public void setLlistatPoblacio(List<Desplegable> llistatPoblacio) {
        this.llistatPoblacio = llistatPoblacio;
    }



    public List<Desplegable> getLlistatTipusAdherit() {
        return llistatTipusAdherit;
    }

    public int getPermis() {
        return permis;
    }

    public List<Residu> getLlistat() {
        return llistat;
    }

    public String getAccio() {
        return accio;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public String getError() {
        return error;
    }

    public String getToken() {
        return token;
    }

    public String getTipusNom() {
        return tipusNom;
    }

    public String getEmail() {
        return email;
    }

    public String getCodiError() {
        return codiError;
    }

    public String getId() {
        return id;
    }

    public String getTipus() {
        return tipus;
    }

    public String getCognom1() {
        return cognom1;
    }

    public String getCognom2() {
        return cognom2;
    }

    public String getPassword() {
        return password;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getNom() {
        return nom;
    }

    public String getActiu() {
        return actiu;
    }
}
