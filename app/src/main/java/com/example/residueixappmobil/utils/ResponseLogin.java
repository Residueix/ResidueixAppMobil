package com.example.residueixappmobil.utils;

import com.google.gson.annotations.SerializedName;

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
    private String LlistaResidus ;

    @SerializedName("permis")
    private String permis;


    public String getPermis() {
        return permis;
    }

    public String getLlistaResidus() {
        return LlistaResidus;
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
