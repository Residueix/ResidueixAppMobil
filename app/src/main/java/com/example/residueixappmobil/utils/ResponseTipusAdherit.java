package com.example.residueixappmobil.utils;

import com.example.residueixappmobil.model.TipusAdherit;
import com.google.gson.annotations.SerializedName;

import java.util.List;

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

