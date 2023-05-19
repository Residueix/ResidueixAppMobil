package com.example.residueixappmobil.controller;
/**
 * Classe que conté totes les instruccions de la pantalla principal.
 * L'activitat principal és responsable de la gestió dels usuaris (login, logout i registre) i de l'interacció amb la interfície d'usuari.
 *
 * @author Albert Montes Miracle
 */

import static com.example.residueixappmobil.utils.RetrofitClient.getApiService;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.residueixappmobil.R;
import com.example.residueixappmobil.model.Usuari;
import com.example.residueixappmobil.utils.ApiService;
import com.example.residueixappmobil.utils.ResponseLogin;
import com.example.residueixappmobil.utils.RetrofitClient;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PPrincipalActivity extends AppCompatActivity {
    Usuari mUsuari;
    Button mButton;

    /**
     * Mètode onCreate que s'executa quan es crea l'activitat.
     * Aquí es carreguen les preferències de l'usuari i es fa una crida a l'API per iniciar la sessió com a administrador.
     *
     * @param savedInstanceState Conté l'estat de l'aplicació per a que pugui ser restaurada si es requereix.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pprincipal);

        SharedPreferences sharedPreferences = getSharedPreferences("Usuari_persistent", MODE_PRIVATE);
        String jsonUsuari = sharedPreferences.getString("json", null);
        if (jsonUsuari != null) {
            mUsuari = new Gson().fromJson(jsonUsuari, Usuari.class);
        }

        ApiService apiService = RetrofitClient.getApiService();
        Call<ResponseLogin> call = apiService.login("administrador@residueix.com", "administrador");
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                if (response.isSuccessful()) {
                    SharedPreferences sharedPreferences = getSharedPreferences("Usuari_administrador", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    ResponseLogin responseLogin = response.body();

                    editor.putString("id_usuari", responseLogin.getId());
                    editor.putString("token", responseLogin.getToken());
                    editor.putString("permis", responseLogin.getTipus());
                    editor.commit();

                }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Toast.makeText(PPrincipalActivity.this, "Error de red", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Aquest mètode es crida quan l'activitat torna a l'estat actiu.
     * Aquí es carreguen de nou les preferències de l'usuari i es configura el botó de login.
     */
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("Usuari_persistent", MODE_PRIVATE);
        String jsonUsuari = sharedPreferences.getString("json", null);
        if (jsonUsuari != null) {
            mUsuari = new Gson().fromJson(jsonUsuari, Usuari.class);
        }
        mButton = findViewById(R.id.login_button);
        if (mUsuari != null && !mUsuari.getNom().isEmpty()) {
            Toast.makeText(this, "Nom: " + mUsuari.getNom(), Toast.LENGTH_SHORT).show();

            mButton.setText(mUsuari.getNom());
            // Cambia el aspecto del botón como desees
            mButton.setBackgroundColor(getResources().getColor(R.color.blau_menu));

        }
    }

    /**
     * En pitjar a l'imatge login ens mostra LoginActivity.
     * Aquest mètode es crida quan l'usuari clica sobre el botó de login.
     *
     * @param view La vista on es va produir el clic.
     */
    public void loginButton(View view) {
        finish();
        Intent intentPantallaLogin = new Intent(this, LoginActivity.class);
        startActivity(intentPantallaLogin);

    }

    /**
     * Aquest mètode es crida quan l'usuari clica sobre el botó de tancar sessió (logout).
     * Aquest mètode fa una crida a l'API per tancar la sessió.
     *
     * @param view La vista on es va produir el clic.
     */
    public void logout(View view) {
        ApiService apiService = getApiService();
        Call<ResponseLogin> call = apiService.logout(String.valueOf(mUsuari.getId()), mUsuari.getToken());
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                if (response.isSuccessful()) {
                    ResponseLogin responseLogin = response.body();
                    if (responseLogin.getCodiError().equalsIgnoreCase("0")) {
                        SharedPreferences sharedPreferences = getSharedPreferences("Usuari_persistent", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("json", null);
                        editor.clear();
                        editor.apply();
                        editor.commit();
                        mButton.setText("Login");
                        mButton.setBackgroundColor(getResources().getColor(R.color.blau_menu));

                    } else {
                        Toast.makeText(PPrincipalActivity.this, "Token usuari:" + mUsuari.getToken(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(PPrincipalActivity.this, "Error" + responseLogin.getCodiError(), Toast.LENGTH_SHORT).show();

                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Toast.makeText(PPrincipalActivity.this, "Error de red", Toast.LENGTH_SHORT).show();
            }
        });

    }

    /**
     * Aquest mètode es crida quan l'usuari clica sobre el botó de registre.
     *
     * @param view La vista on es va produir el clic.
     */
    public void registreButton(View view) {
        Intent intentPantallaRegistre = new Intent(this, RegistreActivity.class);
        intentPantallaRegistre.setAction(Intent.ACTION_SEND);
        startActivity(intentPantallaRegistre);


    }

    /**
     * Aquest mètode es crida quan l'usuari clica sobre el botó de QuiSom.
     *
     * @param view La vista on es va produir el clic.
     */
    public void quiSomButton(View view) {
        Intent intentPantallaQuiSom = new Intent(this, QuiSomActivity.class);
        intentPantallaQuiSom.setAction(Intent.ACTION_SEND);
        startActivity(intentPantallaQuiSom);
    }

    /**
     * Aquest mètode es crida quan l'usuari clica sobre el botó de Residus.
     *
     * @param view La vista on es va produir el clic.
     */

    public void tipusResidusButton(View view) {
        Intent intentPantallaTipusResidus = new Intent(this, TipusResiduActivity.class);
        intentPantallaTipusResidus.setAction(Intent.ACTION_SEND);
        startActivity(intentPantallaTipusResidus);
    }

    /**
     * Aquest mètode es crida quan l'activitat està a punt de ser aturada.
     * Aquí es netegen les preferències de l'usuari.
     */
    @Override
    protected void onStop() {
        SharedPreferences sharedPreferences = getSharedPreferences("Usuari_persistent", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("json", null);
        editor.clear();
        editor.apply();
        editor.commit();

        super.onStop();

    }

    /**
     * Aquest mètode es crida quan l'activitat està a punt de ser destruïda.
     * Aquí es netegen les preferències de l'usuari i es tanca la sessió d'administrador i l'actualment loginejat.
     */
    @Override
    protected void onDestroy() {

        SharedPreferences sharedPreferences = getSharedPreferences("Usuari_persistent", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("json", null);
        editor.clear();
        editor.apply();
        editor.commit();


        SharedPreferences sharedPreferencesAdmin = getSharedPreferences("Usuari_administrador", MODE_PRIVATE);
        ApiService apiService = RetrofitClient.getApiService();

        Call<ResponseLogin> call = apiService.logout(sharedPreferencesAdmin.getString("id_usuari", null), sharedPreferencesAdmin.getString("token", null));
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                // TODO document why this method is empty
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                // TODO document why this method is empty
            }
        });
        super.onDestroy();
    }
}

