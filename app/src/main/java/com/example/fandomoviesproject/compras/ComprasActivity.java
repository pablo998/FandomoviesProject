package com.example.fandomoviesproject.compras;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fandomoviesproject.R;
import com.example.fandomoviesproject.data.ComprasItem;
import com.example.fandomoviesproject.favoritos.FavoritosActivity;


import java.util.ArrayList;


public class ComprasActivity extends AppCompatActivity implements ComprasContract.View {

    public static String TAG = ComprasActivity.class.getSimpleName();
    ComprasContract.Presenter presenter;
    private ComprasAdapter mAdapter;

    //TODO ESTO NO IRÍA AQUÍ
    private final ArrayList<ComprasItem> comprasList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compras);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Show the title in the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.compras);
        }

        // Get a handle to RecyclerView
        mRecyclerView = findViewById(R.id.recyclerviewCompras);
        // Create an adapter and supply data to be displayed
        mAdapter= new ComprasAdapter(this, comprasList);
        // Connect adapter with RecyclerView
        mRecyclerView.setAdapter(mAdapter);
        // Give RecyclerView a default layout manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        /*
         if(savedInstanceState == null) {
         CatalogMediator.resetInstance();
         }
        */


        // do the setup
        ComprasScreen.configure(this);

        // do some work
        presenter.fetchComprasData();
    }



    @Override
    public void displayComprasData(ComprasViewModel viewModel) {
        TypedArray imageCompra = getResources()
                .obtainTypedArray(R.array.carro_compras);

        for (int i = 0; i < viewModel.compras.size(); i++) {
            comprasList.add(new ComprasItem(
                            viewModel.compras.get(i).getTitle(), viewModel.compras.get(i).getInfo(), imageCompra.getResourceId(0, 0)
                    )
            );
        }
        this.mAdapter.notifyDataSetChanged(); // Notify adapter of change
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        // Inflate the menu: this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_borrar, menu);
        return true;
    }



    // Determines if Action bar item was selected. If true then do corresponding action.
    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        // handle presses on the action bar items
        switch (item.getItemId()) {

            case android.R.id.home:
                finish();
                return true;
            case R.id.itemBorrar:
                borrarListaDeCompras();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void borrarListaDeCompras() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.eliminarComprasTitle)
                .setMessage(R.string.eliminarCompras)

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton(R.string.siDelete, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Continue with delete operation
                        presenter.borrarListaDeCompras();
                    }
                })

                // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton(R.string.no, null)
                .setIcon(R.drawable.ic_baseline_deleteblack_24)
                .show();
    }


    @Override
    public void injectPresenter(ComprasContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onBackPressed()
    {
        finish();
    }

    @Override
    public void reiniciarPantalla()
    {
        recreate();
    }

}