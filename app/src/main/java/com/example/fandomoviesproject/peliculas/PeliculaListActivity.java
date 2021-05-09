package com.example.fandomoviesproject.peliculas;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

import com.example.fandomoviesproject.R;
import com.example.fandomoviesproject.data.PeliculaItem;
import com.example.fandomoviesproject.pelicula.PeliculaDetailActivity;


public class PeliculaListActivity
        extends AppCompatActivity implements PeliculaListContract.View {

    public static String TAG = PeliculaListActivity.class.getSimpleName();

    PeliculaListContract.Presenter presenter;

    private ListView listView;
    private TextView categoriaElegida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peliculas_de_una_categoria);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = findViewById(R.id.categories_movieslist2);
        categoriaElegida = findViewById(R.id.categoriaElegidaText);

        // do the setup
        PeliculaListScreen.configure(this);

        // do some work
        setCategoriaElegida();
        presenter.fetchPeliculaListData();


        // Show the title in the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.peliculas);
        }


    /*
    if(savedInstanceState == null) {
      CatalogMediator.resetInstance();
    }
    */

    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        // Inflate the menu: this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }

    private void setCategoriaElegida() {
        categoriaElegida.setText("Categoría " + presenter.getIdReceived());
    }

    //TODO descomentar cuando haya repo el metodo de abajo
    /*private void setCategoriaElegidaConRepositorio() {
        categoriaElegida.setText(presenter.getCategoriaElegida());
    }

     */


    @Override
    public void navigateToPeliculaDetailScreen() {
        Intent intent = new Intent(this, PeliculaDetailActivity.class);
        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void displayPeliculaListData(PeliculaListViewModel viewModel) {
        Log.e(TAG, "displayPeliculaListData()");

        // deal with the data
        listView.setAdapter(new PeliculaListAdapter(
                        this, viewModel.products, new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        PeliculaItem item = (PeliculaItem) view.getTag();
                        presenter.selectPeliculaListData(item);
                    }
                })
        );

    }

    // Determines if Action bar item was selected. If true then do corresponding action.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle presses on the action bar items
        switch (item.getItemId()) {

            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;

            case R.id.searchTool:
                startActivity(new Intent(this, com.example.fandomoviesproject.pelicula.PeliculaDetailActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void injectPresenter(PeliculaListContract.Presenter presenter) {
        this.presenter = presenter;
    }
}

