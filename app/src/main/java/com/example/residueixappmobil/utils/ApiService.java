package com.example.residueixappmobil.utils;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    @FormUrlEncoded
    @POST("login/index.php")
    Call<ResponseLogin> login(@Field("usuari") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("logout/index.php")
    Call<ResponseLogin> logout(@Field("id") String id, @Field("token") String token);

    @FormUrlEncoded
    @POST("residus/llistat/index.php")
    Call<ResponseResidus> llistatResidus(@Field("id_usuari") String id, @Field("token") String token, @Field("permis") String permis);

    @FormUrlEncoded
    @POST("global/poblacions/index.php")
    Call<ResponsePoblacio> llistatPoblacions(@Field("token") String token);

    @FormUrlEncoded
    @POST("global/tipusadherit/index.php")
    Call<ResponseTipusAdherit> llistatTipusAdherit(@Field("token") String token);

    @FormUrlEncoded
    @POST("usuaris/alta/residuent/index.php")
    Call<ResponseAlta> crearUsuariResiduent(@Field("id_usuari") String id, @Field("token") String token,
                                            @Field("permis") String permis, @Field("nom") String nom,
                                            @Field("cognom1") String cognom1, @Field("cognom2") String cognom2,
                                            @Field("tipus") String tipus,@Field("email") String email,
                                            @Field("password") String password,@Field("telefon") String telefon,
                                            @Field("actiu") String actiu,@Field("carrer") String carrer,
                                            @Field("poblacio") String poblacio,@Field("cp") String cp );

}

