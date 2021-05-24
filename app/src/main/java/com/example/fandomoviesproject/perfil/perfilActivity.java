package com.example.fandomoviesproject.perfil;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.fandomoviesproject.R;
import com.example.fandomoviesproject.ayuda.AyudaActivity;
import com.example.fandomoviesproject.buscarDocus.DocusBuscarActivity;
import com.example.fandomoviesproject.compras.ComprasActivity;
import com.example.fandomoviesproject.data.User;
import com.example.fandomoviesproject.favoritos.FavoritosActivity;
import com.example.fandomoviesproject.menu.MenuActivity;
import com.google.android.material.navigation.NavigationView;

public class perfilActivity
        extends AppCompatActivity implements perfilContract.View, NavigationView.OnNavigationItemSelectedListener{

    public static String TAG = perfilActivity.class.getSimpleName();

    private perfilContract.Presenter presenter;

    Button cerrarSesion;
    private Context context = this;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    TextView nombreYapellidos;
    TextView contraseña;
    TextView emailONumMovil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miperfil);

        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        nombreYapellidos = findViewById(R.id.inputNameApellMiPerfil);
        contraseña = findViewById(R.id.inputPassMiPerfil);
        emailONumMovil = findViewById(R.id.inputEmailNumMovMiPerfil);

        cerrarSesion = findViewById(R.id.botonCerrarSesionMiPerfil);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        navigationView.bringToFront();
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_perfil);

        cerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickCerrarSesion();
            }
        });


        // Show the title in the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.mi_perfil);
        }

    /*
    if(savedInstanceState == null) {
      AppMediator.resetInstance();
    }
    */

        // do the setup
        perfilScreen.configure(this);

        // do some work
        presenter.loadData();
    }




    @Override
    public void injectPresenter(perfilContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void loadDataView(User userActual) {
        this.nombreYapellidos.setText(userActual.getNombreYapellidos());

        this.contraseña.setText(userActual.getContraseña());

        if(userActual.getEmail()==null) {
            Log.e(TAG, "email null, uso numMovil");
            this.emailONumMovil.setText(userActual.getNumMovil());
        }else{
            Log.e(TAG, "email NO, null, uso email");
            this.emailONumMovil.setText(userActual.getEmail());
        }
    }

    @Override
    public void onClickCerrarSesion() {
        new AlertDialog.Builder(context)
                .setTitle(R.string.cerrarsesiontitle)
                .setMessage(R.string.seguroCerrarSesion)

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton(R.string.siCerrarSesion, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Continue with compra operation
                        Intent intent = new Intent(getApplicationContext(),
                                com.example.fandomoviesproject.mainActivity.MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
                })

                // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton(R.string.no, null)
                .show();

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
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_home:
                Intent intent = new Intent(this, MenuActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_perfil:
                Toast toast = Toast.makeText(this, R.string.yaestamiperfil, Toast.LENGTH_SHORT);
                toast.show();
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
