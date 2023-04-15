package com.example.residueixappmobil;
/**
 * Classe que conté totes les instruccions de la pantalla Registre.
 *
 * @author Albert Montes Miracle
 * @version 23/03/2023
 */

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class RegistreActivity extends AppCompatActivity {
    private ConstraintLayout cLFormulari;
    private ConstraintLayout cLFormulariAdicional;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre);

        cLFormulari = findViewById(R.id.cLFormulari);
        cLFormulariAdicional = findViewById(R.id.cLFormulariAdicional);

        CheckBox cBUsuari = findViewById(R.id.cBUsuari);
        CheckBox cBAdherit = findViewById(R.id.cBAdherit);

       cBUsuari.setOnCheckedChangeListener((buttonView, isChecked) -> {
         if(isChecked){
             cBAdherit.setChecked(false);
         }

       });
        cBAdherit.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                cBUsuari.setChecked(false);
                cLFormulari.setVisibility(View.VISIBLE);
                cLFormulariAdicional.setVisibility(View.VISIBLE);
            } else {
                cLFormulariAdicional.setVisibility(View.GONE);
            }
        });

    }
}




