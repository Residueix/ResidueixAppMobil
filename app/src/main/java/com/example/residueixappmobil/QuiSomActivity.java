package com.example.residueixappmobil;
/**
 * Classe que conté totes les instruccions de la pantalla Qui som.
 *
 * @author Albert Montes Miracle
 * @version 23/03/2023
 */

import androidx.appcompat.app.AppCompatActivity;
import com.example.residueixappmobil.model.Usuari;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class QuiSomActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qui_som);
    }
    public void tornarEnrera(View view) {
        finish();
    }
}
