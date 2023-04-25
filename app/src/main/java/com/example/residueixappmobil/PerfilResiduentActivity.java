package com.example.residueixappmobil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.example.residueixappmobil.model.Usuari;
import com.google.gson.Gson;

public class PerfilResiduentActivity extends AppCompatActivity {

     Usuari mUsuari;

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
    public void tornarEnrera(View view) {
        finish();
    }
}