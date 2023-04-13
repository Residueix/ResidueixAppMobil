package com.example.residueixappmobil;
/**
 * Classe que conté totes les instruccions de la pantalla principal.
 * @author Albert Montes Miracle
 * @version 23/03/2023
 */
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

    /**
     * En pitjar a l'imatge login ens mostra LoginActivity
     */
    public void loginButton(View view) {
        Intent intentPantallaLogin = new Intent(this, LoginActivity.class);
        intentPantallaLogin.setAction(Intent.ACTION_SEND);
        startActivity(intentPantallaLogin);

    }
    /**
     * En pitjar a l'imatge registre ens mostra RegistreActivity
     */
    public void registreButton(View view) {
        Intent intentPantallaRegistre = new Intent(this, RegistreActivity.class);
        intentPantallaRegistre.setAction(Intent.ACTION_SEND);
        startActivity(intentPantallaRegistre);
    }
    /**
     * En pitjar a l'imatge QuiSom ens mostra QuiSomActivity
     */
    public void quiSomButton(View view) {
        Intent intentPantallaQuiSom = new Intent(this, QuiSomActivity.class);
        intentPantallaQuiSom.setAction(Intent.ACTION_SEND);
        startActivity(intentPantallaQuiSom);
    }
}