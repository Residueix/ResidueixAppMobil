package com.example.residueixappmobil;
/**
 * Classe que conté totes les instruccions de la pantalla Registre.
 *
 * @author Albert Montes Miracle
 * @version 23/03/2023
 */

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.residueixappmobil.model.Poblacio;
import com.example.residueixappmobil.utils.ResponseTipusAdherit;
import com.example.residueixappmobil.model.TipusAdherit;
import com.example.residueixappmobil.utils.ApiService;
import com.example.residueixappmobil.utils.ResponsePoblacio;
import com.example.residueixappmobil.utils.RetrofitClient;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registre);
        poblacioSpinner = findViewById(R.id.spinnerPoblacio);
        tipusAdheritSpinner = findViewById(R.id.spinnerTipusAdherit);
        cLFormulari = findViewById(R.id.cLFormulari);
        cLFormulariAdicional = findViewById(R.id.cLFormulariAdicional);
        CheckBox cBUsuari = findViewById(R.id.cBUsuari);
        CheckBox cBAdherit = findViewById(R.id.cBAdherit);

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

        ApiService apiService = RetrofitClient.getApiService();
        Call<ResponsePoblacio> call = apiService.llistatPoblacions("6e06ad1160adeafe010cebb9");
        call.enqueue(new Callback<>() {
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
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(RegistreActivity.this, android.R.layout.simple_spinner_item, nombresPoblaciones);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        poblacioSpinner.setAdapter(adapter);

                        ;
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


        ApiService apiService2 = RetrofitClient.getApiService();
        Call<ResponseTipusAdherit> call2 = apiService2.llistatTipusAdherit("6e06ad1160adeafe010cebb9");
        call2.enqueue(new Callback<>() {
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

    public void tornarEnrera(View view) {
        finish();
    }

    public void resgistrar(View view) {


    }
}




