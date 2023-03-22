package com.example.residueixappmobil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.residueixappmobil.utils.Eines;
import com.example.residueixappmobil.model.Usuari;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    Eines eina;
    Usuari user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_login);
        this.eina = new Eines();

    }

    public void metodeOlvidatContrasenya(View view) {


    }


    public void validarLogin(View view) {
        Button buttonAceptar = findViewById(R.id.boto_acceptar_login);
        TextView tvUsuari = findViewById(R.id.editTextTextPersonName);
        TextView tvPassword = findViewById(R.id.editTextTextPassword);


        if (eina.validarEmail(tvUsuari.getText().toString())) {

            try {

                URL url = new URL("http://169.254.142.250/residueix/api/login/index.php");
                Map<String, Object> params = new LinkedHashMap<>();

                // Paràmetres
                params.put("usuari", tvUsuari);
                params.put("password", tvPassword);

                // Cridem l'api per recuperar el json
                String jsonO = eina.cridaApi(url, params);

                // Llegim el Json.
                if (!jsonO.equals("")) {
                    JSONObject json = new JSONObject(jsonO);
                    if (json.get("codi_error").toString().equals("0")) {
                        Usuari user = new Usuari(Integer.parseInt(json.get("id").toString()),
                                Integer.parseInt(json.get("tipus").toString()),
                                json.get("email").toString(),
                                json.get("password").toString(), json.get("nom").toString(),
                                json.get("cognom1").toString(),
                                json.get("cognom2").toString(), json.get("telefon").toString(),
                                json.get("token").toString());
                        Toast.makeText(this, "Crida a la API correcta"+ user.getNom(), Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(this, "Error"+ json.get("codi_error") + " " + json.get("error"), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Ha sorgit un error a la API.", Toast.LENGTH_SHORT).show();
                }

            } catch (IOException e) {
                System.out.println("Error excepció:" + e.getMessage());
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }

        } else {
            Toast.makeText(this, "Format d'email incorrecte.", Toast.LENGTH_SHORT).show();
        }


    }
}