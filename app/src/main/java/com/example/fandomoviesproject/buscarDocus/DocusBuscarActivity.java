package com.example.fandomoviesproject.buscarDocus;


import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TabHost;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fandomoviesproject.R;
import com.example.fandomoviesproject.buscarPelis.PelisBuscarActivity;
import com.example.fandomoviesproject.buscarSeries.SeriesBuscarActivity;
import com.example.fandomoviesproject.data.DocumentalItem;

import java.util.ArrayList;


public class DocusBuscarActivity extends AppCompatActivity implements DocusBuscarContract.View{

    public static String TAG = DocusBuscarActivity.class.getSimpleName();
    DocusBuscarContract.Presenter presenter;
    private DocusBuscarAdapter mAdapter;

    //TODO ESTO NO IRÍA AQUÍ
    private final ArrayList<DocumentalItem> mDocuList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private Context context = this;
    private TabHost tabHost;
    private ImageButton corazon;
    private ImageButton carrito;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_documentales);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Show the title in the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.buscardocums);
        }

        // Get a handle to RecyclerView
        mRecyclerView = findViewById(R.id.recyclerviewDocus);
        // Create an adapter and supply data to be displayed
        mAdapter= new DocusBuscarAdapter(this, mDocuList);
        // Connect adapter with RecyclerView
        mRecyclerView.setAdapter(mAdapter);
        // Give RecyclerView a default layout manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        tabHost = findViewById(R.id.tabHostBuscar);
        tabHost.setup();
        setUpTabs();
        linkButtonsCorazonAndCarrito();

        //TODO AQUI FALTA PONER UN ONCLICK LISTENER PARA BOTONES

        /*
         if(savedInstanceState == null) {
         CatalogMediator.resetInstance();
         }
        */

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {

            @Override
            public void onTabChanged(String tabId) {

                int currentTab = tabHost.getCurrentTab();

                if (currentTab == 0) {
                    presenter.navigateToBuscarPelisActivity();
                    tabHost.setCurrentTab(2);

                }
                else if (currentTab == 1) {
                    presenter.navigateToBuscarSeriesActivity();
                    tabHost.setCurrentTab(2);
                }

            }
        });

        // do the setup
        DocusBuscarScreen.configure(this);

        // do some work
        //presenter.fetchDocusListData();
        initializeData();  //TODO ESTO HAY QUE QUITARLO CUANDO LA LINEA DE ARRIBA FUNCIONE

    }

    private void linkButtonsCorazonAndCarrito() {
        //TODO Por linkear imagebuttons

    }

    private void setUpTabs() {
        TabHost.TabSpec tabSpec = tabHost.newTabSpec("tab1");
        tabSpec.setContent(R.id.tab1);
        tabSpec.setIndicator("Película");

        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("tab2");
        tabSpec2.setContent(R.id.tab2);
        tabSpec2.setIndicator("Serie");

        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("tab3");
        tabSpec3.setContent(R.id.tab3);
        tabSpec3.setIndicator("Documental");

        tabHost.addTab(tabSpec);
        tabHost.addTab(tabSpec2);
        tabHost.addTab(tabSpec3);

        tabHost.setCurrentTab(2);
    }

    @Override
    public void navigateToBuscarPelisActivity() {
        Intent intent = new Intent(context, PelisBuscarActivity.class);
        startActivity(intent);
    }

    @Override
    public void displayDocusBuscarData(DocusBuscarViewModel viewModel) {
        //TODO pendiente para cuando REPOSITORIO este hecho
    }

    @Override
    public void navigateToBuscarSeriesActivity() {
        Intent intent = new Intent(context, SeriesBuscarActivity.class);
        startActivity(intent);
    }

    @Override
    public void changeCorazonColor() {
        //TODO POR IMPLEMENTAR changeCorazonColor
    }

    @Override
    public void goToPaginaWeb() {
        //TODO POR IMPLEMENTAR goToPaginaWeb
    }


    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        // Inflate the menu: this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.buscar_lupa, menu);

        MenuItem searchItem = menu.findItem(R.id.app_bar_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                if(newText == null || newText.length()== 0) initializeData();
                return false;
            }
        });

        return true;
    }

    // Determines if Action bar item was selected. If true then do corresponding action.
    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        // handle presses on the action bar items
        switch (item.getItemId()) {

            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //TODO Quitar cuando el repositorio este hecho
    private void initializeData() {
        String[] titulosList = getResources()
                .getStringArray(R.array.buscar_docus_Titulos);
        String[] infoDocuList = getResources()
                .getStringArray(R.array.buscar_docus_Informacion);
        TypedArray imageLogo = getResources()
                .obtainTypedArray(R.array.buscar_docus_imageLogo);
        TypedArray imageLike = getResources()
                .obtainTypedArray(R.array.buscar_docus_imageLike);
        TypedArray imageCarro = getResources()
                .obtainTypedArray(R.array.buscar_docus_imageCarro);
        mDocuList.clear(); // Clear data (to avoid duplication)

        for (int i = 0; i < titulosList.length; i++) {
            mDocuList.add(new DocumentalItem(
                    titulosList[i], infoDocuList[i], imageLogo.getResourceId(0, 0),
                    imageLike.getResourceId(0, 0), imageCarro.getResourceId(0, 0))
            );
        }
        //sportsImageResources.recycle(); // Recycle typed array
        this.mAdapter.notifyDataSetChanged(); // Notify adapter of change
    }


    @Override
    public void injectPresenter(DocusBuscarContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onBackPressed()
    {
        finish();
    }

}