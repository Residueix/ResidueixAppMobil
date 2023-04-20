package com.example.residueixappmobil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.residueixappmobil.model.Usuari;

public class PerfilResiduentActivity extends AppCompatActivity {

    private Usuari usuari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_residuent);
        Intent intent = getIntent();
        this.usuari = (Usuari) intent.getSerializableExtra("usuari");
        Toast.makeText(this, "Usuari: " + usuari.getNom(), Toast.LENGTH_SHORT).show();
    }
}