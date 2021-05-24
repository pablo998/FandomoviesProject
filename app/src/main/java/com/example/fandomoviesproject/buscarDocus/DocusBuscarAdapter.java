package com.example.fandomoviesproject.buscarDocus;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.bumptech.glide.Glide;
import com.example.fandomoviesproject.R;
import com.example.fandomoviesproject.data.DocuItemCatalog;
import com.example.fandomoviesproject.data.PeliculaItemCatalog;
import com.example.fandomoviesproject.data.SerieItemCatalog;
import com.example.fandomoviesproject.seriesDeUnaCategoria.SerieListAdapter;

public class DocusBuscarAdapter extends RecyclerView.Adapter<DocusBuscarAdapter.ViewHolder>  implements Filterable {

    private List<DocuItemCatalog> itemList;
    private List<DocuItemCatalog> itemListFull;
    public static String TAG = DocusBuscarAdapter.class.getSimpleName();


    private Context mContext;


    public DocusBuscarAdapter(Context context , ArrayList<DocuItemCatalog> itemList) {
        this.mContext = context;
        this.itemList = itemList;
        this.itemListFull = itemList;
    }


    public void addItem(DocuItemCatalog item){
        itemList.add(item);
        notifyDataSetChanged();
    }

    public void addItems(List<DocuItemCatalog> items){
        itemList.addAll(items);
        notifyDataSetChanged();
    }

    public void setItems(List<DocuItemCatalog> items){
        itemList = items;
        notifyDataSetChanged();
    }

    @Override
    public DocusBuscarAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_buscar_pelisfila, parent, false);
        return new DocusBuscarAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final DocusBuscarAdapter.ViewHolder holder, int position) {
        DocuItemCatalog mCurrent = itemList.get(position);
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
                                    if(mContext instanceof DocusBuscarActivity){
                                        ((DocusBuscarActivity)mContext).onClickCarroButton(contentView,direccionYpublicacion, url_comprar);
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
                                    if(mContext instanceof DocusBuscarActivity){
                                        ((DocusBuscarActivity)mContext).onClickCorazonButton(contentView,direccionYpublicacion);
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

        void bindTo(DocuItemCatalog mCurrent) {
            contentView.setText(mCurrent.content);
            direccionYpublicacion.setText(mCurrent.directorYfecha);
            logo.setImageResource(R.drawable.docuslogo);
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
            List<DocuItemCatalog> filteredList = new ArrayList<>();


            if(constraint != null || constraint.length() != 0) {
                String filterPattern = constraint.toString().toLowerCase();

                for (DocuItemCatalog item : itemListFull) {
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
            itemList.addAll((Collection<? extends DocuItemCatalog>) filterResults.values);
            notifyDataSetChanged();
        }
    };


}

