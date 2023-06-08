package com.example.residueixappmobil.model;

import com.google.gson.annotations.SerializedName;

public class EstablimentAdherit {

    @SerializedName("id_establiment")
    String id_establiment;
    @SerializedName("nom_establiment")
    String nom_establiment;
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

    public String getId_establiment() {
        return id_establiment;
    }

    public void setId_establiment(String id_establiment) {
        this.id_establiment = id_establiment;
    }

    public String getNom_establiment() {
        return nom_establiment;
    }

    public void setNom_establiment(String nom_establiment) {
        this.nom_establiment = nom_establiment;
    }

    public String getImatge() {
        return imatge;
    }

    public void setImatge(String imatge) {
        this.imatge = imatge;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
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

    public String getHorari() {
        return horari;
    }

    public void setHorari(String horari) {
        this.horari = horari;
    }

    public String getActiu() {
        return actiu;
    }

    public void setActiu(String actiu) {
        this.actiu = actiu;
    }

    public String getId_poblacio() {
        return id_poblacio;
    }

    public void setId_poblacio(String id_poblacio) {
        this.id_poblacio = id_poblacio;
    }

    public String getNom_poblacio() {
        return nom_poblacio;
    }

    public void setNom_poblacio(String nom_poblacio) {
        this.nom_poblacio = nom_poblacio;
    }

    public String getId_provincia() {
        return id_provincia;
    }

    public void setId_provincia(String id_provincia) {
        this.id_provincia = id_provincia;
    }

    public String getNom_provincia() {
        return nom_provincia;
    }

    public void setNom_provincia(String nom_provincia) {
        this.nom_provincia = nom_provincia;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public EstablimentAdherit(String id_establiment, String nom_establiment, String imatge, String latitud, String longitud, String carrer, String cp, String horari, String actiu, String id_poblacio, String nom_poblacio, String id_provincia, String nom_provincia, String descripcio) {
        this.id_establiment = id_establiment;
        this.nom_establiment = nom_establiment;
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
