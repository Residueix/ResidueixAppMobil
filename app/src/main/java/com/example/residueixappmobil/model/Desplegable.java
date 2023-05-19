package com.example.residueixappmobil.model;

import com.google.gson.annotations.SerializedName;

/**
 * Classe model Desplegable que conté totes les carcterístiques dels desplegables que necessitarem a l'app.
 *
 * @author Albert Montes Miracle
 */

public class Desplegable {
    @SerializedName("id")
    int id;
    @SerializedName("nom")
    String nom;


    public int getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }


    public Desplegable(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
}
