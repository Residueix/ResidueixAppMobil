package com.example.residueixappmobil.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.residueixappmobil.R;
import com.example.residueixappmobil.model.Usuari;
import com.example.residueixappmobil.model.UsuariConsulta;
import com.example.residueixappmobil.utils.ApiService;
import com.example.residueixappmobil.utils.ResponseBaixa;
import com.example.residueixappmobil.utils.ResponseConsultaUsuari;
import com.example.residueixappmobil.utils.ResponseLogin;
import com.example.residueixappmobil.utils.RetrofitClient;
import com.google.gson.Gson;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilAdheritActivity extends AppCompatActivity {
    // Aquesta variable manté una instància de l'usuari actual.
    UsuariConsulta mUsuariConsulta;
    Usuari mUsuari;

    /**
     * Aquest mètode s'executa quan es crea l'activitat.
     * Carrega les preferències de l'usuari, obté les dades de l'usuari i les mostra en la vista.
     *
     * @param savedInstanceState Conté l'estat de l'aplicació per a que pugui ser restaurada si es requereix.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        SharedPreferences sharedPreferences = getSharedPreferences("Usuari_persistent", MODE_PRIVATE);
        String jsonUsuari = sharedPreferences.getString("json", null);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_adherit);
        if (jsonUsuari != null) {
            mUsuari = new Gson().fromJson(jsonUsuari, Usuari.class);
        }
        TextView textViewNom = findViewById(R.id.textViewNom);
        TextView textViewCognoms = findViewById(R.id.textViewCognoms);
        TextView textViewCorreu = findViewById(R.id.textViewCorreu);
        TextView textViewTelefon = findViewById(R.id.textViewTelefon);

        if (mUsuari != null) {
            textViewNom.setText("Nom: " + mUsuari.getNom());
            textViewCognoms.setText("Cognoms: " + mUsuari.getCognom1() + " ," + mUsuari.getCognom2());
            textViewCorreu.setText("Correu: " + mUsuari.getEmail());
            textViewTelefon.setText("Telefon: " + mUsuari.getTelefon());
        } else {
            // Aquí puedes manejar el caso en el que mUsuari es null.
            // Por ejemplo, puedes mostrar un mensaje de error al usuario.
            Toast.makeText(this, "Error: no es pot obtenir la informacio d usuari", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    protected void onResume() {

        SharedPreferences sharedPreferences = getSharedPreferences("Usuari_persistent", MODE_PRIVATE);
        String jsonUsuari = sharedPreferences.getString("json", null);
        super.onResume();
        setContentView(R.layout.activity_perfil_adherit);
        if (jsonUsuari != null) {
            mUsuari = new Gson().fromJson(jsonUsuari, Usuari.class);
        }
        TextView textViewNom = findViewById(R.id.textViewNom);
        TextView textViewCognoms = findViewById(R.id.textViewCognoms);
        TextView textViewCorreu = findViewById(R.id.textViewCorreu);
        TextView textViewTelefon = findViewById(R.id.textViewTelefon);

        if (mUsuari != null) {
            textViewNom.setText("Nom: " + mUsuari.getNom());
            textViewCognoms.setText("Cognoms: " + mUsuari.getCognom1() + " ," + mUsuari.getCognom2());
            textViewCorreu.setText("Correu: " + mUsuari.getEmail());
            textViewTelefon.setText("Telefon: " + mUsuari.getTelefon());
        } else {
            // Aquí puedes manejar el caso en el que mUsuari es null.
            // Por ejemplo, puedes mostrar un mensaje de error al usuario.
            Toast.makeText(this, "Error: no se pudo obtener la información del usuario", Toast.LENGTH_SHORT).show();
        }

    }

    public void baixaUsuari(View view) throws Exception {
        SharedPreferences sharedPreferences = getSharedPreferences("Usuari_persistent", MODE_PRIVATE);
        SharedPreferences sharedPreferencesAdmin = getSharedPreferences("Usuari_administrador", MODE_PRIVATE);
        ApiService apiService = RetrofitClient.getApiService();
        Call<ResponseBaixa> call = apiService.baixaUsuari(sharedPreferencesAdmin.getString("token", null), sharedPreferencesAdmin.getString("id_usuari", null), String.valueOf(mUsuari.getId()), sharedPreferencesAdmin.getString("permis", null));
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<ResponseBaixa> call, Response<ResponseBaixa> response) {
                if (response.isSuccessful()) {
                    ResponseBaixa responseBaixa = response.body();
                    Toast.makeText(PerfilAdheritActivity.this, responseBaixa.getDescripcio(), Toast.LENGTH_SHORT).show();

                }


            }

            ;

            @Override
            public void onFailure(Call<ResponseBaixa> call, Throwable t) {
                Toast.makeText(PerfilAdheritActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                System.out.println("Error: " + t.getMessage());

                Toast.makeText(PerfilAdheritActivity.this, "Error de red", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void canviContrasenya(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("Usuari_persistent", MODE_PRIVATE);
        SharedPreferences sharedPreferencesAdmin = getSharedPreferences("Usuari_administrador", MODE_PRIVATE);
        ApiService apiService = RetrofitClient.getApiService();
        Call<ResponseConsultaUsuari> call = apiService.consultaUsuari(sharedPreferencesAdmin.getString("token", null), sharedPreferencesAdmin.getString("id_usuari", null), String.valueOf(mUsuari.getId()), sharedPreferencesAdmin.getString("permis", null));
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<ResponseConsultaUsuari> call, Response<ResponseConsultaUsuari> response) {

                if (response.isSuccessful()) {
                    ResponseConsultaUsuari responseConsultaUsuari = response.body();
                    Toast.makeText(PerfilAdheritActivity.this, "codi error"+responseConsultaUsuari.getCodiError(), Toast.LENGTH_SHORT).show();

                    Toast.makeText(PerfilAdheritActivity.this, responseConsultaUsuari.getDescripcio(), Toast.LENGTH_SHORT).show();


                    if (responseConsultaUsuari.getCodiError().equals("0")) {

                        mUsuariConsulta = new UsuariConsulta();
                        mUsuariConsulta.setId(responseConsultaUsuari.getId());
                        mUsuariConsulta.setTipus(responseConsultaUsuari.getTipus());
                        mUsuariConsulta.setEmail(responseConsultaUsuari.getEmail());
                        mUsuariConsulta.setPassword(responseConsultaUsuari.getPassword());
                        mUsuariConsulta.setNom(responseConsultaUsuari.getNom());
                        mUsuariConsulta.setCognom1(responseConsultaUsuari.getCognom1());
                        mUsuariConsulta.setCognom2(responseConsultaUsuari.getCognom2());
                        mUsuariConsulta.setAccio(responseConsultaUsuari.getAccio());
                        mUsuariConsulta.setActiu(responseConsultaUsuari.getActiu());
                        mUsuariConsulta.setCarrer(responseConsultaUsuari.getCarrer());
                        mUsuariConsulta.setCodiError(responseConsultaUsuari.getCodiError());
                        mUsuariConsulta.setCp(responseConsultaUsuari.getCp());
                        mUsuariConsulta.setDescripcio(responseConsultaUsuari.getDescripcio());
                        mUsuariConsulta.setCodiError(responseConsultaUsuari.getCodiError());
                        mUsuariConsulta.setHorari(responseConsultaUsuari.getHorari());
                        mUsuariConsulta.setPoblacio(responseConsultaUsuari.getPoblacio());
                        mUsuariConsulta.setPoblacio_nom(responseConsultaUsuari.getPoblacio_nom());
                        mUsuariConsulta.setNomAdherit(responseConsultaUsuari.getNomAdherit());
                        mUsuariConsulta.setTipusNom(responseConsultaUsuari.getTipusNom());
                        mUsuariConsulta.setTipusAdherit_nom(responseConsultaUsuari.getTipusAdherit_nom());




                        SharedPreferences sharedPreferences = getSharedPreferences("Usuari_persistent_extes", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String jsonUsuariConsulta = new Gson().toJson(mUsuariConsulta);
                        editor.putString("json", jsonUsuariConsulta);
                        editor.apply();
                        Intent intentCanviContrasenya = new Intent(PerfilAdheritActivity.this, CanviContrasenyaActivity.class);
                        startActivity(intentCanviContrasenya);
                    }
                }
                ;
            }
            @Override
            public void onFailure(Call<ResponseConsultaUsuari> call, Throwable t) {
                Toast.makeText(PerfilAdheritActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                System.out.println("Error: " + t.getMessage());

                Toast.makeText(PerfilAdheritActivity.this, "Error de red", Toast.LENGTH_SHORT).show();
            }
        });
    }



    /**
     * Aquest mètode s'executa quan l'usuari prem el botó de tornar enrere.
     * Finalitza aquesta activitat i torna a la vista anterior.
     *
     * @param view La vista on es va produir el clic.
     */
    public void tornarEnrera(View view) {
        Intent intentPPrincipal = new Intent(this, PPrincipalActivity.class);
        startActivity(intentPPrincipal);
        finish(); // opcional, si quieres que el botón atrás del dispositivo no regrese a la pantalla de perfil.
    }

}
