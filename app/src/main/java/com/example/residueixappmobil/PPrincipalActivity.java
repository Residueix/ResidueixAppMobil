package com.example.residueixappmobil;
/**
 * Classe que conté totes les instruccions de la pantalla principal.
 *
 * @author Albert Montes Miracle
 * @version 23/03/2023
 */

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.residueixappmobil.model.Usuari;
import com.example.residueixappmobil.utils.TokenResponse;

public class PPrincipalActivity extends AppCompatActivity {
    Usuari usuari;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pprincipal);

        Intent intent = getIntent();
        this.usuari = (Usuari) intent.getSerializableExtra("usuari");

        if (this.usuari != null) {
            Toast.makeText(PPrincipalActivity.this, "Es tipus:" + usuari.getId(), Toast.LENGTH_SHORT).show();

        }else{
            usuari = new Usuari();
            Toast.makeText(PPrincipalActivity.this, "Es tipus:" + usuari.getId(), Toast.LENGTH_SHORT).show();
        }


    }


    /**
     * En pitjar a l'imatge login ens mostra LoginActivity
     */
    public void loginButton(View view) {
        finish();
        Intent intentPantallaLogin = new Intent(this, LoginActivity.class);
        intentPantallaLogin.putExtra("usuari", usuari);
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

    public void residusButton(View view) {
        Intent intentPantallaResidus = new Intent(this, ResidusActivity.class);
        intentPantallaResidus.setAction(Intent.ACTION_SEND);
        startActivity(intentPantallaResidus);
    }

    public void tipusResidusButton(View view) {
        Intent intentPantallaTipusResidus = new Intent(this, TipusResiduActivity.class);
        intentPantallaTipusResidus.setAction(Intent.ACTION_SEND);
        startActivity(intentPantallaTipusResidus);
    }


}