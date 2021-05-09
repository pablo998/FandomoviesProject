package com.example.fandomoviesproject.buscarSeries;


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
import com.example.fandomoviesproject.buscarDocus.DocusBuscarActivity;
import com.example.fandomoviesproject.buscarPelis.PelisBuscarActivity;
import com.example.fandomoviesproject.data.SerieItem;

import java.util.ArrayList;


public class SeriesBuscarActivity extends AppCompatActivity implements SeriesBuscarContract.View{

    public static String TAG = SeriesBuscarActivity.class.getSimpleName();
    SeriesBuscarContract.Presenter presenter;
    private SeriesBuscarAdapter mAdapter;

    //TODO ESTO NO IRÍA AQUÍ
    private final ArrayList<SerieItem> mSerieList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private Context context = this;
    private TabHost tabHost;
    private ImageButton corazon;
    private ImageButton carrito;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_series);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Show the title in the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.buscarserie);
        }

        // Get a handle to RecyclerView
        mRecyclerView = findViewById(R.id.recyclerviewSeries);
        // Create an adapter and supply data to be displayed
        mAdapter= new SeriesBuscarAdapter(this, mSerieList);
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
                    tabHost.setCurrentTab(1);

                }
                else if (currentTab == 2) {
                    presenter.navigateToBuscarDocusActivity();
                    tabHost.setCurrentTab(1);
                }

            }
        });

        // do the setup
        SeriesBuscarScreen.configure(this);

        // do some work
        //presenter.fetchSeriesListData();
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

        tabHost.setCurrentTab(1);
    }

    @Override
    public void navigateToBuscarPelisActivity() {
        Intent intent = new Intent(context, PelisBuscarActivity.class);
        startActivity(intent);
    }

    @Override
    public void displaySeriesBuscarData(SeriesBuscarViewModel viewModel) {
        //TODO pendiente para cuando REPOSITORIO este hecho
    }

    @Override
    public void navigateToBuscarDocusActivity() {
        Intent intent = new Intent(context, DocusBuscarActivity.class);
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
        getMenuInflater().inflate(R.menu.menu_search, menu);

        MenuItem searchItem = menu.findItem(R.id.searchTool);
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

    //TODO Quitar cuando el repositorio este hecho
    private void initializeData() {
        String[] titulosList = getResources()
                .getStringArray(R.array.buscar_series_Titulos);
        String[] infoSerieList = getResources()
                .getStringArray(R.array.buscar_series_Informacion);
        TypedArray imageLogo = getResources()
                .obtainTypedArray(R.array.buscar_series_imageLogo);
        TypedArray imageLike = getResources()
                .obtainTypedArray(R.array.buscar_series_imageLike);
        TypedArray imageCarro = getResources()
                .obtainTypedArray(R.array.buscar_series_imageCarro);
            mSerieList.clear(); // Clear data (to avoid duplication)

        for (int i = 0; i < titulosList.length; i++) {
            mSerieList.add(new SerieItem(
                    titulosList[i], infoSerieList[i], imageLogo.getResourceId(0, 0),
                    imageLike.getResourceId(0, 0), imageCarro.getResourceId(0, 0))
            );
        }
        //sportsImageResources.recycle(); // Recycle typed array
        this.mAdapter.notifyDataSetChanged(); // Notify adapter of change
    }


    @Override
    public void injectPresenter(SeriesBuscarContract.Presenter presenter) {
        this.presenter = presenter;
    }

}