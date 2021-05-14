package com.example.fandomoviesproject.docusDeUnaCategoria;

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
import com.example.fandomoviesproject.data.DocuItemCatalog;
import com.example.fandomoviesproject.data.SerieItemCatalog;
import com.example.fandomoviesproject.seriesDeUnaCategoria.SerieListAdapter;
import com.example.fandomoviesproject.seriesDeUnaCategoria.SerieListViewModel;

public class DocuListActivity
        extends AppCompatActivity implements DocuListContract.View {

    public static String TAG = DocuListActivity.class.getSimpleName();

    private DocuListContract.Presenter presenter;

    private ListView listView;
    private TextView categoriaElegida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documentales_de_una_categoria);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = findViewById(R.id.categories_doculist2);
        categoriaElegida = findViewById(R.id.categoriaElegidaText);


        // do the setup
        DocuListScreen.configure(this);

        setCategoriaElegida();
        presenter.fetchDocuListData();

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.series);
        }

    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        // Inflate the menu: this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }

    private void setCategoriaElegida() {
        categoriaElegida.setText("Categoría " + presenter.getIdReceived());

        //TODO descomentar cuando haya repo el metodo de abajo
    /*private void setCategoriaElegidaConRepositorio() {
        categoriaElegida.setText(presenter.getCategoriaElegida());

     */
    }

    @Override
    public void navigateToDocuDetailScreen() {
        Intent intent = new Intent(this, com.example.fandomoviesproject.docuDetail.DocuDetailActivity.class);
        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void displayDocuListData(DocuListViewModel viewModel) {
        Log.e(TAG, "displayDocuListData()");

        // deal with the data
        listView.setAdapter(new DocuListAdapter(
                        this, viewModel.products, new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        DocuItemCatalog item = (DocuItemCatalog) view.getTag();
                        presenter.selectDocuListData(item);
                    }
                })
        );

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle presses on the action bar items
        switch (item.getItemId()) {

            case R.id.searchTool:
                startActivity(new Intent(this, com.example.fandomoviesproject.buscarDocus.DocusBuscarActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public void injectPresenter(DocuListContract.Presenter presenter) {
        this.presenter = presenter;
    }


}
