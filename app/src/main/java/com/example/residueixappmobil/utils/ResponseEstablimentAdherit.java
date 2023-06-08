package com.example.residueixappmobil.utils;

import com.example.residueixappmobil.model.EstablimentAdherit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseEstablimentAdherit {
    @SerializedName("llistat")
    private List<EstablimentAdherit> llistat;
    @SerializedName("codi_error")
    private String codiError;
    @SerializedName("error")
    private String error;

    public List<EstablimentAdherit> getLlistat() {
        return llistat;
    }

    public String getCodiError() {
        return codiError;
    }

    public String getError() {
        return error;
    }
}
