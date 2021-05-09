package com.example.fandomoviesproject.seriesDeUnaCategoria;

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

import com.example.fandomoviesproject.R;
import com.example.fandomoviesproject.data.SerieItemCatalog;
import com.example.fandomoviesproject.serieDetail.SerieDetailActivity;
import com.example.fandomoviesproject.seriesDeUnaCategoria.SerieListAdapter;
import com.example.fandomoviesproject.seriesDeUnaCategoria.SerieListContract;
import com.example.fandomoviesproject.seriesDeUnaCategoria.SerieListScreen;
import com.example.fandomoviesproject.seriesDeUnaCategoria.SerieListViewModel;


public class SerieListActivity
        extends AppCompatActivity implements SerieListContract.View {

    public static String TAG = SerieListActivity.class.getSimpleName();

    SerieListContract.Presenter presenter;

    private ListView listView;
    private TextView categoriaElegida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_de_una_categoria);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = findViewById(R.id.categories_serieslist2);
        categoriaElegida = findViewById(R.id.categoriaElegidaText);

        // do the setup
        SerieListScreen.configure(this);

        // do some work
        setCategoriaElegida();
        presenter.fetchSerieListData();


        // Show the title in the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.series);
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
    public void navigateToSerieDetailScreen() {
        Intent intent = new Intent(this, com.example.fandomoviesproject.serieDetail.SerieDetailActivity.class);
        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void displaySerieListData(SerieListViewModel viewModel) {
        Log.e(TAG, "displaySerieListData()");

        // deal with the data
        listView.setAdapter(new SerieListAdapter(
                        this, viewModel.products, new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        SerieItemCatalog item = (SerieItemCatalog) view.getTag();
                        presenter.selectSerieListData(item);
                    }
                })
        );

    }

    // Determines if Action bar item was selected. If true then do corresponding action.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle presses on the action bar items
        switch (item.getItemId()) {

            case R.id.searchTool:
                startActivity(new Intent(this, com.example.fandomoviesproject.buscarSeries.SeriesBuscarActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void injectPresenter(SerieListContract.Presenter presenter) {
        this.presenter = presenter;
    }
}

