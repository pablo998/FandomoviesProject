package com.example.fandomoviesproject.perfil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.fandomoviesproject.R;
import com.example.fandomoviesproject.data.User;

public class perfilActivity
        extends AppCompatActivity implements perfilContract.View{

    public static String TAG = perfilActivity.class.getSimpleName();

    private perfilContract.Presenter presenter;

    Button cerrarSesion;

    Toolbar toolbar;
    TextView nombreYapellidos;
    TextView contraseña;
    TextView emailONumMovil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miperfil);

        toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        nombreYapellidos = findViewById(R.id.inputNameApellMiPerfil);
        contraseña = findViewById(R.id.inputPassMiPerfil);
        emailONumMovil = findViewById(R.id.inputEmailNumMovMiPerfil);

        cerrarSesion = findViewById(R.id.botonCerrarSesionMiPerfil);

        cerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
}
