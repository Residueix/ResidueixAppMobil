package com.example.residueixappmobil.utils;

import com.example.residueixappmobil.utils.ApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "http://10.2.136.45/residueix/api/";
    private static Retrofit retrofit = null;

    public static ApiService getApiService() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiService.class);
    }
    private static Retrofit retrofitFallo = null;

    private static final String BASE_URL_FALLO = "http://10.2.136.45/residueix/api/";


}

