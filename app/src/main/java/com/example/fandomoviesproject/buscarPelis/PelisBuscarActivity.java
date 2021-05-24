package com.example.fandomoviesproject.buscarPelis;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fandomoviesproject.R;
import com.example.fandomoviesproject.buscarDocus.DocusBuscarActivity;
import com.example.fandomoviesproject.buscarSeries.SeriesBuscarActivity;
import com.example.fandomoviesproject.data.PeliculaItemCatalog;

import java.util.ArrayList;


public class PelisBuscarActivity extends AppCompatActivity implements PelisBuscarContract.View{

    public static String TAG = PelisBuscarActivity.class.getSimpleName();
    PelisBuscarContract.Presenter presenter;
    private PelisBuscarAdapter mAdapter;

    private ArrayList<PeliculaItemCatalog> mPeliList = new ArrayList<>();
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
        presenter.fetchPelisBuscarData();
    }

    @Override
    public void goToPaginaWeb(String URLcompra){
        Uri uri = Uri.parse(URLcompra); //missing 'http://' will cause crash
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
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
        Log.e(TAG, "displayPeliculaListData()");

        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                int size = viewModel.products.size();
                Log.e(TAG, "la size es " + size);
                mAdapter.setItems(viewModel.products);
            }
        });

    }


    @Override
    public void navigateToBuscarDocusActivity() {
        Intent intent = new Intent(context, DocusBuscarActivity.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        // Inflate the menu: this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.buscar_lupa, menu);

        MenuItem searchItem = menu.findItem(R.id.app_bar_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                presenter.fetchPelisBuscarData();
                searchView.onActionViewCollapsed();
                return true;
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                if(newText == null || newText.length()== 0) {
                    presenter.fetchPelisBuscarData();
                }

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
    public void onClickCarroButton(TextView titulo, TextView info, String URLcompra){
        presenter.CarroButtonClicked(titulo, info, URLcompra);
    }


}