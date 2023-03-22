package com.example.residueixappmobil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PPrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pprincipal)
        ;
    }


    public void loginButton(View view) {
        Intent intentPantallaLogin = new Intent(this, PantallaLogin.class);
        intentPantallaLogin.setAction(Intent.ACTION_SEND);
        startActivity(intentPantallaLogin);

    }

    public void registreButton(View view) {
        Intent intentPantallaRegistre = new Intent(this, RegistreActivity.class);
        intentPantallaRegistre.setAction(Intent.ACTION_SEND);
        startActivity(intentPantallaRegistre);
    }
}