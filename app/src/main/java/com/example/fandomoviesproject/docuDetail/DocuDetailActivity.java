package com.example.fandomoviesproject.docuDetail;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
//import android.widget.Toolbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.fandomoviesproject.R;
import com.example.fandomoviesproject.data.DocuItemCatalog;
import com.example.fandomoviesproject.data.PeliculaItemCatalog;

public class DocuDetailActivity
        extends AppCompatActivity implements DocuDetailContract.View {

    public static String TAG = DocuDetailActivity.class.getSimpleName();

    private DocuDetailContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_docu);
        Toolbar toolbar = findViewById(R.id.toolbarDetail);
        setSupportActionBar(toolbar);

    /*
    if(savedInstanceState == null) {
      AppMediator.resetInstance();
    }
    */

        // do the setup
        DocuDetailScreen.configure(this);

        presenter.fetchDocuDetailData();

        // Show the Up button and the title in the action bar
        ActionBar actionBarDetail = getSupportActionBar();
        if (actionBarDetail != null) {
            actionBarDetail.setDisplayHomeAsUpEnabled(true);
            actionBarDetail.setDisplayShowTitleEnabled(false);
        }
    }




    @Override
    public void injectPresenter(DocuDetailContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayDocuDetailData(DocuDetailViewModel viewModel) {
        // deal with the data
        DocuItemCatalog product = viewModel.product;

        if (product != null) {
            ((TextView) findViewById(R.id.textView_nombreDocu)).setText(product.details);
        }

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

    @Override
    public void onBackPressed()
    {
        finish();
    }
}
