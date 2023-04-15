package com.example.residueixappmobil;
/**
 * Classe que conté totes les instruccions de la pantalla de Login.
 * @author Albert Montes Miracle
 * @version 23/03/2023
 */
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.residueixappmobil.utils.Eines;
import com.example.residueixappmobil.model.Usuari;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    Eines eina;
    Usuari user;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_login);
        this.eina = new Eines();
        requestQueue = Volley.newRequestQueue(this);

    }

    public void tornarEnrera(View view) {
        finish();
    }

    /**
     * En pitjar a la frase "Ha olvidat la seva contrasenya?"ens mostra RecuperarPassActivity
     */
    public void metodeOlvidatContrasenya(View view) {
        // TODO document why this method is empty
    }

   /* private void validarLogin(View view) {
        TextView tvUsuari = findViewById(R.id.editTextTextPersonName);
        TextView tvPassword = findViewById(R.id.editTextTextPassword);
        String url = "http://10.2.136.45/residueix/api/login/index.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Manejar la respuesta aquí
                        System.out.println(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Manejar el error aquí
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("usuari", tvUsuari.getText().toString());
                params.put("password", tvPassword.getText().toString());
                return params;
            }
        };
        this.requestQueue.add(stringRequest);
    }*/



    /**
     * Metode que fa la petició al servidor per comprovar que l'usuari sigui correcte
     */
    public void validarLogin(View view) throws JSONException {

        TextView tvUsuari = findViewById(R.id.editTextTextPersonName);
        TextView tvPassword = findViewById(R.id.editTextTextPassword);
       // JSONObject login = Eines.loginUsuari(tvUsuari.getText().toString(), tvPassword.getText().toString());


        String url = "http://tu-api.com/endpoint";
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Manejar la respuesta aquí
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Manejar el error aquí
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("parametro1", "valor1");
                params.put("parametro2", "valor2");
                return params;
            }
        };
        queue.add(stringRequest);


    }


}