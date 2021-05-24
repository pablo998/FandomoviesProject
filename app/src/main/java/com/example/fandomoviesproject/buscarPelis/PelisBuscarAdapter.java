package com.example.fandomoviesproject.buscarPelis;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.example.fandomoviesproject.R;
import com.example.fandomoviesproject.data.PeliculaItemCatalog;

public class PelisBuscarAdapter extends RecyclerView.Adapter<PelisBuscarAdapter.ViewHolder>  implements Filterable {

    private List<PeliculaItemCatalog> itemList;
    private List<PeliculaItemCatalog> itemListFull;
    public static String TAG = PelisBuscarAdapter.class.getSimpleName();


    private Context mContext;


    public PelisBuscarAdapter(Context context , ArrayList<PeliculaItemCatalog> itemList) {
        this.mContext = context;
        this.itemList = itemList;
        this.itemListFull = itemList;
    }


    public void addItem(PeliculaItemCatalog item){
        itemList.add(item);
        notifyDataSetChanged();
    }

    public void addItems(List<PeliculaItemCatalog> items){
        itemList.addAll(items);
        notifyDataSetChanged();
    }

    public void setItems(List<PeliculaItemCatalog> items){
        itemList = items;
        notifyDataSetChanged();
    }

    @Override
    public PelisBuscarAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_buscar_pelisfila, parent, false);
        return new PelisBuscarAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PelisBuscarAdapter.ViewHolder holder, int position) {
        PeliculaItemCatalog mCurrent = itemList.get(position);
        holder.bindTo(mCurrent);
        holder.itemView.setTag(itemList.get(position));

    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView contentView;
        final TextView direccionYpublicacion;
        final ImageView logo;
        final ImageButton mLikeImage;
        final ImageButton mBuyImage;
        String url_comprar;

        ViewHolder(View view) {
            super(view);
            contentView = view.findViewById(R.id.titulo);
            direccionYpublicacion = view.findViewById(R.id.directorypublicacion);
            logo = view.findViewById(R.id.logo);
            mLikeImage = view.findViewById(R.id.likeboton);
            mBuyImage = view.findViewById(R.id.carroboton);

            mBuyImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new AlertDialog.Builder(mContext)
                            .setTitle(R.string.realizarcompratitulo)
                            .setMessage(R.string.realizarcompra)

                            // Specifying a listener allows you to take an action before dismissing the dialog.
                            // The dialog is automatically dismissed when a dialog button is clicked.
                            .setPositiveButton(R.string.siComprar, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // Continue with compra operation
                                    if(mContext instanceof PelisBuscarActivity){
                                        ((PelisBuscarActivity)mContext).onClickCarroButton(contentView,direccionYpublicacion, url_comprar);
                                    }
                                }
                            })

                            // A null listener allows the button to dismiss the dialog and take no further action.
                            .setNegativeButton(R.string.no, null)
                            .setIcon(R.drawable.carrito)
                            .show();
                }

            });

            mLikeImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new AlertDialog.Builder(mContext)
                            .setTitle(R.string.añadirfavoritotitulo)
                            .setMessage(R.string.añadirfavorito)

                            // Specifying a listener allows you to take an action before dismissing the dialog.
                            // The dialog is automatically dismissed when a dialog button is clicked.
                            .setPositiveButton(R.string.siFav, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // Continue with favorito operation
                                    if(mContext instanceof PelisBuscarActivity){
                                        ((PelisBuscarActivity)mContext).onClickCorazonButton(contentView,direccionYpublicacion);
                                    }
                                }
                            })

                            // A null listener allows the button to dismiss the dialog and take no further action.
                            .setNegativeButton(R.string.no, null)
                            .setIcon(R.drawable.favorito)
                            .show();
                }

            });

        }

        void bindTo(PeliculaItemCatalog mCurrent) {
            contentView.setText(mCurrent.content);
            direccionYpublicacion.setText(mCurrent.directorYfecha);
            logo.setImageResource(R.drawable.pelis);
            mLikeImage.setImageResource(R.drawable.favorito);
            mBuyImage.setImageResource(R.drawable.carrito);
            url_comprar = mCurrent.url_comprar;

        }
    }


    @Override
    public Filter getFilter() {
        return exampleFilter;
    }


    Filter exampleFilter = new Filter() {

        //run on background thread
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            itemListFull = itemList;

            FilterResults results = new FilterResults();
            List<PeliculaItemCatalog> filteredList = new ArrayList<>();


            if(constraint != null || constraint.length() != 0) {
                String filterPattern = constraint.toString().toLowerCase();

                for (PeliculaItemCatalog item : itemListFull) {
                    if (item.content.toLowerCase().contains(filterPattern)) {

                        filteredList.add(item);
                    }
                }

                results.count = filteredList.size();
                results.values = filteredList;
            }

            return results;
        }

        //runs on a UI thread
        @Override
        protected void publishResults(CharSequence constraint, FilterResults filterResults) {
            itemList.clear();
            itemList.addAll((Collection<? extends PeliculaItemCatalog>) filterResults.values);
            notifyDataSetChanged();
        }
    };


}

