package com.example.residueixappmobil.utils;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Aquesta interfície defineix els mètodes per a realitzar crides a l'API del servei.
 * Utilitza la biblioteca Retrofit per gestionar les crides HTTP.
 *
 * @author Albert Montes Miracle
 */
public interface ApiService {

    /**
     * Realitza una crida POST per iniciar la sessió d'usuari.
     *
     * @param username Nom d'usuari
     * @param password Contrasenya de l'usuari
     * @return Una crida a ResponseLogin que conté la resposta del servidor
     */
    @FormUrlEncoded
    @POST("login/index.php")
    Call<ResponseLogin> login(@Field("usuari") String username, @Field("password") String password);

    /**
     * Realitza una crida POST per tancar la sessió d'usuari.
     *
     * @param id    Identificador de l'usuari
     * @param token Token de sessió de l'usuari
     * @return Una crida a ResponseLogin que conté la resposta del servidor
     */
    @FormUrlEncoded
    @POST("logout/index.php")
    Call<ResponseLogin> logout(@Field("id") String id, @Field("token") String token);

    /**
     * Realitza una crida POST per obtenir la llista de residus.
     *
     * @param id     Identificador de l'usuari
     * @param token  Token de sessió de l'usuari
     * @param permis Permisos de l'usuari
     * @return Una crida a ResponseResidus que conté la resposta del servidor
     */
    @FormUrlEncoded
    @POST("residus/llistat/index.php")
    Call<ResponseResidus> llistatResidus(@Field("id_usuari") String id, @Field("token") String token, @Field("permis") String permis);

    /**
     * Realitza una crida POST per obtenir la llista de poblacions.
     *
     * @param token Token de sessió de l'usuari
     * @return Una crida a ResponsePoblacio que conté la resposta del servidor
     */
    @FormUrlEncoded
    @POST("global/poblacions/index.php")
    Call<ResponsePoblacio> llistatPoblacions(@Field("token") String token);

    /**
     * Realitza una crida POST per obtenir la llista de tipus adherit.
     *
     * @param token Token de sessió de l'usuari
     * @return Una crida a ResponseTipusAdherit que conté la resposta del servidor
     */
    @FormUrlEncoded
    @POST("global/tipusadherit/index.php")
    Call<ResponseTipusAdherit> llistatTipusAdherit(@Field("token") String token);

    /**
     * Realitza una crida POST per crear un usuari residu ent.
     *
     * @param id       Identificador de l'usuari
     * @param token    Token de sessió de l'usuari
     * @param permis   Permisos de l'usuari
     * @param nom      Nom de l'usuari residu
     * @param cognom1  Primer cognom de l'usuari
     * @param cognom2  Segon cognom de l'usuari
     * @param tipus    Tipus de l'usuari
     * @param email    Email de l'usuari
     * @param password Contrasenya de l'usuari
     * @param telefon  Telèfon de l'usuari
     * @param actiu    Estat d'activació de l'usuari
     * @param carrer   Carrer de l'usuari
     * @param poblacio Població de l'usuari
     * @param cp       Codi postal de l'usuari
     * @return Una crida a ResponseAlta que conté la resposta del servidor
     */
    @FormUrlEncoded
    @POST("usuaris/alta/residuent/index.php")
    Call<ResponseAlta> crearUsuariResiduent(@Field("id_usuari") String id, @Field("token") String token,
                                            @Field("permis") String permis, @Field("nom") String nom,
                                            @Field("cognom1") String cognom1, @Field("cognom2") String cognom2,
                                            @Field("tipus") String tipus, @Field("email") String email,
                                            @Field("password") String password, @Field("telefon") String telefon,
                                            @Field("actiu") String actiu, @Field("carrer") String carrer,
                                            @Field("poblacio") String poblacio, @Field("cp") String cp);

    @FormUrlEncoded
    @POST("puntsrecollida/llistat/index.php")
    Call<ResponsePuntRecollida> llistatPuntsRecollida(@Field("token") String token);

    @FormUrlEncoded
    @POST("puntsrecollida/llistat/index.php")
    Call<ResponseEstablimentAdherit> llistatEstablimentsAdherits(@Field("token") String token);

    @FormUrlEncoded
    @POST("usuaris/baixa/index.php")
    Call<ResponseBaixa> baixaUsuari(@Field("token") String token, @Field("id_usuari") String id_usuari, @Field("id") String id, @Field("permis") String permis);

    @FormUrlEncoded
    @POST("usuaris/consulta/index.php")
    Call<ResponseConsultaUsuari> consultaUsuari(@Field("token") String token, @Field("id_usuari") String id_usuari, @Field("id") String id, @Field("permis") String permis);

@FormUrlEncoded
    @POST("usuaris/modificacio/residuent/index.php")
    Call<ResponseConsultaUsuari> modificarUsuariResiduent(@Field("id_usuari") String idUsuari,@Field("id") String id, @Field("token") String token,
                                                          @Field("permis") String permis, @Field("nom") String nom,
                                                          @Field("cognom1") String cognom1, @Field("cognom2") String cognom2,
                                                          @Field("tipus") String tipus, @Field("email") String email,
                                                          @Field("password") String password, @Field("telefon") String telefon,
                                                          @Field("actiu") String actiu, @Field("carrer") String carrer,
                                                          @Field("poblacio") String poblacio, @Field("cp") String cp);
@FormUrlEncoded
    @POST("usuaris/modificacio/adherit/index.php")
    Call<ResponseConsultaUsuari> modificarUsuariAdherit(@Field("id_usuari") String idUsuari,@Field("id") String id,
                                                        @Field("token") String token, @Field("permis") String permis,
                                                        @Field("nom") String nom,@Field("cognom1") String cognom1,
                                                        @Field("cognom2") String cognom2,
                                                        @Field("tipus") String tipus, @Field("email") String email,
                                                        @Field("password") String password, @Field("telefon") String telefon,
                                                        @Field("actiu") String actiu,@Field("nom_adherit") String nomAdherit,
                                                        @Field("tipus_adherit") String tipusAdherit,
                                                        @Field("horari") String horari, @Field("carrer") String carrer,
                                                        @Field("poblacio") String poblacio, @Field("cp") String cp);

}


