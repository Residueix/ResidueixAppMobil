package com.example.residueixappmobil.model;

import com.google.gson.annotations.SerializedName;

public class Poblacio {

    @SerializedName("id")
    String id;
    @SerializedName("nom")
    String nom;
    @SerializedName("id_provincia")
    String id_provincia;
    @SerializedName("nom_provincia")
    String nom_provincia;


    public Poblacio(String id, String nom, String id_provincia, String nom_provincia) {
        this.id = id;
        this.nom = nom;
        this.id_provincia = id_provincia;
        this.nom_provincia = nom_provincia;
    }

    public String getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }

    public String getId_provincia() {
        return id_provincia;
    }

    public String getNom_provincia() {
        return nom_provincia;
    }
}
