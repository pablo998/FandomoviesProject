package com.example.fandomoviesproject.ayuda;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.fandomoviesproject.R;



public class AyudaActivity extends AppCompatActivity implements AyudaContract.View {
    AyudaContract.Presenter presenter;

    TextView informacionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        informacionText = findViewById(R.id.ayuda_text);


        ActionBar actionBar = getSupportActionBar();
        if(actionBar !=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.ayuda_text);
        }


          //do the setup
         AyudaScreen.configure(this);

    }

    @Override
    public void injectPresenter(AyudaContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayAyudaData(AyudaViewModel viewModel) {
        informacionText.setText(viewModel.informacion);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
