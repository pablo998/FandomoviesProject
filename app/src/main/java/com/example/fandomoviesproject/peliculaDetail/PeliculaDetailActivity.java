package com.example.fandomoviesproject.peliculaDetail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.fandomoviesproject.R;
import com.example.fandomoviesproject.data.PeliculaItemCatalog;
import com.example.fandomoviesproject.data.SerieItemCatalog;


public class PeliculaDetailActivity
        extends AppCompatActivity implements PeliculaDetailContract.View {

    public static String TAG = PeliculaDetailActivity.class.getSimpleName();

    PeliculaDetailContract.Presenter presenter;
    Button trailerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pelicula);

        Toolbar toolbar = findViewById(R.id.toolbarDetail);
        setSupportActionBar(toolbar);

        trailerButton = findViewById(R.id.button_trailerPelicula);
        trailerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickTrailerButton();
            }
        });

        // Show the Up button and the title in the action bar
        ActionBar actionBarDetail = getSupportActionBar();
        if (actionBarDetail != null) {
            actionBarDetail.setDisplayHomeAsUpEnabled(true);
            actionBarDetail.setDisplayShowTitleEnabled(false);
        }

        // do the setup
        PeliculaDetailScreen.configure(this);

        // do some work
        presenter.fetchPeliculaDetailData();
    }

    @Override
    public void injectPresenter(PeliculaDetailContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayPeliculaDetailData(PeliculaDetailViewModel viewModel) {
        Log.e(TAG, "displayPeliDetailData()");

        // deal with the data
        PeliculaItemCatalog serie = viewModel.product;

        ((TextView) findViewById(R.id.textView_nombrePelicula)).setText(serie.content);
        loadImageFromURL(findViewById(R.id.image_portada), serie.url_imagen);
        ((TextView) findViewById(R.id.textView_fechaPelicula)).setText(serie.fecha);
        ((TextView) findViewById(R.id.sinopsisContentPeli)).setText(serie.sinopsis);

        ((TextView) findViewById(R.id.textView_nombre_actor1)).setText(serie.actor1);
        ((TextView) findViewById(R.id.textView_nombre_actor2)).setText(serie.actor2);
        ((TextView) findViewById(R.id.textView_nombre_actor3)).setText(serie.actor3);

        ((TextView) findViewById(R.id.textView_valoracion1)).setText(serie.valoracion1);
        ((TextView) findViewById(R.id.textView_valoracion2)).setText(serie.valoracion2);
        ((TextView) findViewById(R.id.textView_valoracion3)).setText(serie.valoracion3);

    }

    @Override
    public void navigateToURLtrailer(String URLtrailer){
        Uri uri = Uri.parse(URLtrailer); //missing 'http://' will cause crash
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
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

    private void loadImageFromURL(ImageView imageView, String imageUrl){
        RequestManager reqManager = Glide.with(imageView.getContext());
        RequestBuilder reqBuilder = reqManager.load(imageUrl);
        RequestOptions reqOptions = new RequestOptions();
        reqOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
        reqBuilder.apply(reqOptions);
        reqBuilder.into(imageView);
    }


    @Override
    public void onBackPressed()
    {
        finish();
    }

}

