package com.example.residueixappmobil.utils;

import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.residueixappmobil.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Eines extends AppCompatActivity {


    public void tornar_enrere(View view) {
        Button botoEnrere = findViewById(R.id.boto_enrere);
        botoEnrere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public boolean validarEmail(String email){
        // Patró
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\+]+(\.[_A-Za-z0-9-]+)@" + "[A-Za-z0-9-]+(\.[A-Za-z0-9]+)(\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(email);
        return mather.find();
    }

   
}
