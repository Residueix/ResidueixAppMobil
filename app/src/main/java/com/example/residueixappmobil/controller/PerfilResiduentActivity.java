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
import com.google.gson.Gson;
/**
 * Aquesta classe representa l'activitat que mostra el perfil de l'usuari.
 * Obté les dades de l'usuari i les mostra en la vista.
 * @author Albert Montes Miracle
 */
public class PerfilResiduentActivity extends AppCompatActivity {
    // Aquesta variable manté una instància de l'usuari actual.
    Usuari mUsuari;

    /**
     * Aquest mètode s'executa quan es crea l'activitat.
     * Carrega les preferències de l'usuari, obté les dades de l'usuari i les mostra en la vista.
     *
     * @param savedInstanceState Conté l'estat de l'aplicació per a que pugui ser restaurada si es requereix.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_residuent);
        SharedPreferences sharedPreferences = getSharedPreferences("Usuari_persistent", MODE_PRIVATE);
        String jsonUsuari = sharedPreferences.getString("json", null);
        if (jsonUsuari != null) {
            mUsuari = new Gson().fromJson(jsonUsuari, Usuari.class);
        }
        TextView textViewNom = findViewById(R.id.textViewNom);
        textViewNom.setText("Nom: " + mUsuari.getNom());

        TextView textViewCognoms = findViewById(R.id.textViewCognoms);
        textViewCognoms.setText("Cognoms: " + mUsuari.getCognom1() + " ," + mUsuari.getCognom2());

        TextView textViewCorreu = findViewById(R.id.textViewCorreu);
        textViewCorreu.setText("Correu: " + mUsuari.getEmail());

        TextView textViewTelefon = findViewById(R.id.textViewTelefon);
        textViewTelefon.setText("Telefon: " + mUsuari.getTelefon());


    }
    /**
     * Aquest mètode s'executa quan l'usuari prem el botó de tornar enrere.
     * Finalitza aquesta activitat i torna a la vista anterior.
     *
     * @param view La vista on es va produir el clic.
     */
    public void tornarEnrera(View view) {
        finish();
    }
}