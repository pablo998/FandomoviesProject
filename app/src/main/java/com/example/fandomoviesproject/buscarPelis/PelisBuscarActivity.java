package com.example.fandomoviesproject.buscarPelis;


import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fandomoviesproject.R;
import com.example.fandomoviesproject.buscarDocus.DocusBuscarActivity;
import com.example.fandomoviesproject.buscarSeries.SeriesBuscarActivity;
import com.example.fandomoviesproject.data.PeliculaItem;

import java.util.ArrayList;


public class PelisBuscarActivity extends AppCompatActivity implements PelisBuscarContract.View{

    public static String TAG = PelisBuscarActivity.class.getSimpleName();
    PelisBuscarContract.Presenter presenter;
    private PelisBuscarAdapter mAdapter;

    //TODO ESTO NO IRÍA AQUÍ
    private final ArrayList<PeliculaItem> mPeliList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private Context context = this;
    private TabHost tabHost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_pelis);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Show the title in the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.buscarpeli);
        }

        // Get a handle to RecyclerView
        mRecyclerView = findViewById(R.id.recyclerviewPelis);
        // Create an adapter and supply data to be displayed
        mAdapter= new PelisBuscarAdapter(this, mPeliList);
        // Connect adapter with RecyclerView
        mRecyclerView.setAdapter(mAdapter);
        // Give RecyclerView a default layout manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        tabHost = findViewById(R.id.tabHostBuscar);
        tabHost.setup();
        setUpTabs();


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

                if (currentTab == 1) {
                    presenter.navigateToBuscarSeriesActivity();
                    tabHost.setCurrentTab(0);

                }
                else if (currentTab == 2) {
                    presenter.navigateToBuscarDocusActivity();
                    tabHost.setCurrentTab(0);
                }

            }
        });

        // do the setup
        PelisBuscarScreen.configure(this);

        // do some work
        //presenter.fetchPelisListData();
        initializeData();  //TODO ESTO HAY QUE QUITARLO CUANDO LA LINEA DE ARRIBA FUNCIONE

    }

    @Override
    public void onClickCorazonButton(TextView titulo, TextView info){
        presenter.CorazonButtonClicked(titulo, info);
    }

    @Override
    public void añadidoConExitoWarning(){
        Toast.makeText(context,R.string.añadidoConExito, Toast.LENGTH_LONG).show();
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

        tabHost.setCurrentTab(0);
    }

    @Override
    public void navigateToBuscarSeriesActivity() {
        Intent intent = new Intent(context, SeriesBuscarActivity.class);
        startActivity(intent);
    }

    @Override
    public void displayPelisBuscarData(PelisBuscarViewModel viewModel) {
        //TODO pendiente para cuando haya repositorio
    }

    @Override
    public void navigateToBuscarDocusActivity() {
        Intent intent = new Intent(context, DocusBuscarActivity.class);
        startActivity(intent);
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
                .getStringArray(R.array.buscar_pelis_Titulos);
        String[] infoPeliList = getResources()
                .getStringArray(R.array.buscar_pelis_Informacion);
        TypedArray imageLogo = getResources()
                .obtainTypedArray(R.array.buscar_pelis_imageLogo);
        TypedArray imageLike = getResources()
                .obtainTypedArray(R.array.buscar_pelis_imageLike);
        TypedArray imageCarro = getResources()
                .obtainTypedArray(R.array.buscar_pelis_imageCarro);
        mPeliList.clear(); // Clear data (to avoid duplication)

        for (int i = 0; i < titulosList.length; i++) {
            mPeliList.add(new PeliculaItem(
                    titulosList[i], infoPeliList[i], imageLogo.getResourceId(0, 0),
                    imageLike.getResourceId(0, 0), imageCarro.getResourceId(0, 0))
            );
        }

        //sportsImageResources.recycle(); // Recycle typed array
        this.mAdapter.notifyDataSetChanged(); // Notify adapter of change
    }


    @Override
    public void injectPresenter(PelisBuscarContract.Presenter presenter) {
        this.presenter = presenter;
    }



    @Override
    protected void onResume(){
        super.onResume();

        //load data
        // presenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();

        // presenter.onPause();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        // presenter.onBackPressed();
    }





    @Override
    protected void onDestroy() {
        super.onDestroy();

        //presenter.onDestroy();
    }

    @Override
    public void onClickCarroButton(TextView titulo, TextView info){
        presenter.CarroButtonClicked(titulo, info);
    }


}