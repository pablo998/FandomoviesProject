package com.example.fandomoviesproject.docusDeUnaCategoria;

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
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.fandomoviesproject.R;
import com.example.fandomoviesproject.ayuda.AyudaActivity;
import com.example.fandomoviesproject.compras.ComprasActivity;
import com.example.fandomoviesproject.data.DocuItemCatalog;
import com.example.fandomoviesproject.data.SerieItemCatalog;
import com.example.fandomoviesproject.favoritos.FavoritosActivity;
import com.example.fandomoviesproject.menu.MenuActivity;
import com.example.fandomoviesproject.perfil.perfilActivity;
import com.example.fandomoviesproject.seriesDeUnaCategoria.SerieListAdapter;
import com.example.fandomoviesproject.seriesDeUnaCategoria.SerieListViewModel;
import com.google.android.material.navigation.NavigationView;

public class DocuListActivity
        extends AppCompatActivity implements DocuListContract.View, NavigationView.OnNavigationItemSelectedListener {

    public static String TAG = DocuListActivity.class.getSimpleName();

    private DocuListContract.Presenter presenter;

    private ListView listView;
    private TextView categoriaElegida;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documentales_de_una_categoria);

        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        listView = findViewById(R.id.categories_doculist2);
        categoriaElegida = findViewById(R.id.categoriaElegidaText);


        // do the setup
        DocuListScreen.configure(this);

        setCategoriaElegida();
        presenter.fetchDocuListData();

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        navigationView.bringToFront();
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.documentales);
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
