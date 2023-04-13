package com.example.residueixappmobil;
/**
 * Classe que conté totes les instruccions de la pantalla Registre.
 * @author Albert Montes Miracle
 * @version 23/03/2023
 */
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class RegistreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre);
    }
    public void tornarEnrera(View view) {
        finish();
    }
}