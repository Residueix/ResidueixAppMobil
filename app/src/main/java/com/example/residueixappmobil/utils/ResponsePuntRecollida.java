package com.example.residueixappmobil.utils;

import com.example.residueixappmobil.model.PuntRecollida;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ResponsePuntRecollida {
    @SerializedName("llistat")
    private List<PuntRecollida> llistat;
    @SerializedName("codi_error")
    private String codiError;
    @SerializedName("error")
    private String error;

    public List<PuntRecollida> getLlistat() {
        return llistat;
    }

    public String getCodiError() {
        return codiError;
    }

    public String getError() {
        return error;
    }
}
