package com.example.fandomoviesproject.categoriasDocu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
//import android.widget.Toolbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.fandomoviesproject.R;
import com.example.fandomoviesproject.categoriasSeries.CategorySerieListAdapter;
import com.example.fandomoviesproject.categoriasSeries.CategorySerieListViewModel;
import com.example.fandomoviesproject.data.CategoryDocuItemCatalog;
import com.example.fandomoviesproject.data.CategorySerieItemCatalog;

public class CategoryDocuListActivity
        extends AppCompatActivity implements CategoryDocuListContract.View {

    public static String TAG = CategoryDocuListActivity.class.getSimpleName();

    private CategoryDocuListContract.Presenter presenter;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias_de_documentales);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.documentaries));
        }

        listView = findViewById(R.id.categories_doculist);



        // do the setup
        CategoryDocuListScreen.configure(this);

        presenter.fetchCategoryListData();
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        // Inflate the menu: this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        // handle presses on the action bar items
        switch (item.getItemId()) {

            case R.id.searchTool:
                startActivity(new Intent(this, com.example.fandomoviesproject.buscarDocus.DocusBuscarActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void displayCategoryDocuListData(CategoryDocuListViewModel viewModel) {
        Log.e(TAG, "displayCategoryListData()");

        // deal with the data
        listView.setAdapter(new CategoryDocuListAdapter(this, viewModel.products, new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        CategoryDocuItemCatalog item = (CategoryDocuItemCatalog) view.getTag();
                        presenter.selectCategoryListData(item);
                    }
                })
        );

    }

    @Override
    public void navigateToProductScreen() {
        Intent intent = new Intent(this, com.example.fandomoviesproject.docusDeUnaCategoria.DocuListActivity.class);
        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }




    @Override
    public void injectPresenter(CategoryDocuListContract.Presenter presenter) {
        this.presenter = presenter;
    }




}
