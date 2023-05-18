package com.example.residueixappmobil.model;

import com.google.gson.annotations.SerializedName;

public class Residu {
    @SerializedName("id_residu")
    String id_residu;
    @SerializedName("nom_residu")
    String nom_residu;
    @SerializedName("imatge_residu")
    String imatge_residu;
    @SerializedName("id_tipus_residu")
    String tipus_residu;
    @SerializedName("descripcio_residu")
    String descripcio_residu;
    @SerializedName("actiu_residu")
    String actiu_residu;
    @SerializedName("valor_residu")
    String valor_residu;
    @SerializedName("nom_tipus_residu")
    String nom_tipus_residu;
    @SerializedName("imatge_tipus_residu")
    String imatge_tipus_residus;

    @SerializedName("id")
    String id;
    @SerializedName("nom")
    String nom;

    public Residu(String id_residu, String nom_residu, String imatge_residu, String tipus_residu, String descripcio_residu, String actiu_residu, String valor_residu, String nom_tipus_residu, String imatge_tipus_residus) {
        this.id_residu = id_residu;
        this.nom_residu = nom_residu;
        this.imatge_residu = imatge_residu;
        this.tipus_residu = tipus_residu;
        this.descripcio_residu = descripcio_residu;
        this.actiu_residu = actiu_residu;
        this.valor_residu = valor_residu;
        this.nom_tipus_residu = nom_tipus_residu;
        this.imatge_tipus_residus = imatge_tipus_residus;
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public Residu(String id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public String getId_residu() {
        return id_residu;
    }

    public void setId_residu(String id_residu) {
        this.id_residu = id_residu;
    }

    public String getNom_residu() {
        return nom_residu;
    }

    public void setNom_residu(String nom_residu) {
        this.nom_residu = nom_residu;
    }

    public String getImatge_residu() {
        return imatge_residu;
    }

    public void setImatge_residu(String imatge_residu) {
        this.imatge_residu = imatge_residu;
    }

    public String getTipus_residu() {
        return tipus_residu;
    }

    public void setTipus_residu(String tipus_residu) {
        this.tipus_residu = tipus_residu;
    }

    public String getDescripcio_residu() {
        return descripcio_residu;
    }

    public void setDescripcio_residu(String descripcio_residu) {
        this.descripcio_residu = descripcio_residu;
    }

    public String getActiu_residu() {
        return actiu_residu;
    }

    public void setActiu_residu(String actiu_residu) {
        this.actiu_residu = actiu_residu;
    }

    public String getValor_residu() {
        return valor_residu;
    }

    public void setValor_residu(String valor_residu) {
        this.valor_residu = valor_residu;
    }

    public String getNom_tipus_residu() {
        return nom_tipus_residu;
    }

    public void setNom_tipus_residu(String nom_tipus_residu) {
        this.nom_tipus_residu = nom_tipus_residu;
    }

    public String getImatge_tipus_residus() {
        return imatge_tipus_residus;
    }

    public void setImatge_tipus_residus(String imatge_tipus_residus) {
        this.imatge_tipus_residus = imatge_tipus_residus;
    }
}



