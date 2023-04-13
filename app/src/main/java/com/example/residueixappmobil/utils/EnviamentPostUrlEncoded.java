package com.example.residueixappmobil.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Classe que proporciona una capa d'abstracció per enviar http post amb x-www-form-urlencoded"
 * @author Daniel Garcia Ruiz
 * @version 26/03/2023
 */
public class EnviamentPostUrlEncoded {

    /**
     * Paràmetres a enviar
     */
    Map<String,Object> params;
    /**
     * Url de l'api
     */
    URL url;

    /**
     * Constructor per inicialitzar un nou HTTP POST amb el x-www-form-urlencoded
     * @param urlApi (String) : url de l'api
     * @throws IOException
     */
    public EnviamentPostUrlEncoded(String urlApi) throws IOException {
        // Asignem la url i els paràmetres
        url = new URL(urlApi);
        params = new LinkedHashMap<>();
    }

    /**
     * Mètode per afegir camp per enviar
     * @param nom (String) nom del camp
     * @param valor (String) valor del camp
     */
    public void afegirCamp(String nom, String valor){
        // Afegim el camp als paràmetres
        params.put(nom, valor);
    }

    /**
     * Mètode per obtenir la resposta del servidor quan enviem la petició post
     * @return JSONObject amb la resposta
     */
    public JSONObject resposta() throws JSONException {

        try{
            // Construim el post data
            StringBuilder postData = new StringBuilder();
            // Asignem els paràmetres
            for(Map.Entry<String,Object> param : params.entrySet()){
                if(postData.length() != 0){ postData.append('&'); }
                postData.append(URLEncoder.encode(param.getKey(),"UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()),"UTF-8"));
            }
            // Calculem els bytes
            byte[] postBytes = postData.toString().getBytes("UTF-8");

            // Obrim la connexió amb l'url i assignem configuració
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length",String.valueOf(postBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postBytes);

            // Construim el JSON amb la resposta
            String json = "";
            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
            for(int c = in.read(); c != -1; c = in.read()){ json += (char) c; }

            // Control per veure que ens arriba (comentat quant està en producció)
            System.out.println("Resposta de la api" + json);

            // Retornem el json
            return new JSONObject(json);

        } catch(IOException | JSONException ex){
            // Enviament d'error al json per excepció.
            return new JSONObject("{\"codi_error\":\"excepcio_urlencoded\",\"error\":\""+ex.getMessage()+"\"}");
        }

    }
}