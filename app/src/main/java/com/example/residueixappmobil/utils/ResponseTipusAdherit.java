package com.example.residueixappmobil.utils;

import com.example.residueixappmobil.model.TipusAdherit;
import com.google.gson.annotations.SerializedName;

import java.util.List;
/**
 * Aquesta classe representa la resposta del servidor a una crida de consulta del llistat de tipus d'adherits.
 * Conté les dades retornades pel servidor després de realitzar l'acció de consulta del llistat de tipus d'adherits.
 * @author Albert Montes Miracle
 */
public class ResponseTipusAdherit {

    @SerializedName("llistat")
    private List<TipusAdherit> llistat;
    @SerializedName("codi_error")
    private String codiError;
    @SerializedName("error")
    private String error;

    public List<TipusAdherit> getLlistat() {
        return llistat;
    }

    public String getCodiError() {
        return codiError;
    }

    public String getError() {
        return error;
    }
}

