package com.example.residueixappmobil;
/**
 * Classe que conté totes les instruccions de la pantalla de Login.
 *
 * @author Albert Montes Miracle
 * @version 23/03/2023
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.residueixappmobil.model.Usuari;
import com.example.residueixappmobil.utils.ApiService;
import com.example.residueixappmobil.utils.RetrofitClient;
import com.example.residueixappmobil.utils.TokenResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {

    private EditText tvUsuari;
    private EditText tvPassword;
    private Usuari usuari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_login);
        tvUsuari = findViewById(R.id.editTextTextPersonName);
        tvPassword = findViewById(R.id.editTextTextPassword);
        Intent intent = getIntent();
        this.usuari = (Usuari) intent.getSerializableExtra("usuari");

        Button loginButton = findViewById(R.id.boto_acceptar_login);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarLogin();
            }
        });
    }

    private void validarLogin() {
        String usuari = tvUsuari.getText().toString();
        String password = tvPassword.getText().toString();



        ApiService apiService = RetrofitClient.getApiService();
        Call<TokenResponse> call = apiService.login(usuari, password);
        call.enqueue(new Callback<TokenResponse>() {

            @Override
            public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
                if (response.isSuccessful()) {
                    TokenResponse tokenResponse = response.body();
                    String token = tokenResponse.getToken();
                    String email = tokenResponse.getEmail();
                    String tipus = tokenResponse.getTipus();
                    String nom = tokenResponse.getNom();
                    String cognom1 = tokenResponse.getCognom1();
                    String cognom2 = tokenResponse.getCognom2();
                    String password = tokenResponse.getPassword();
                    String actiu = tokenResponse.getActiu();
                    String error = tokenResponse.getError();
                    String cError = tokenResponse.getCodiError();
                    String id = tokenResponse.getId();



                    //Toast.makeText(LoginActivity.this, "Codi error : " + cError + "Tipus: " + tipus,
                       //      Toast.LENGTH_SHORT).show();


                    if (cError.equals("0")) {

                            generarUsuari(id, nom, tipus);

                        if (tipus.equals("2")) {
                            Intent intent = new Intent(LoginActivity.this, QuiSomActivity.class);
                            intent.putExtra("usuari", usuari);
                            startActivity(intent);

                        } else if (tipus.equals("1")) {
                            Toast.makeText(LoginActivity.this, "Es tipus:" + tipus, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, PerfilAdheritActivity.class);
                            startActivity(intent);
                        }


                    } else {
                        Toast.makeText(LoginActivity.this, "Error: " + error, Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Error de red", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void generarUsuari(String id, String nom, String tipus){
        Toast.makeText(LoginActivity.this, "Id: "+ id , Toast.LENGTH_SHORT).show();
        this.usuari.setId(Integer.parseInt(id));
        this.usuari.setNom(nom);
        this.usuari.setTipus(Integer.parseInt(tipus));
    };
    public void tornarEnrera(View view) {
        finish();
        Intent intentPantallaPrincipal = new Intent(this, PPrincipalActivity.class);
        intentPantallaPrincipal.putExtra("usuari", usuari);
        intentPantallaPrincipal.setAction(Intent.ACTION_SEND);
        startActivity(intentPantallaPrincipal);
    }
}





