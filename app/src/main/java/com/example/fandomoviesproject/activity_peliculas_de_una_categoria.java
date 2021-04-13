package com.example.fandomoviesproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class activity_peliculas_de_una_categoria extends AppCompatActivity {

    Button pelicula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peliculas_de_una_categoria);

        pelicula = findViewById(R.id.peliDeUnaCategoria);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Películas");

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.hide();
        }

        pelicula.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goToPeliculaDetail(v);
            }
        });
}


    public void goToPeliculaDetail(View view) {
        Intent intent = new Intent(this,activity_detalle_pelicula.class);
        startActivity(intent);
    }

}
