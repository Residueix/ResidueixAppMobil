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

    List<ListElement> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipus_residu);
        SharedPreferences sharedPreferencesAdmin = getSharedPreferences("Usuari_administrador", MODE_PRIVATE);
        ApiService apiService = RetrofitClient.getApiService();
        Call<ResponseLogin> call = apiService.llistatResidus(sharedPreferencesAdmin.getString("id_usuari",null),sharedPreferencesAdmin.getString("token",null), sharedPreferencesAdmin.getString("permis",null));


        call.enqueue(new Callback<>() {

            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                if (response.isSuccessful()) {
                    ResponseLogin responseLogin = response.body();
                    System.out.println(responseLogin.getCodiError());
                    System.out.println(sharedPreferencesAdmin.getString("token",null));
                    System.out.println(sharedPreferencesAdmin.getString("id",null));
                    System.out.println(sharedPreferencesAdmin.getString("permis",null));
                    if (responseLogin.getCodiError().equals("0")) {
                       /* for (String e : responseLogin.getLlistaResidus()) {
                            System.out.println(e[0]);
                            System.out.println(e[1]);
                            System.out.println(e[2]);
                            System.out.println(e[3]);
                            System.out.println(e[4]);
                            System.out.println(e[5]);
                        }
*/
                        System.out.println(responseLogin.getLlistaResidus());
                    }


                }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Toast.makeText(TipusResiduActivity.this, "Error de red", Toast.LENGTH_SHORT).show();
            }
        });


        init();
    }


    public void init() {
        elements = new ArrayList<>();
        elements.add(new ListElement("Plastic", "reciclable al 100%", 345, 1));
        elements.add(new ListElement("Cartro", "reciclable al 23%", 234, 2));
        elements.add(new ListElement("Metall", "reciclable al 234%", 2345, 3));
        elements.add(new ListElement("Organic", "reciclable al 54%", 0545, 4));


        ListAdapter listAdapter = new ListAdapter(elements, this);
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