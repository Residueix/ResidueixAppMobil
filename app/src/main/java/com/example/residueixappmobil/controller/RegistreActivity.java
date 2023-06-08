package com.example.residueixappmobil.controller;

/**
 * Classe que conté totes les instruccions de la pantalla Registre.
 * Aquesta classe és responsable de gestionar el registre d'usuaris a l'aplicació.
 * Proporciona funcionalitats com la validació de dades d'usuari, la interacció amb l'API del servidor per crear nous usuaris i mostrar missatges de confirmació.
 * També gestiona la configuració inicial de la pantalla Registre, com la inicialització dels elements d'interfície i la càrrega de dades des de l'API per a les llistes desplegables.
 * @author Albert Montes Miracle
 */

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.residueixappmobil.R;
import com.example.residueixappmobil.model.Poblacio;
import com.example.residueixappmobil.model.Usuari;
import com.example.residueixappmobil.utils.ResponseAlta;
import com.example.residueixappmobil.utils.ResponseLogin;
import com.example.residueixappmobil.utils.ResponseTipusAdherit;
import com.example.residueixappmobil.model.TipusAdherit;
import com.example.residueixappmobil.utils.ApiService;
import com.example.residueixappmobil.utils.ResponsePoblacio;
import com.example.residueixappmobil.utils.RetrofitClient;
import com.example.residueixappmobil.utils.xifratParaulaClau;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistreActivity extends AppCompatActivity {
    private ConstraintLayout cLFormulari;
    private ConstraintLayout cLFormulariAdicional;
    private Spinner poblacioSpinner;
    private Spinner tipusAdheritSpinner;
    List<Poblacio> poblacions = new ArrayList<>();
    List<TipusAdherit> tipusAdherit = new ArrayList<>();

    private EditText eTnom;
    private EditText eTcognom;
    private EditText eTcognom2;
    private EditText eTCorreu;
    private EditText eTMobil;
    private EditText eTCarrer;
    private EditText eTCodiPostal;
    private EditText eTContrasenya;
    private EditText eTRepetirContrasenya;
    private EditText eTNomAdherit;
    Usuari mUsuari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre);

        // Inicialització dels elements d'interfície
        poblacioSpinner = findViewById(R.id.spinnerPoblacio);
        tipusAdheritSpinner = findViewById(R.id.spinnerTipusAdherit);
        cLFormulari = findViewById(R.id.cLFormulari);
        cLFormulariAdicional = findViewById(R.id.cLFormulariAdicional);
        CheckBox cBUsuari = findViewById(R.id.cBUsuari);
        CheckBox cBAdherit = findViewById(R.id.cBAdherit);
        eTnom = findViewById(R.id.eTNom);
        eTcognom = findViewById(R.id.eTCognom1);
        eTcognom2 = findViewById(R.id.eTCognom2);
        eTCorreu = findViewById(R.id.eTCorreu);
        eTMobil = findViewById(R.id.eTMobil);
        eTCarrer = findViewById(R.id.eTCarrer);
        eTCodiPostal = findViewById(R.id.eTCodiPostal);
        eTContrasenya = findViewById(R.id.eTContrasenya);
        eTRepetirContrasenya = findViewById(R.id.eTRepetirContrasenya);
        eTNomAdherit = findViewById(R.id.eTnom_Adherit);

        // Gestió de l'estat dels CheckBox
        cBUsuari.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
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

        // Càrrega de les dades per als Spinners des de l'API
        ApiService apiService = RetrofitClient.getApiService();

        // Càrrega de la llista de poblacions
        Call<ResponsePoblacio> call = apiService.llistatPoblacions("6e06ad1160adeafe010cebb9");
        call.enqueue(new Callback<ResponsePoblacio>() {
            @Override
            public void onResponse(Call<ResponsePoblacio> call, Response<ResponsePoblacio> response) {
                if (response.isSuccessful()) {
                    ResponsePoblacio responsePoblacio = response.body();

                    if (responsePoblacio.getCodiError().equals("0")) {
                        System.out.println("Fins aqui hem entrat: ");

                        for (Poblacio p : responsePoblacio.getLlistat()) {
                            poblacions.add(new Poblacio(p.getId(), p.getNom(), p.getId_provincia(), p.getNom_provincia()));
                        }

                        List<String> nombresPoblaciones = new ArrayList<>();
                        for (Poblacio p : poblacions) {
                            nombresPoblaciones.add(p.getNom());
                        }
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(RegistreActivity.this, android.R.layout.simple_spinner_item, nombresPoblaciones);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        poblacioSpinner.setAdapter(adapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponsePoblacio> call, Throwable t) {
                Toast.makeText(RegistreActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                System.out.println("Error: " + t.getMessage());
                Toast.makeText(RegistreActivity.this, "Error de red", Toast.LENGTH_SHORT).show();
            }
        });

        // Càrrega de la llista de tipus adherit
        ApiService apiService2 = RetrofitClient.getApiService();
        Call<ResponseTipusAdherit> call2 = apiService2.llistatTipusAdherit("6e06ad1160adeafe010cebb9");
        call2.enqueue(new Callback<ResponseTipusAdherit>() {
            @Override
            public void onResponse(Call<ResponseTipusAdherit> call2, Response<ResponseTipusAdherit> response) {
                if (response.isSuccessful()) {
                    ResponseTipusAdherit responseTipusAdherit = response.body();

                    if (responseTipusAdherit.getCodiError().equals("0")) {
                        System.out.println("Fins aqui hem entrat: ");

                        for (TipusAdherit p : responseTipusAdherit.getLlistat()) {
                            tipusAdherit.add(new TipusAdherit(p.getId(), p.getNom()));
                        }


                        List<String> nombresTipusAdherit = new ArrayList<>();
                        for (TipusAdherit p : tipusAdherit) {
                            nombresTipusAdherit.add(p.getNom());
                        }
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(RegistreActivity.this, android.R.layout.simple_spinner_item, nombresTipusAdherit);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        tipusAdheritSpinner.setAdapter(adapter);

                        ;
                    }
                }
            }


            @Override
            public void onFailure(Call<ResponseTipusAdherit> call, Throwable t) {
                Toast.makeText(RegistreActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                System.out.println("Error: " + t.getMessage());

                Toast.makeText(RegistreActivity.this, "Error de red", Toast.LENGTH_SHORT).show();
            }
        });


    }

    // Mètode per tornar enrere
    public void tornarEnrera(View view) {
        Intent intentPPrincipal = new Intent(this, PPrincipalActivity.class);
        startActivity(intentPPrincipal);
        finish(); // opcional, si quieres que el botón atrás del dispositivo no regrese a la pantalla de perfil.
    }

    // Mètode per gestionar el registre
    public void resgistrar(View view) throws Exception {
        SharedPreferences sharedPreferencesAdmin = getSharedPreferences("Usuari_administrador", MODE_PRIVATE);

        int tipus;
        if (!eTnom.getText().toString().equals("")) {
            if (!eTcognom.getText().toString().equals("")) {
                if (Patterns.EMAIL_ADDRESS.matcher(eTCorreu.getText()).matches()) {
                    if (eTContrasenya.getText().length() >= 8) {
                        if (eTRepetirContrasenya.getText().toString().equals(eTContrasenya.getText().toString())) {
                            if (eTMobil.getText().length() == 9) {
                                if (!eTCarrer.getText().equals("")) {
                                    if (eTCodiPostal.getText().length() == 5) {
                                        ApiService apiService = RetrofitClient.getApiService();
                                        Call<ResponseAlta> call = apiService.crearUsuariResiduent(sharedPreferencesAdmin.getString("id_usuari", null), sharedPreferencesAdmin.getString("token", null), sharedPreferencesAdmin.getString("permis", null), eTnom.getText().toString(), eTcognom.getText().toString(), eTcognom2.getText().toString(), "3", eTCorreu.getText().toString(), xifratParaulaClau.encrypt(eTContrasenya.getText().toString()), eTMobil.getText().toString(), "1", eTCarrer.getText().toString(), "1", eTCodiPostal.getText().toString());
                                        call.enqueue(new Callback<>() {
                                            @Override
                                            public void onResponse(Call<ResponseAlta> call, Response<ResponseAlta> response) {
                                                if (response.isSuccessful()) {
                                                    ResponseAlta responseAlta = response.body();
                                                    String error;
                                                    Toast.makeText(RegistreActivity.this, "usuari creat correctament", Toast.LENGTH_SHORT).show();

                                                    // Nueva actividad
                                                    Intent intent = new Intent(RegistreActivity.this, PPrincipalActivity.class);
                                                    startActivity(intent);
                                                }
                                            }
                                            @Override
                                            public void onFailure(Call<ResponseAlta> call, Throwable t) {
                                                Toast.makeText(RegistreActivity.this, "Error de red", Toast.LENGTH_SHORT).show();
                                            }
                                        });

                                    } else {
                                        Toast.makeText(this, "Introdueix un codi postal.", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(this, "Introdueix un carrer.", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(this, "Introdueix un numero de movil correcte.", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(this, "Les contrasenyes no coincideixen", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "Introdueix un contrasenya valida.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Introdueix un correu valid.", Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(this, "Introdueix un cognom.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Introdueix un nom.", Toast.LENGTH_SHORT).show();
        }
    }
}





