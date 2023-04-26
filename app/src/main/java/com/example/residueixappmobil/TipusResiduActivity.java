package com.example.residueixappmobil;

import static com.example.residueixappmobil.utils.RetrofitClient.getApiService;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.residueixappmobil.model.ListElement;
import com.example.residueixappmobil.model.Residu;
import com.example.residueixappmobil.model.Usuari;
import com.example.residueixappmobil.utils.ApiService;
import com.example.residueixappmobil.utils.ListAdapter;
import com.example.residueixappmobil.utils.ResponseLogin;
import com.example.residueixappmobil.utils.RetrofitClient;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TipusResiduActivity extends AppCompatActivity {

    List<Residu> residus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        residus = new ArrayList<>();


        setContentView(R.layout.activity_tipus_residu);
        SharedPreferences sharedPreferencesAdmin = getSharedPreferences("Usuari_administrador", MODE_PRIVATE);
        ApiService apiService = RetrofitClient.getApiService();
        Call<ResponseLogin> call = apiService.llistatResidus(sharedPreferencesAdmin.getString("id_usuari", null), sharedPreferencesAdmin.getString("token", null), sharedPreferencesAdmin.getString("permis", null));

        call.enqueue(new Callback<>() {

            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                if (response.isSuccessful()) {
                    ResponseLogin responseLogin = response.body();
                    System.out.println(responseLogin.getCodiError());
                    System.out.println(sharedPreferencesAdmin.getString("token", null));
                    System.out.println(sharedPreferencesAdmin.getString("id", null));
                    System.out.println(sharedPreferencesAdmin.getString("permis", null));

                    if (responseLogin.getCodiError().equals("0")) {
                        System.out.println("Descripcio: " + responseLogin.getCodiError());

                        for (Residu e : responseLogin.getLlistat()) {
                            residus.add(new Residu(e.getId_residu(), e.getNom_residu(), e.getImatge_residu(), e.getTipus_residu(), e.getDescripcio_residu(), e.getActiu_residu(), e.getValor_residu(), e.getNom_tipus_residu(), e.getImatge_tipus_residus()));
                        }
                        ;
                    }
                    System.out.println(responseLogin.getLlistat());
                }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Toast.makeText(TipusResiduActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                System.out.println("Error: " + t.getMessage());

                Toast.makeText(TipusResiduActivity.this, "Error de red", Toast.LENGTH_SHORT).show();
            }
        });

        super.onCreate(savedInstanceState);
        init();
    }


    public void init() {
        /*elements = new ArrayList<>();
        elements.add(new ListElement("Plastic", "reciclable al 100%", 345, 1));
        elements.add(new ListElement("Cartro", "reciclable al 23%", 234, 2));
        elements.add(new ListElement("Metall", "reciclable al 234%", 2345, 3));
        elements.add(new ListElement("Organic", "reciclable al 54%", 0545, 4));

*/
        ListAdapter listAdapter = new ListAdapter((ArrayList<Residu>) residus, this);
        RecyclerView recyclerView = findViewById(R.id.rVTipusResidu);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);


        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Aqui es podria mostrar el missatge", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        setContentView(R.layout.activity_tipus_residu);
        SharedPreferences sharedPreferencesAdmin = getSharedPreferences("Usuari_administrador", MODE_PRIVATE);
        ApiService apiService = RetrofitClient.getApiService();
        Call<ResponseLogin> call = apiService.llistatResidus(sharedPreferencesAdmin.getString("id_usuari", null), sharedPreferencesAdmin.getString("token", null), sharedPreferencesAdmin.getString("permis", null));

        call.enqueue(new Callback<>() {

            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                if (response.isSuccessful()) {
                    ResponseLogin responseLogin = response.body();
                    System.out.println(responseLogin.getCodiError());
                    System.out.println(sharedPreferencesAdmin.getString("token", null));
                    System.out.println(sharedPreferencesAdmin.getString("id", null));
                    System.out.println(sharedPreferencesAdmin.getString("permis", null));

                    if (responseLogin.getCodiError().equals("0")) {
                        System.out.println("Descripcio: " + responseLogin.getCodiError());

                        for (Residu e : responseLogin.getLlistat()) {
                            residus.add(new Residu(e.getId_residu(), e.getNom_residu(), e.getImatge_residu(), e.getTipus_residu(), e.getDescripcio_residu(), e.getActiu_residu(), e.getValor_residu(), e.getNom_tipus_residu(), e.getImatge_tipus_residus()));
                        }
                        ;
                    }
                    System.out.println(responseLogin.getLlistat());
                }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Toast.makeText(TipusResiduActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                System.out.println("Error: " + t.getMessage());

                Toast.makeText(TipusResiduActivity.this, "Error de red", Toast.LENGTH_SHORT).show();
            }
        });


        super.onResume();
        init();
    }

    public void mostrarToastCardView(View view) {
        CardView cardView = findViewById(R.id.cVTipusResidus);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Aqui es podria mostrar el missatge", Toast.LENGTH_SHORT).show();
            }
        });
    }


}