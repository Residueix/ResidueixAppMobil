package com.example.residueixappmobil;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.residueixappmobil.utils.Eines;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_login);
    }

    public void metodeOlvidatContrasenya(View view) {


    }

    public void validarLogin(View view) {
        Button buttonAceptar = findViewById(R.id.boto_acceptar_login);
        TextView tvUsuari = findViewById(R.id.editTextTextPersonName);

        
        Eines eina = new Eines();
        
        if(eina.validarEmail(tvUsuari.getText().toString())){            
            
            
        }else{
            Toast.makeText(this, "Format d'email incorrecte.", Toast.LENGTH_SHORT).show();  
        }
        
        


    }
}