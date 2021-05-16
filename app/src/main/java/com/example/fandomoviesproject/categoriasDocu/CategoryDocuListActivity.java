package com.example.fandomoviesproject.categoriasDocu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

//import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.fandomoviesproject.R;
import com.example.fandomoviesproject.ayuda.AyudaActivity;
import com.example.fandomoviesproject.compras.ComprasActivity;
import com.example.fandomoviesproject.data.CategoryDocuItemCatalog;
import com.example.fandomoviesproject.favoritos.FavoritosActivity;
import com.example.fandomoviesproject.menu.MenuActivity;
import com.example.fandomoviesproject.perfil.perfilActivity;
import com.google.android.material.navigation.NavigationView;


public class CategoryDocuListActivity
        extends AppCompatActivity implements CategoryDocuListContract.View, NavigationView.OnNavigationItemSelectedListener {

    public static String TAG = CategoryDocuListActivity.class.getSimpleName();

    CategoryDocuListContract.Presenter presenter;

    private ListView listView;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias_de_documentales);

        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.documentaries));
        }

        listView = findViewById(R.id.categories_doculist);



        // do the setup
        CategoryDocuListScreen.configure(this);

        presenter.fetchCategoryListData();

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        navigationView.bringToFront();
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

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
