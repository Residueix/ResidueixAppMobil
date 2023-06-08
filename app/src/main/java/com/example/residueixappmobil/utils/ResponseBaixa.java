package com.example.residueixappmobil.utils;

import com.google.gson.annotations.SerializedName;

public class ResponseBaixa {
    @SerializedName("codi_error")
    private String codiError;
    @SerializedName("accio")
    private String accio;

    @SerializedName("descripcio")
    private String descripcio;

    @SerializedName("id")
    private String id;

    public String getCodiError() {
        return codiError;
    }

    public void setCodiError(String codiError) {
        this.codiError = codiError;
    }


    public String getAccio() {
        return accio;
    }

    public void setAccio(String accio) {
        this.accio = accio;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
