package com.example.fandomoviesproject.MoviesList;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import com.example.fandomoviesproject.MoviesList.categoriasViewModel;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.fandomoviesproject.R;


public class activity_peliculas extends AppCompatActivity implements MovieListContract.View {
    ListView lista;

    private static final String TAG = activity_peliculas.class.getSimpleName();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_movies);

         lista = findViewById(R.id.categories_movieslist);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Películas");

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.hide();
        }

    }


    @Override
    public void displayCategoryListData(categoriasViewModel viewModel) {
        Log.e(TAG, "displayCategoryListData()");

        // deal with the data
        lista.setAdapter(new adapter(
                        this, viewModel.products, new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        categoryItem item = (categoryItem) view.getTag();
                    }
                })
        );

    }

}