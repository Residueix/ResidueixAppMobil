package com.example.residueixappmobil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.residueixappmobil.model.ListElement;
import com.example.residueixappmobil.model.Usuari;
import com.example.residueixappmobil.utils.ListAdapter;

import java.util.ArrayList;
import java.util.List;


public class TipusResiduActivity extends AppCompatActivity {

    List<ListElement> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipus_residu);
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

    public void mostrarToastCardView(View view){
        CardView cardView = findViewById(R.id.cVTipusResidus);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Aqui es podria mostrar el missatge", Toast.LENGTH_SHORT).show();
            }
        });
    }



}