package com.example.residueixappmobil.utils;




import okhttp3.ResponseBody;
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
    Call<ResponseLogin> llistatResidus(@Field("id_usuari") String id, @Field("token") String token, @Field("permis") String permis);


}

