package com.example.fandomoviesproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class activity_registrarte_emailtab extends AppCompatActivity {

    TabLayout tabLayout = findViewById(R.id.tabLayout);
    ViewPager viewPager = findViewById(R.id.viewPager);
    Button registrarme, tengoCuenta;
    TabItem numeroDeMovilTab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarte_emailtab);
        selectPage(2);

        registrarme = findViewById(R.id.botonRegistrarme);
        tengoCuenta = findViewById(R.id.botonIniciaSesion);
        numeroDeMovilTab = findViewById(R.id.tabNumero2);

        registrarme.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goToMenu(v);
            }
        });
    }



    void selectPage(int pageIndex){
        tabLayout.setScrollPosition(pageIndex,0f,true);
        viewPager.setCurrentItem(pageIndex);
    }


    public void goToNumeroDeMovilTab(View view) {
        Intent intent = new Intent(this,activity_registrarte_numerodemoviltab.class);
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