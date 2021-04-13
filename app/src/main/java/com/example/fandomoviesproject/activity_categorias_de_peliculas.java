package com.example.fandomoviesproject;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class activity_categorias_de_peliculas extends AppCompatActivity {
    ListView lista;

    private static final String TAG = activity_categorias_de_peliculas.class.getSimpleName();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias_de_peliculas);

         lista = findViewById(R.id.categories_movieslist);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Películas");

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.hide();
        }

    }

}