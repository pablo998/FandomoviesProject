package com.example.fandomoviesproject.registrarse;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabItem;
import com.example.fandomoviesproject.R;
import com.google.android.material.textfield.TextInputEditText;


public class RegistrarseActivity extends AppCompatActivity {


    Button tengoCuenta;
    private Context context = this;
    private TabHost tabHost;
    TextInputEditText input2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        tengoCuenta = findViewById(R.id.botonIniciaSesion);
        input2 = findViewById(R.id.input2);

        tabHost = findViewById(R.id.tabHostRegistro);
        tabHost.setup();
        setUpTabs();

    }

    private void setUpTabs() {
        TabHost.TabSpec tabSpec = tabHost.newTabSpec("tab1");
        tabSpec.setContent(R.id.tab1);
        tabSpec.setIndicator("Email");

        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("tab2");
        tabSpec2.setContent(R.id.tab2);
        tabSpec2.setIndicator("Número de móvil");

        tabHost.addTab(tabSpec);
        tabHost.addTab(tabSpec2);

        tabHost.setCurrentTab(0);
    }


    public void goToMenu(View view) {
        Intent intent = new Intent(this,com.example.fandomoviesproject.menu.MenuActivity.class);
        startActivity(intent);
    }

    public void backToIniciarSesion(View view) {
        finish();
    }
}
