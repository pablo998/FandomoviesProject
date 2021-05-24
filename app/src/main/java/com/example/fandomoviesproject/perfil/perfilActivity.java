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

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.fandomoviesproject.R;
import com.example.fandomoviesproject.buscarDocus.DocusBuscarActivity;
import com.example.fandomoviesproject.data.User;

public class perfilActivity
        extends AppCompatActivity implements perfilContract.View{

    public static String TAG = perfilActivity.class.getSimpleName();

    private perfilContract.Presenter presenter;

    Button cerrarSesion;
    private Context context = this;
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




}
