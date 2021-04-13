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

public class MoviesCategoryActivity extends AppCompatActivity {


    //Cambios pequeños
    RecyclerView recycler;
    ArrayList<String> listDatos;
    TextView categoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_movies);

        recycler=(RecyclerView) findViewById(R.id.recyclerView);
        recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        categoria = findViewById(R.id.elementoTextView);

        listDatos = new ArrayList<String>();

        for(int i=0; i<=10; i++){
            listDatos.add("Categoria " + i);
        }

        MoviesAdapter adapter = new MoviesAdapter(listDatos);
        recycler.setAdapter(adapter);

        Toolbar toolbar = findViewById(R.id.toolbarcategory);
        toolbar.setTitle(R.string.movies);

    }



    public void moveToNextLayout(View view) {
        Intent intent = new Intent(this, MoviesActivity.class);
        startActivity(intent);
    }
}

