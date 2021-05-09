package com.example.fandomoviesproject.categoriasSeries;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.fandomoviesproject.R;
import com.example.fandomoviesproject.data.CategorySerieItemCatalog;


public class CategorySerieListActivity
        extends AppCompatActivity implements CategorySerieListContract.View {

    public static String TAG = CategorySerieListActivity.class.getSimpleName();

    CategorySerieListContract.Presenter presenter;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias_de_series);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Show the title in the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.series));
        }

        listView = findViewById(R.id.categories_serieslist);

        // do the setup
        CategorySerieListScreen.configure(this);

        // do some work
        presenter.fetchCategoryListData();
    }


    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        // Inflate the menu: this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }


    // Determines if Action bar item was selected. If true then do corresponding action.
    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        // handle presses on the action bar items
        switch (item.getItemId()) {

            case R.id.searchTool:
                startActivity(new Intent(this, com.example.fandomoviesproject.buscarSeries.SeriesBuscarActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void displayCategorySerieListData(CategorySerieListViewModel viewModel) {
        Log.e(TAG, "displayCategoryListData()");

        // deal with the data
        listView.setAdapter(new CategorySerieListAdapter(
                        this, viewModel.products, new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        CategorySerieItemCatalog item = (CategorySerieItemCatalog) view.getTag();
                        presenter.selectCategoryListData(item);
                    }
                })
        );

    }


    @Override
    public void navigateToProductScreen() {
        Intent intent = new Intent(this, com.example.fandomoviesproject.seriesDeUnaCategoria.SerieListActivity.class);
        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }


    @Override
    public void injectPresenter(CategorySerieListContract.Presenter presenter) {
        this.presenter = presenter;
    }
}

