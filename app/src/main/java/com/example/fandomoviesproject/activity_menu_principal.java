package com.example.fandomoviesproject;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class activity_menu_principal extends AppCompatActivity {

    Button peliculas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        peliculas = findViewById(R.id.moviesButton);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Menú");

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.hide();
        }

        peliculas.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goToPeliculasCategorias(v);
            }
        });

    }

    public void goToPeliculasCategorias(View view) {
        Intent intent = new Intent(this,activity_categorias_de_peliculas.class);
        startActivity(intent);
    }
}
