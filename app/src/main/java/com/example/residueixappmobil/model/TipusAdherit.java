package com.example.residueixappmobil.model;

import com.google.gson.annotations.SerializedName;
/**
 * Classe model TipusAdherit que ens serveix per representar cada un dels tipus d'Adherit que recuperem de l'API
 *
 * @author Albert Montes Miracle
 */
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
