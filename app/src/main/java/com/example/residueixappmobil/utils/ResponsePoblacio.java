package com.example.residueixappmobil.utils;

import com.example.residueixappmobil.model.Poblacio;
import com.example.residueixappmobil.model.Residu;
import com.google.gson.annotations.SerializedName;

import java.util.List;
/**
 * Aquesta classe representa la resposta del servidor a una crida de consulta del llistat de poblacions.
 * Conté les dades retornades pel servidor després de realitzar l'acció de consulta del llistat de poblacions.
 * @author Albert Montes Miracle
 */
public class ResponsePoblacio {

    @SerializedName("llistat")
    private List<Poblacio> llistat;
    @SerializedName("codi_error")
    private String codiError;
    @SerializedName("error")
    private String error;

    public List<Poblacio> getLlistat() {
        return llistat;
    }

    public String getCodiError() {
        return codiError;
    }

    public String getError() {
        return error;
    }
}
