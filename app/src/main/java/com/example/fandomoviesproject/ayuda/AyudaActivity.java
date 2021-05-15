package com.example.fandomoviesproject.ayuda;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.fandomoviesproject.R;



public class AyudaActivity extends AppCompatActivity {
    AyudaContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ActionBar actionBar = getSupportActionBar();
        if(actionBar !=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Ayuda");
        }


        // do the setup
//        AyudaScreen.configure(this);

    }
   // no va
   /* @Override
    public void injectPresenter(AyudaContract.Presenter presenter) {
        injectPresenter(this.presenter = presenter);
    }

    */


}
