package com.example.fandomoviesproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabItem;


public class activity_registrarte_numerodemoviltab extends AppCompatActivity {


    Button registrarme, tengoCuenta;
    TabItem emailTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarte_numerodemoviltab);
        registrarme = findViewById(R.id.botonRegistrarme);
        tengoCuenta = findViewById(R.id.botonIniciaSesion);
        emailTab = findViewById(R.id.tabEmail);

        registrarme.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goToMenu(v);
            }
        });

    }

    public void goToEmailTab(View view) {
        Intent intent = new Intent(this,activity_registrarte_emailtab.class);
        startActivity(intent);
    }

    public void goToMenu(View view) {
        Intent intent = new Intent(this,activity_menu_principal.class);
        startActivity(intent);
    }

    public void backToIniciarSesion(View view) {
        //se mata a todas las activities hasta llegar a MainActivity.
        //Sin embargo de momento pondremos un Intent aunque no es correcto, hasta que implementemos
          //funcionalidad de las tab
        finish();
    }
}
