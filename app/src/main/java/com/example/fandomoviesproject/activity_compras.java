package com.example.fandomoviesproject;

import android.drm.DrmStore;
import android.os.Bundle;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class activity_compras extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_compras);

            Toolbar toolbar = findViewById(R.id.toolbar3);
            setSupportActionBar(toolbar);

            ActionBar actionBar = getSupportActionBar();
            if(actionBar !=null){
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setTitle("Compras");
            }

        }
}

