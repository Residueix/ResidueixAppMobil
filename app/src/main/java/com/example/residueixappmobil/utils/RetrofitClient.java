package com.example.residueixappmobil.utils;

import com.example.residueixappmobil.utils.ApiService;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Aquesta classe és responsable de la configuració i creació d'instàncies de Retrofit per interactuar amb l'API del servidor.
 * Proporciona un mètode per obtenir una instància de l'interfície ApiService ja configurada.
 * @author Albert Montes Miracle
 */
public class RetrofitClient {

    private static final String BASE_URL = "https://10.2.136.45/residueix/api/";
    private static Retrofit retrofit = null;

    /**
     * Obté una instància de l'interfície ApiService ja configurada per interactuar amb l'API del servidor.
     *
     * @return Instància de l'interfície ApiService per realitzar crides a l'API.
     */
    public static ApiService getApiService() {
        if (retrofit == null) {
             retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(UnsafeOkHttpClient.getUnsafeOkHttpClient())
                     .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiService.class);
    }
}
