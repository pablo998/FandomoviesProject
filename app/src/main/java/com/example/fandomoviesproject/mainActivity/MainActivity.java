package com.example.fandomoviesproject.mainActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.fandomoviesproject.R;
import com.example.fandomoviesproject.registrarse.RegistrarseContract;
import com.example.fandomoviesproject.registrarse.RegistrarseScreen;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    MainActivityContract.Presenter presenter;

    TextInputEditText numMoviloEmailTyped;
    TextInputEditText contraseña;
    Button iniciarSesion, botonRegistrate;

    private Context context = this;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarSesion = findViewById(R.id.botonIniciarSesion);
        botonRegistrate = findViewById(R.id.botonRegistrate);

        iniciarSesion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                presenter.onIniciarSesionButtonClick(numMoviloEmailTyped,contraseña);
            }
        });

        botonRegistrate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                presenter.onRegistrateButtonClick();
            }
        });


        //do the setup
        MainActivityScreen.configure(this);
    }

    public void navigateToMenuActivity() {
        Intent intent = new Intent(this,com.example.fandomoviesproject.menu.MenuActivity.class);
        startActivity(intent);
    }

    public void navigateToRegistrarseActivity() {
        Intent intent = new Intent(this,com.example.fandomoviesproject.registrarse.RegistrarseActivity.class);
        startActivity(intent);
    }

    @Override
    public void credencialesIncorrectas() {
        new AlertDialog.Builder(context)
                .setTitle(R.string.credencialesIncorrectasTitle)
                .setMessage(R.string.credencialesIncorrectas)

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton(R.string.siFav, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Continue with operation
                    }
                })

                // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton(R.string.no, null)
                .show();
    }

    @Override
    public void injectPresenter(MainActivityContract.Presenter presenter) {
        this.presenter = presenter;
    }
}