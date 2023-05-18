package com.example.residueixappmobil.model;

import com.google.gson.annotations.SerializedName;

public class Desplegable {
    @SerializedName("id")
    int id;
    @SerializedName("nom")
    String nom;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Desplegable(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
}
