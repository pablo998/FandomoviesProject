package com.example.fandomoviesproject.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.app.NavUtils;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.fandomoviesproject.R;
import com.example.fandomoviesproject.ayuda.AyudaActivity;
import com.example.fandomoviesproject.compras.ComprasActivity;
import com.example.fandomoviesproject.favoritos.FavoritosActivity;
import com.example.fandomoviesproject.perfil.perfilActivity;
import com.google.android.material.navigation.NavigationView;

public class MenuActivity
        extends AppCompatActivity implements MenuContract.View, NavigationView.OnNavigationItemSelectedListener{

    public static String TAG = MenuActivity.class.getSimpleName();

    private MenuContract.Presenter presenter;
    CardView moviesButton, seriesButton, documentaryButton;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        moviesButton = findViewById(R.id.moviesButton);
        seriesButton = findViewById(R.id.seriesButton);
        documentaryButton = findViewById(R.id.documentaryButton);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        navigationView.bringToFront();
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);


        // Show the title in the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.menu);
        }

        moviesButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                presenter.moviesButtonClicked();
            }
        });

        seriesButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                presenter.seriesButtonClicked();
            }
        });

        documentaryButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                presenter.documentaryButtonClicked();
            }
        });


        // if(savedInstanceState == null) {
        //  AppMediator.resetInstance();
        // }


        // do the setup
        MenuScreen.configure(this);

        //if (savedInstanceState == null) {
        //  super.onStart();

        //} else {
        //  presenter.onRestart();
        //}


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
                startActivity(new Intent(this, com.example.fandomoviesproject.buscarPelis.PelisBuscarActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume(){
        super.onResume();

        // load the data
        //presenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();

        //presenter.onPause();
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





    @Override
    protected void onDestroy() {
        super.onDestroy();

        //presenter.onDestroy();
    }



    /*@Override
    public void onDataUpdated(MenuViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }
    */



    @Override
    public void navigateToMoviesScreen() {
        Intent intent = new Intent(this, com.example.fandomoviesproject.categoriasPelis.CategoryListActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToSeriesScreen() {
        Intent intent = new Intent(this, com.example.fandomoviesproject.categoriasSeries.CategorySerieListActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(MenuContract.Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void navigateToDocuScreen() {
        Intent intent = new Intent(this, com.example.fandomoviesproject.categoriasDocu.CategoryDocuListActivity.class);
        startActivity(intent);
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
}
