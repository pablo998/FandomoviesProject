package com.example.fandomoviesproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class activity_categorias_de_peliculas extends AppCompatActivity {
    ListView lista;
    Button categoria;


    private static final String TAG = activity_categorias_de_peliculas.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias_de_peliculas);

         lista = findViewById(R.id.categories_movieslist);
         categoria = findViewById(R.id.comprado);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Películas");

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.hide();
        }

        categoria.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goToPeliculasdeEsaCategoria(v);
            }
        });

    }

    public void goToPeliculasdeEsaCategoria(View view) {
        Intent intent = new Intent(this,activity_peliculas_de_una_categoria.class);
        startActivity(intent);
    }

}