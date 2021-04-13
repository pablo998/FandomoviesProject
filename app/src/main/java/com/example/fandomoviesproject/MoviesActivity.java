package com.example.fandomoviesproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
    TextView pelicula;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movies_activity);

        recycler=(RecyclerView) findViewById(R.id.recyclerViewMovies);
        recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        pelicula = findViewById(R.id.elementoTextView);

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

    public void moveToNextLayout(View view) {
        Intent intent = new Intent(this, activity_detalle_pelicula.class);
        startActivity(intent);
    }
}