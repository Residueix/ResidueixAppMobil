package com.example.residueixappmobil.controller;
/**
 * Classe que conté totes les instruccions de la pantalla de Login.
 *
 * Aquesta classe permet als usuaris iniciar sessió a l'aplicació i validar les seves credencials.
 * Es comunica amb un servei API per realitzar l'autenticació i obtenir les dades de l'usuari.
 * Si l'autenticació és vàlida, l'usuari és redirigit a la pantalla de perfil corresponent al seu tipus.
 * Si l'autenticació no és vàlida, es mostra un missatge d'error.
 *
 * Utilitza Retrofit per realitzar les crides a l'API i Gson per convertir les respostes en objectes Java.
 *
 * @author Albert Montes Miracle
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.residueixappmobil.R;
import com.example.residueixappmobil.model.Usuari;
import com.example.residueixappmobil.utils.ApiService;
import com.example.residueixappmobil.utils.RetrofitClient;
import com.example.residueixappmobil.utils.ResponseLogin;
import com.example.residueixappmobil.utils.xifratParaulaClau;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {

    private EditText tvUsuari;
    private EditText tvPassword;

    private Usuari mUsuari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_login);
        tvUsuari = findViewById(R.id.editTextTextPersonName);
        tvPassword = findViewById(R.id.editTextTextPassword);
        Button loginButton = findViewById(R.id.boto_acceptar_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    validarLogin();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private void validarLogin() throws Exception {
        String tVusuari = tvUsuari.getText().toString();
        String tVpassword = tvPassword.getText().toString();

        if (!tVusuari.equals("") && !tVpassword.equals("")) {

            ApiService apiService = RetrofitClient.getApiService();
            Call<ResponseLogin> call = apiService.login(tVusuari, xifratParaulaClau.encrypt(tVpassword));
            call.enqueue(new Callback<>() {
                @Override
                public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                    if (response.isSuccessful()) {
                        ResponseLogin responseLogin = response.body();
                        String error;
                        if (responseLogin != null && responseLogin.getCodiError().equals("0")) {

                            mUsuari = new Usuari();
                            mUsuari.setId(Integer.parseInt(responseLogin.getId()));
                            mUsuari.setTipus(Integer.parseInt(responseLogin.getTipus()));
                            mUsuari.setEmail(responseLogin.getEmail());
                            mUsuari.setPassword(responseLogin.getPassword());
                            mUsuari.setNom(responseLogin.getNom());
                            mUsuari.setCognom1(responseLogin.getCognom1());
                            mUsuari.setCognom2(responseLogin.getCognom2());
                            mUsuari.setToken(responseLogin.getToken());


                            SharedPreferences sharedPreferences = getSharedPreferences("Usuari_persistent", MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            String jsonUsuari = new Gson().toJson(mUsuari);
                            editor.putString("json", jsonUsuari);
                            editor.apply();

                            String tipus = responseLogin.getTipus();

                            if (tipus.equals("3")) {
                                Intent intent = new Intent(LoginActivity.this, PerfilResiduentActivity.class);
                                startActivity(intent);
                            } else if (tipus.equals("4")) {
                                Intent intent = new Intent(LoginActivity.this, PerfilAdheritActivity.class);
                                startActivity(intent);
                            }

                        } else {
                            error = responseLogin != null ? responseLogin.getError() : "Error desconocido";
                            Toast.makeText(LoginActivity.this, "Error: " + error , Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<ResponseLogin> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, "Error de red", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(this, "Introdueix un nom usuari i contrasenya correctes.", Toast.LENGTH_SHORT).show();
        }
    }

    public void tornarEnrera(View view) {
        finish();
    }
}





