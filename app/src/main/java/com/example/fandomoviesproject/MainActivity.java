package com.example.fandomoviesproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button iniciarSesion, iniciaSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarSesion = findViewById(R.id.botonIniciarSesion);
        iniciaSesion = findViewById(R.id.botonIniciaSesion);

        iniciarSesion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                iniciarSesion(v);
            }
        });

    }

    public void iniciarSesion(View view) {
        Intent intent = new Intent(this,com.example.fandomoviesproject.registrarse.RegistrarseActivity.class);
        startActivity(intent);
    }

    public void IniciaSesion(View view) {
        Intent intent = new Intent(this,com.example.fandomoviesproject.registrarse.RegistrarseActivity.class);
        startActivity(intent);
    }
}