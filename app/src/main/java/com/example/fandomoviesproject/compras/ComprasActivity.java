package com.example.fandomoviesproject.compras;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fandomoviesproject.R;
import com.example.fandomoviesproject.ayuda.AyudaActivity;
import com.example.fandomoviesproject.data.ComprasItem;
import com.example.fandomoviesproject.favoritos.FavoritosActivity;
import com.example.fandomoviesproject.menu.MenuActivity;
import com.example.fandomoviesproject.perfil.perfilActivity;
import com.google.android.material.navigation.NavigationView;


import java.util.ArrayList;


public class ComprasActivity extends AppCompatActivity implements ComprasContract.View, NavigationView.OnNavigationItemSelectedListener {

    public static String TAG = ComprasActivity.class.getSimpleName();
    ComprasContract.Presenter presenter;
    private ComprasAdapter mAdapter;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    private final ArrayList<ComprasItem> comprasList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compras);

        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        // Show the title in the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.compras);
        }

        // Get a handle to RecyclerView
        mRecyclerView = findViewById(R.id.recyclerviewCompras);
        // Create an adapter and supply data to be displayed
        mAdapter= new ComprasAdapter(this, comprasList);
        // Connect adapter with RecyclerView
        mRecyclerView.setAdapter(mAdapter);
        // Give RecyclerView a default layout manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        /*
         if(savedInstanceState == null) {
         CatalogMediator.resetInstance();
         }
        */


        // do the setup
        ComprasScreen.configure(this);

        // do some work
        presenter.fetchComprasData();

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        navigationView.bringToFront();
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_cart);

    }



    @Override
    public void displayComprasData(ComprasViewModel viewModel) {
        TypedArray imageCompra = getResources()
                .obtainTypedArray(R.array.carro_compras);

        for (int i = 0; i < viewModel.compras.size(); i++) {
            comprasList.add(new ComprasItem(
                            viewModel.compras.get(i).getTitle(), viewModel.compras.get(i).getInfo(), imageCompra.getResourceId(0, 0)
                    )
            );
        }
        this.mAdapter.notifyDataSetChanged(); // Notify adapter of change
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        // Inflate the menu: this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_borrar, menu);
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
            case R.id.itemBorrar:
                borrarListaDeCompras();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void borrarListaDeCompras() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.eliminarComprasTitle)
                .setMessage(R.string.eliminarCompras)

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton(R.string.siDelete, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Continue with delete operation
                        presenter.borrarListaDeCompras();
                    }
                })

                // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton(R.string.no, null)
                .setIcon(R.drawable.ic_baseline_deleteblack_24)
                .show();
    }


    @Override
    public void injectPresenter(ComprasContract.Presenter presenter) {
        this.presenter = presenter;
    }

//    @Override
//    public void onBackPressed()
//    {
//        finish();
//    }

    @Override
    public void reiniciarPantalla()
    {
        recreate();
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