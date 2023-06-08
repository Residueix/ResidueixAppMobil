package com.example.residueixappmobil.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.example.residueixappmobil.R;

public class AcceptarCondicionsActivity extends AppCompatActivity {
    private CheckBox checkBox;
    private Button acceptButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceptar_condicions);
        checkBox = findViewById(R.id.checkbox);
        acceptButton = findViewById(R.id.boto_acceptar_login);
        acceptButton.setEnabled(false); // Deshabilita inicialmente el botón

        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            acceptButton.setEnabled(isChecked); // Habilita el botón solo si el checkbox está marcado
        });


    }

    public void registreButtonCondicions(View view) {
        Intent intentPantallaRegistre = new Intent(this, RegistreActivity.class);
        intentPantallaRegistre.setAction(Intent.ACTION_SEND);
        startActivity(intentPantallaRegistre);


    }
    public void tornarEnrera(View view) {
        finish();
    }
}