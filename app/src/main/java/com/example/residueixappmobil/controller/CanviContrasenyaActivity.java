package com.example.residueixappmobil.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.residueixappmobil.R;
import com.example.residueixappmobil.model.Usuari;
import com.example.residueixappmobil.model.UsuariConsulta;
import com.example.residueixappmobil.utils.ApiService;
import com.example.residueixappmobil.utils.ResponseConsultaUsuari;
import com.example.residueixappmobil.utils.ResponseLogin;
import com.example.residueixappmobil.utils.RetrofitClient;
import com.example.residueixappmobil.utils.xifratParaulaClau;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CanviContrasenyaActivity extends AppCompatActivity {
    UsuariConsulta mUsuariConsulta;
    ApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvi_contrasenya_acticity);

        SharedPreferences sharedPreferences = getSharedPreferences("Usuari_persistent_extes", MODE_PRIVATE);
        SharedPreferences sharedPreferencesAdmin = getSharedPreferences("Usuari_administrador", MODE_PRIVATE);
        String jsonUsuari = sharedPreferences.getString("json", null);
        if (jsonUsuari != null) {
            mUsuariConsulta = new Gson().fromJson(jsonUsuari, UsuariConsulta.class);
        }
        mApiService = RetrofitClient.getApiService();
    }

    public void modificarUsuari(View view) throws Exception {
        SharedPreferences sharedPreferences = getSharedPreferences("Usuari_persistent_extes", MODE_PRIVATE);
        SharedPreferences sharedPreferencesAdmin = getSharedPreferences("Usuari_administrador", MODE_PRIVATE);
        SharedPreferences sharedPreferenceuser = getSharedPreferences("Usuari_persistent", MODE_PRIVATE);

        EditText editTextAntigaContrasenya = findViewById(R.id.editTextAntigaContrasenya);

        if (!editTextAntigaContrasenya.getText().toString().isEmpty()) {
            if (mUsuariConsulta != null && xifratParaulaClau.decrypt(mUsuariConsulta.getPassword()).equals(editTextAntigaContrasenya.getText().toString())) {

                String idUsuari = mUsuariConsulta.getId();  // obtener id de usuario

                String id = sharedPreferencesAdmin.getString("id_usuari", null);// obtener id
                String token = sharedPreferencesAdmin.getString("token", null); // obtener token
                String permis = sharedPreferencesAdmin.getString("permis", null); // obtener permis
                String nom = mUsuariConsulta.getNom(); // obtener nombre
                String cognom1 = mUsuariConsulta.getCognom1(); // obtener cognom1
                String cognom2 = mUsuariConsulta.getCognom2(); // obtener cognom2
                String tipus = mUsuariConsulta.getTipus(); // obtener tipo
                String email = mUsuariConsulta.getEmail(); // obtener email
                String password = mUsuariConsulta.getPassword(); // obtener password
                String telefon = mUsuariConsulta.getTelefon(); // obtener telefono
                String actiu = mUsuariConsulta.getActiu(); // obtener actiu
                String carrer = mUsuariConsulta.getCarrer(); // obtener carrer
                String poblacio = mUsuariConsulta.getPoblacio(); // obtener poblacio
                String cp = mUsuariConsulta.getCp(); // obtener cp

                Call<ResponseConsultaUsuari> call = null;
                if (mUsuariConsulta.getTipus().equals("3")) {
                    call = mApiService.modificarUsuariResiduent(idUsuari, id, token, permis, nom, cognom1, cognom2, tipus, email, password, telefon, actiu, carrer, poblacio, cp);
                } else if (mUsuariConsulta.getTipus().equals("4")) {
                    String nomAdherit = mUsuariConsulta.getNomAdherit();// obtener nomAdherit
                    String tipusAdherit = mUsuariConsulta.getTipusAdherit();// obtener tipusAdherit
                    String horari = mUsuariConsulta.getHorari(); // obtener horari
                    call = mApiService.modificarUsuariAdherit(idUsuari, id, token, permis, nom, cognom1, cognom2, tipus, email, password, telefon, actiu, nomAdherit, tipusAdherit, horari, carrer, poblacio, cp);
                } else {
                    return;
                }

                call.enqueue(new Callback<>() {

                    @Override
                    public void onResponse(Call<ResponseConsultaUsuari> call, Response<ResponseConsultaUsuari> response) {
                        if (response.isSuccessful()) {
                            ResponseConsultaUsuari responseConsultaUsuari = response.body();
                            Toast.makeText(CanviContrasenyaActivity.this, "Usuari modificat correctament", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(CanviContrasenyaActivity.this, "Error: " + response.code() + " " + response.message(), Toast.LENGTH_SHORT).show();
                        }
                    }


                    @Override
                    public void onFailure(Call<ResponseConsultaUsuari> call, Throwable t) {
                        Toast.makeText(CanviContrasenyaActivity.this, "Missatge" + mUsuariConsulta.getCodiError(), Toast.LENGTH_SHORT).show();

                    }
                });

            } else {
                Toast.makeText(this, "La contraseña introducida no es correcta", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Por favor, introduce tu contraseña antigua", Toast.LENGTH_SHORT).show();
        }
    }

    public void tornarEnrera(View view) {
        Intent intentPPrincipal = new Intent(this, PPrincipalActivity.class);
        startActivity(intentPPrincipal);
        finish(); // opcional, si quieres que el botón atrás del dispositivo no regrese a la pantalla de perfil.
    }
}