package com.example.fandomoviesproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MoviesCategoryActivity extends AppCompatActivity {

    RecyclerView recycler;
    ArrayList<String> listDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_movies);

        recycler=(RecyclerView) findViewById(R.id.recyclerView);
        recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        listDatos = new ArrayList<String>();

        for(int i=0; i<=10; i++){
            listDatos.add("Category " + i);
        }

        MoviesAdapter adapter = new MoviesAdapter(listDatos);
        recycler.setAdapter(adapter);

        Toolbar toolbar = findViewById(R.id.toolbarcategory);
        toolbar.setTitle(R.string.categoria_pelicula);

    }
}

