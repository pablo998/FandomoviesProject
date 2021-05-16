package com.example.fandomoviesproject.favoritos;


import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

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
import com.example.fandomoviesproject.buscarPelis.PelisBuscarActivity;
import com.example.fandomoviesproject.compras.ComprasActivity;
import com.example.fandomoviesproject.data.PeliculaItem;
import com.example.fandomoviesproject.favoritos.FavoritosAdapter;
import com.example.fandomoviesproject.favoritos.FavoritosContract;
import com.example.fandomoviesproject.favoritos.FavoritosScreen;
import com.example.fandomoviesproject.favoritos.FavoritosViewModel;
import com.example.fandomoviesproject.data.FavoritoItem;
import com.example.fandomoviesproject.menu.MenuActivity;
import com.example.fandomoviesproject.perfil.perfilActivity;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;


public class FavoritosActivity extends AppCompatActivity implements FavoritosContract.View, NavigationView.OnNavigationItemSelectedListener {

    public static String TAG = FavoritosActivity.class.getSimpleName();
    FavoritosContract.Presenter presenter;
    private FavoritosAdapter mAdapter;

    //TODO ESTO NO IRÍA AQUÍ
    private final ArrayList<FavoritoItem> favoritosList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private Context context = this;
    private ImageButton delete;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        // Show the title in the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.favoritos);
        }

        // Get a handle to RecyclerView
        mRecyclerView = findViewById(R.id.recyclerviewFavs);
        // Create an adapter and supply data to be displayed
        mAdapter= new FavoritosAdapter(this, favoritosList);
        // Connect adapter with RecyclerView
        mRecyclerView.setAdapter(mAdapter);
        // Give RecyclerView a default layout manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //linkButtonsDetele();

        //TODO AQUI FALTA PONER UN ONCLICK LISTENER PARA BOTONES

        /*
         if(savedInstanceState == null) {
         CatalogMediator.resetInstance();
         }
        */


        // do the setup
        FavoritosScreen.configure(this);

        // do some work
        presenter.fetchFavoritosData();

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        navigationView.bringToFront();
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_fav);
    }

    private void linkButtonDelete() {
        //TODO Por linkear imagebuttons

    }

    public void todaviaNoHayFavoritos(){
        Toast.makeText(context,R.string.nohayFavs, Toast.LENGTH_LONG).show();
    }


    @Override
    public void displayFavoritosData(FavoritosViewModel viewModel) {

        TypedArray imageCorazon = getResources()
                .obtainTypedArray(R.array.corazon_favs);
        TypedArray imageDelete = getResources()
                .obtainTypedArray(R.array.delete_favs);

        for (int i = 0; i < viewModel.favoritos.size(); i++) {
            favoritosList.add(new FavoritoItem(
                    viewModel.favoritos.get(i).getTitle(), viewModel.favoritos.get(i).getInfo(), imageCorazon.getResourceId(0, 0),
                    imageDelete.getResourceId(0, 0))
            );
        }
        this.mAdapter.notifyDataSetChanged(); // Notify adapter of change
    }

    @Override
    public void reiniciarPantalla() {
        recreate();
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
    public void injectPresenter(FavoritosContract.Presenter presenter) {
        this.presenter = presenter;
    }

//    @Override
//    public void onBackPressed()
//    {
//        finish();
//    }

    @Override
    public void onClickDeleteButton(TextView mTitleText, TextView mInfoText) {
        Log.e(TAG,"onClickDeleteButton" );
        presenter.onClickDeleteButton(mTitleText,mInfoText);
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