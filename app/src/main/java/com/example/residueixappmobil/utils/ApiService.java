package com.example.residueixappmobil.utils;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST("login/index.php")
    Call<TokenResponse> login(@Field("usuari") String username, @Field("password") String password);


}

