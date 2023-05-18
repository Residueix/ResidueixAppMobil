package com.example.residueixappmobil;
/**
 * Classe que conté totes les instruccions de la pantalla de Login.
 *
 * @author Albert Montes Miracle
 * @version 23/03/2023
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                        if (responseLogin.getCodiError().equals("0")) {

                            mUsuari = new Usuari();
                            mUsuari.setId(Integer.parseInt(responseLogin.getId()));
                            mUsuari.setTipus(Integer.parseInt(responseLogin.getTipus()));
                            mUsuari.setEmail(responseLogin.getEmail());
                            mUsuari.setPassword(responseLogin.getPassword());
                            mUsuari.setNom(responseLogin.getNom());
                            mUsuari.setCognom1(responseLogin.getCognom1());
                            mUsuari.setCognom2(responseLogin.getCognom2());
                            mUsuari.setToken(responseLogin.getToken());

                            String tipus = responseLogin.getTipus();
                            String actiu = responseLogin.getActiu();
                            error = responseLogin.getError();
                            String cError = responseLogin.getCodiError();
                            String id = responseLogin.getId();
                            //Toast.makeText(LoginActivity.this, "Codi error : " + cError + "Tipus: " + tipus,
                            //      Toast.LENGTH_SHORT).show();


                            SharedPreferences sharedPreferences = getSharedPreferences("Usuari_persistent", MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            String jsonUsuari = new Gson().toJson(mUsuari);
                            editor.putString("json", jsonUsuari);
                            editor.commit();

                            if (tipus.equals("3")) {

                                Intent intent = new Intent(LoginActivity.this, PerfilResiduentActivity.class);

                                startActivity(intent);

                            } else if (tipus.equals("4")) {
                                Toast.makeText(LoginActivity.this, "Es tipus:" + tipus, Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginActivity.this, PerfilAdheritActivity.class);
                                startActivity(intent);
                            }


                        } else {
                            error = responseLogin.getError();
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
        Intent intent = new Intent(LoginActivity.this, PPrincipalActivity.class);
        startActivity(intent);

    }
}





