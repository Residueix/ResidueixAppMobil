package com.example.residueixappmobil.utils;

import com.google.gson.annotations.SerializedName;
/**
 * Aquesta classe representa la resposta del servidor a una crida d'alta.
 * Conté les dades retornades pel servidor després de realitzar l'acció d'alta.
 * @author Albert Montes Miracle
 */
public class ResponseAlta {

    @SerializedName("codi_error")
    private String codiError;

    @SerializedName("error")
    private String error;

    @SerializedName("accio")
    private String accio;

    @SerializedName("descripcio")
    private String descripcio;

    @SerializedName("id")
    private String id;

}
