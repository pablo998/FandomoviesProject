package com.example.fandomoviesproject.peliculasDeUnaCategoria;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fandomoviesproject.R;
import com.example.fandomoviesproject.ayuda.AyudaActivity;
import com.example.fandomoviesproject.compras.ComprasActivity;
import com.example.fandomoviesproject.data.CategoryItemCatalog;
import com.example.fandomoviesproject.data.CategorySerieItemCatalog;
import com.example.fandomoviesproject.data.PeliculaItemCatalog;
import com.example.fandomoviesproject.data.SerieItemCatalog;
import com.example.fandomoviesproject.favoritos.FavoritosActivity;
import com.example.fandomoviesproject.menu.MenuActivity;
import com.example.fandomoviesproject.peliculaDetail.PeliculaDetailActivity;
import com.example.fandomoviesproject.perfil.perfilActivity;
import com.example.fandomoviesproject.seriesDeUnaCategoria.SerieListAdapter;
import com.google.android.material.navigation.NavigationView;


public class PeliculaListActivity
        extends AppCompatActivity implements PeliculaListContract.View, NavigationView.OnNavigationItemSelectedListener {

    public static String TAG = PeliculaListActivity.class.getSimpleName();

    PeliculaListContract.Presenter presenter;

    private TextView categoriaElegida;
    private PeliculaListAdapter listAdapter;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peliculas_de_una_categoria);

        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        categoriaElegida = findViewById(R.id.categoriaElegidaText);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        navigationView.bringToFront();
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();

        navigationView.setNavigationItemSelectedListener(this);


        // Show the title in the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.peliculas);
        }

        RecyclerView recyclerView = findViewById(R.id.categories_movieslist2);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        listAdapter = new PeliculaListAdapter( new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                PeliculaItemCatalog item = (PeliculaItemCatalog) view.getTag();
                presenter.selectPeliculaListData(item);
            }
        });
        recyclerView.setAdapter(listAdapter);


    /*
    if(savedInstanceState == null) {
      CatalogMediator.resetInstance();
    }
    */

        // do the setup
        PeliculaListScreen.configure(this);

        // do some work
        presenter.fetchPeliculaListData();

    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        // Inflate the menu: this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }



    @Override
    public void navigateToPeliculaDetailScreen() {
        Intent intent = new Intent(this, PeliculaDetailActivity.class);
        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void displayPeliculaListData(PeliculaListViewModel viewModel) {
        Log.e(TAG, "displayPeliculaListData()");

        runOnUiThread(new Runnable() {

            @Override
            public void run() {

                // deal with the data
                CategoryItemCatalog category = viewModel.category;
                categoriaElegida.setText(category.content);


                listAdapter.setItems(viewModel.products);
            }
        });

    }

    // Determines if Action bar item was selected. If true then do corresponding action.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle presses on the action bar items
        switch (item.getItemId()) {

            case R.id.searchTool:
                startActivity(new Intent(this, com.example.fandomoviesproject.buscarPelis.PelisBuscarActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void injectPresenter(PeliculaListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_home:
                Intent intent = new Intent(this, MenuActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_perfil:
                Intent intent2 = new Intent(this, perfilActivity.class);
                startActivity(intent2);
                break;
            case R.id.nav_fav:
                Intent intent3 = new Intent(this, FavoritosActivity.class);
                startActivity(intent3);
                break;
            case R.id.nav_cart:
                Intent intent4 = new Intent(this, ComprasActivity.class);
                startActivity(intent4);
                break;
            case R.id.nav_help:
                Intent intent5 = new Intent(this, AyudaActivity.class);
                startActivity(intent5);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }

        //presenter.onBackPressed();
    }
}

