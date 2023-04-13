package com.example.residueixappmobil.utils;
/**
 * Classe eines que de moment conté un parell de metodes utils
 * @author Albert Montes Miracle
 * @version 23/03/2023
 */
import android.util.Patterns;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.residueixappmobil.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Eines extends AppCompatActivity {


    /**
     * Metode per comprovar que l'introduit al TextView "Usuari" es un mail
     */
    public boolean validarEmail(String email) {
        // Patró
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }


    public String cridaApi(URL url, Map<String, Object> params) throws UnsupportedEncodingException, IOException {
        try {
            StringBuilder postData = new StringBuilder();

            for (Map.Entry<String, Object> param : params.entrySet()) {
                if (postData.length() != 0) {
                    postData.append('&');
                }
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] postBytes = postData.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postBytes);

            // Construim el JSON.
            String json = "";
            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            for (int c = in.read(); c != -1; c = in.read()) {
                json += (char) c;
            }
            System.out.println(json);
            return json;

        } catch (IOException e) {
            System.out.println("Error excepció: " + e.getMessage());
            return "";
        }
    }

    public static JSONObject loginUsuari(String usuari, String password) throws JSONException {

        System.out.println(usuari+password);

        try{
            // Instanciem la classe per enviar formularis x-www-form-urlencoded i configurem els camps
            EnviamentPostUrlEncoded urlencoded = new EnviamentPostUrlEncoded("http://10.2.136.45/residueix/api/login/index.php");
            urlencoded.afegirCamp("usuari", usuari);
            urlencoded.afegirCamp("password", password);

            return urlencoded.resposta();

        } catch (IOException ex){
            return new JSONObject("{\"codi_error\":\"excepcio_api_llistatResidus\",\"error\":\"Error en execució al enviar la petició.\"}");
        }
    }


}
