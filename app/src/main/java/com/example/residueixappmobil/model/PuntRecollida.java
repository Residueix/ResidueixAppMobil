package com.example.residueixappmobil.model;

import com.google.gson.annotations.SerializedName;

public class PuntRecollida {
    @SerializedName("id_punt")
    String id_punt;
    @SerializedName("nom_punt")
    String nom_punt;
    @SerializedName("imatge")
    String imatge;
    @SerializedName("latitud")
    String latitud;
    @SerializedName("longitud")
    String longitud;
    @SerializedName("carrer")
    String carrer;
    @SerializedName("cp")
    String cp;
    @SerializedName("horari")
    String horari;
    @SerializedName("actiu")
    String actiu;
    @SerializedName("id_poblacio")
    String id_poblacio;
    @SerializedName("nom_poblacio")
    String nom_poblacio;
    @SerializedName("id_provincia")
    String id_provincia;
    @SerializedName("nom_provincia")
    String nom_provincia;
    @SerializedName("descripcio")
    String descripcio;

    public void setId_punt(String id_punt) {
        this.id_punt = id_punt;
    }

    public void setNom_punt(String nom_punt) {
        this.nom_punt = nom_punt;
    }

    public void setImatge(String imatge) {
        this.imatge = imatge;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public void setCarrer(String carrer) {
        this.carrer = carrer;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public void setHorari(String horari) {
        this.horari = horari;
    }

    public void setActiu(String actiu) {
        this.actiu = actiu;
    }

    public void setId_poblacio(String id_poblacio) {
        this.id_poblacio = id_poblacio;
    }

    public void setNom_poblacio(String nom_poblacio) {
        this.nom_poblacio = nom_poblacio;
    }

    public void setId_provincia(String id_provincia) {
        this.id_provincia = id_provincia;
    }

    public void setNom_provincia(String nom_provincia) {
        this.nom_provincia = nom_provincia;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public String getId_punt() {
        return id_punt;
    }

    public String getNom_punt() {
        return nom_punt;
    }

    public String getImatge() {
        return imatge;
    }

    public String getLatitud() {
        return latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public String getCarrer() {
        return carrer;
    }

    public String getCp() {
        return cp;
    }

    public String getHorari() {
        return horari;
    }

    public String getActiu() {
        return actiu;
    }

    public String getId_poblacio() {
        return id_poblacio;
    }

    public String getNom_poblacio() {
        return nom_poblacio;
    }

    public String getId_provincia() {
        return id_provincia;
    }

    public String getNom_provincia() {
        return nom_provincia;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public PuntRecollida(String id_punt, String nom_punt, String imatge, String latitud, String longitud, String carrer, String cp, String horari, String actiu, String id_poblacio, String nom_poblacio, String id_provincia, String nom_provincia, String descripcio) {
        this.id_punt = id_punt;
        this.nom_punt = nom_punt;
        this.imatge = imatge;
        this.latitud = latitud;
        this.longitud = longitud;
        this.carrer = carrer;
        this.cp = cp;
        this.horari = horari;
        this.actiu = actiu;
        this.id_poblacio = id_poblacio;
        this.nom_poblacio = nom_poblacio;
        this.id_provincia = id_provincia;
        this.nom_provincia = nom_provincia;
        this.descripcio = descripcio;
    }



}
