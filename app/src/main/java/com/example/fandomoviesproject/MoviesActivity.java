package com.example.fandomoviesproject;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MoviesActivity extends AppCompatActivity {

    RecyclerView recycler;
    ArrayList<String> listDatos;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movies_activity);

        recycler=(RecyclerView) findViewById(R.id.recyclerViewMovies);
        recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        listDatos = new ArrayList<String>();

        for(int i=0; i<=10; i++){
            listDatos.add("Pelicula  " + i);
        }

        MoviesAdapter adapter = new MoviesAdapter(listDatos);
        recycler.setAdapter(adapter);

        Toolbar toolbar = findViewById(R.id.toolbarmovies);
        toolbar.setTitle(R.string.peliculas);

        text = findViewById(R.id.textCategoriaElegida);
        text.setText(R.string.categoria_elegida);

    }
}