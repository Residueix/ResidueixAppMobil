package com.example.residueixappmobil.model;

import com.google.gson.annotations.SerializedName;

public class TipusAdherit {
    @SerializedName("id")
    String id;
    @SerializedName("nom")
    String nom;

    public TipusAdherit(String id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
}
