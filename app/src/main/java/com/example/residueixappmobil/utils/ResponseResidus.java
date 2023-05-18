package com.example.residueixappmobil.utils;

import com.example.residueixappmobil.model.Residu;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseResidus {

    @SerializedName("llistat")
    private List<Residu> llistat;
    @SerializedName("codi_error")
    private String codiError;
    @SerializedName("error")
    private String error;

    public List<Residu> getLlistat() {
        return llistat;
    }

    public String getCodiError() {
        return codiError;
    }

    public String getError() {
        return error;
    }
}
