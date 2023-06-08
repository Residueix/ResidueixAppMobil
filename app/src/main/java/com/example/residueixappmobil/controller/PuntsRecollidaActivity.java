package com.example.residueixappmobil.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.residueixappmobil.R;
import com.example.residueixappmobil.model.PuntRecollida;
import com.example.residueixappmobil.model.Residu;
import com.example.residueixappmobil.utils.ApiService;
import com.example.residueixappmobil.utils.ListAdapter;
import com.example.residueixappmobil.utils.ListAdapterPuntsRecollida;
import com.example.residueixappmobil.utils.ResponsePuntRecollida;
import com.example.residueixappmobil.utils.ResponseResidus;
import com.example.residueixappmobil.utils.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PuntsRecollidaActivity extends AppCompatActivity {

    List<PuntRecollida> puntRecollida;

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
        setContentView(R.layout.activity_punts_recollida);

        puntRecollida = new ArrayList<>();
        init();
    }

    /**
     * Mètode per inicialitzar el RecyclerView i mostrar la llista de residus.
     * Crea una instància del ListAdapter amb la llista de residus i configura el RecyclerView
     * amb el LinearLayoutManager i l'adaptador.
     * Defineix l'esdeveniment de clic per cada element de la llista de residus.
     */
    public void init() {
        ListAdapterPuntsRecollida listAdapter = new ListAdapterPuntsRecollida((ArrayList<PuntRecollida>) puntRecollida, this);
        RecyclerView recyclerView = findViewById(R.id.rVPuntsRecollida);
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
        setContentView(R.layout.activity_punts_recollida);
        SharedPreferences sharedPreferencesAdmin = getSharedPreferences("Usuari_administrador", MODE_PRIVATE);
        ApiService apiService = RetrofitClient.getApiService();
        Call<ResponsePuntRecollida> call = apiService.llistatPuntsRecollida("6e06ad1160adeafe010cebb9");

        call.enqueue(new Callback<>() {

            @Override
            public void onResponse(Call<ResponsePuntRecollida> call, Response<ResponsePuntRecollida> response) {
                if (response.isSuccessful()) {
                    ResponsePuntRecollida responsePuntRecollida = response.body();
                    System.out.println(responsePuntRecollida.getCodiError());
                    System.out.println(sharedPreferencesAdmin.getString("token", null));
                    System.out.println(sharedPreferencesAdmin.getString("id", null));
                    System.out.println(sharedPreferencesAdmin.getString("permis", null));

                    if (responsePuntRecollida.getCodiError().equals("0")) {
                        System.out.println("Descripcio: " + responsePuntRecollida.getCodiError());

                        for (PuntRecollida e : responsePuntRecollida.getLlistat()) {
                            puntRecollida.add(new PuntRecollida(e.getId_punt(),e.getNom_punt(),e.getImatge(),e.getLatitud(),e.getLongitud(),e.getCarrer(),e.getCp(),e.getHorari(),e.getActiu(),e.getId_poblacio(),e.getNom_poblacio(),e.getId_provincia(),e.getNom_provincia(),e.getDescripcio()));
                        }
                        ;
                    }
                    System.out.println(responsePuntRecollida.getLlistat());
                }
            }

            @Override
            public void onFailure(Call<ResponsePuntRecollida> call, Throwable t) {
                Toast.makeText(PuntsRecollidaActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                System.out.println("Error: " + t.getMessage());

                Toast.makeText(PuntsRecollidaActivity.this, "Error de red", Toast.LENGTH_SHORT).show();
            }
        });

        super.onResume();
        init();
    }


}