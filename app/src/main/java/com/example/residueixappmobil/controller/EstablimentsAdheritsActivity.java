package com.example.residueixappmobil.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.residueixappmobil.R;
import com.example.residueixappmobil.model.EstablimentAdherit;

import com.example.residueixappmobil.utils.ApiService;
import com.example.residueixappmobil.utils.ListAdapterEstablimentAdherit;

import com.example.residueixappmobil.utils.ResponseEstablimentAdherit;

import com.example.residueixappmobil.utils.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EstablimentsAdheritsActivity extends AppCompatActivity {

    List<EstablimentAdherit> establimentAdherit;

    /**
     * Mètode que s'executa en crear-se l'activitat.
     * S'encarrega de inicialitzar la llista de residus, obtenir les dades de l'usuari administrador,
     * fer la crida al servei API per obtenir la llista de residus i inicialitzar el RecyclerView.
     *
     * @param savedInstanceState Estat anterior de l'activitat.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_establiments_adherits);

        establimentAdherit = new ArrayList<>();
        init();
    }

    /**
     * Mètode per inicialitzar el RecyclerView i mostrar la llista de residus.
     * Crea una instància del ListAdapter amb la llista de residus i configura el RecyclerView
     * amb el LinearLayoutManager i l'adaptador.
     * Defineix l'esdeveniment de clic per cada element de la llista de residus.
     */
    public void init() {
        ListAdapterEstablimentAdherit listAdapter = new ListAdapterEstablimentAdherit((ArrayList<EstablimentAdherit>) establimentAdherit, this);
        RecyclerView recyclerView = findViewById(R.id.rVEstablimentsAdherits);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);

        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Aquí es podria mostrar el missatge", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        setContentView(R.layout.activity_establiments_adherits);
        SharedPreferences sharedPreferencesAdmin = getSharedPreferences("Usuari_administrador", MODE_PRIVATE);
        ApiService apiService = RetrofitClient.getApiService();
        Call<ResponseEstablimentAdherit> call = apiService.llistatEstablimentsAdherits("6e06ad1160adeafe010cebb9");

        call.enqueue(new Callback<>() {

            @Override
            public void onResponse(Call<ResponseEstablimentAdherit> call, Response<ResponseEstablimentAdherit> response) {
                if (response.isSuccessful()) {
                    ResponseEstablimentAdherit responseEstablimentAdherit = response.body();
                    System.out.println(responseEstablimentAdherit.getCodiError());
                    System.out.println(sharedPreferencesAdmin.getString("token", null));
                    System.out.println(sharedPreferencesAdmin.getString("id", null));
                    System.out.println(sharedPreferencesAdmin.getString("permis", null));

                    if (responseEstablimentAdherit.getCodiError().equals("0")) {
                        System.out.println("Descripcio: " + responseEstablimentAdherit.getCodiError());

                        for (EstablimentAdherit e : responseEstablimentAdherit.getLlistat()) {
                            establimentAdherit.add(new EstablimentAdherit(e.getId_establiment(),e.getNom_establiment(),e.getImatge(),e.getLatitud(),e.getLongitud(),e.getCarrer(),e.getCp(),e.getHorari(),e.getActiu(),e.getId_poblacio(),e.getNom_poblacio(),e.getId_provincia(),e.getNom_provincia(),e.getDescripcio()));
                        }
                        ;
                    }
                    System.out.println(responseEstablimentAdherit.getLlistat());
                }
            }

            @Override
            public void onFailure(Call<ResponseEstablimentAdherit> call, Throwable t) {
                Toast.makeText(EstablimentsAdheritsActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                System.out.println("Error: " + t.getMessage());

                Toast.makeText(EstablimentsAdheritsActivity.this, "Error de red", Toast.LENGTH_SHORT).show();
            }
        });

        super.onResume();
        init();
    }
}