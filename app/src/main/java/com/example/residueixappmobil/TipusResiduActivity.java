package com.example.residueixappmobil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.residueixappmobil.model.Residu;
import com.example.residueixappmobil.utils.ApiService;
import com.example.residueixappmobil.utils.ListAdapter;
import com.example.residueixappmobil.utils.ResponseLogin;
import com.example.residueixappmobil.utils.ResponseResidus;
import com.example.residueixappmobil.utils.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
/**
 * Classe que conté totes les instruccions de la pantalla de Tipus de Residu.
 *
 * Aquesta classe és responsable de mostrar els diferents tipus de residus en una llista.
 * Utilitza la llibreria Retrofit per comunicar-se amb el servei API i obtenir la llista de residus.
 * Utilitza el RecyclerView i el ListAdapter per mostrar els residus en una llista desplegable.
 * Implementa l'interfície Callback per rebre la resposta del servei API i gestionar-la adequadament.
 * Gestiona els esdeveniments de clic a cada element de la llista de residus.
 * També permet actualitzar la llista de residus en tornar a l'activitat.
 * Utilitza les preferències compartides per obtenir les dades de l'usuari administrador.
 *
 * @author Albert Montes Miracle
 */
public class TipusResiduActivity extends AppCompatActivity {
    List<Residu> residus;

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
        setContentView(R.layout.activity_tipus_residu);

        residus = new ArrayList<>();
        init();
    }

    /**
     * Mètode per inicialitzar el RecyclerView i mostrar la llista de residus.
     * Crea una instància del ListAdapter amb la llista de residus i configura el RecyclerView
     * amb el LinearLayoutManager i l'adaptador.
     * Defineix l'esdeveniment de clic per cada element de la llista de residus.
     */
    public void init() {
        ListAdapter listAdapter = new ListAdapter((ArrayList<Residu>) residus, this);
        RecyclerView recyclerView = findViewById(R.id.rVTipusResidu);
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
        setContentView(R.layout.activity_tipus_residu);
        SharedPreferences sharedPreferencesAdmin = getSharedPreferences("Usuari_administrador", MODE_PRIVATE);
        ApiService apiService = RetrofitClient.getApiService();
        Call<ResponseResidus> call = apiService.llistatResidus(sharedPreferencesAdmin.getString("id_usuari", null), sharedPreferencesAdmin.getString("token", null), sharedPreferencesAdmin.getString("permis", null));

        call.enqueue(new Callback<>() {

            @Override
            public void onResponse(Call<ResponseResidus> call, Response<ResponseResidus> response) {
                if (response.isSuccessful()) {
                    ResponseResidus responseResidus = response.body();
                    System.out.println(responseResidus.getCodiError());
                    System.out.println(sharedPreferencesAdmin.getString("token", null));
                    System.out.println(sharedPreferencesAdmin.getString("id", null));
                    System.out.println(sharedPreferencesAdmin.getString("permis", null));

                    if (responseResidus.getCodiError().equals("0")) {
                        System.out.println("Descripcio: " + responseResidus.getCodiError());

                        for (Residu e : responseResidus.getLlistat()) {
                            residus.add(new Residu(e.getId_residu(), e.getNom_residu(), e.getImatge_residu(), e.getTipus_residu(), e.getDescripcio_residu(), e.getActiu_residu(), e.getValor_residu(), e.getNom_tipus_residu(), e.getImatge_tipus_residus()));
                        }
                        ;
                    }
                    System.out.println(responseResidus.getLlistat());
                }
            }

            @Override
            public void onFailure(Call<ResponseResidus> call, Throwable t) {
                Toast.makeText(TipusResiduActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                System.out.println("Error: " + t.getMessage());

                Toast.makeText(TipusResiduActivity.this, "Error de red", Toast.LENGTH_SHORT).show();
            }
        });

        super.onResume();
        init();
    }


}