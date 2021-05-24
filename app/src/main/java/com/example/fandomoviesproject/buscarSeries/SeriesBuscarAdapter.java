package com.example.fandomoviesproject.buscarSeries;

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
import com.example.fandomoviesproject.data.SerieItemCatalog;

public class SeriesBuscarAdapter extends RecyclerView.Adapter<SeriesBuscarAdapter.ViewHolder>  implements Filterable {

    private List<SerieItemCatalog> itemList;
    private List<SerieItemCatalog> itemListFull;
    public static String TAG = SeriesBuscarAdapter.class.getSimpleName();


    private Context mContext;


    public SeriesBuscarAdapter(Context context , ArrayList<SerieItemCatalog> itemList) {
        this.mContext = context;
        this.itemList = itemList;
        this.itemListFull = itemList;
    }


    public void addItem(SerieItemCatalog item){
        itemList.add(item);
        notifyDataSetChanged();
    }

    public void addItems(List<SerieItemCatalog> items){
        itemList.addAll(items);
        notifyDataSetChanged();
    }

    public void setItems(List<SerieItemCatalog> items){
        itemList = items;
        notifyDataSetChanged();
    }

    @Override
    public SeriesBuscarAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_buscar_seriesfila, parent, false);
        return new SeriesBuscarAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SeriesBuscarAdapter.ViewHolder holder, int position) {
        SerieItemCatalog mCurrent = itemList.get(position);
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
                                    if(mContext instanceof SeriesBuscarActivity){
                                        ((SeriesBuscarActivity)mContext).onClickCarroButton(contentView,direccionYpublicacion, url_comprar);
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
                                    if(mContext instanceof SeriesBuscarActivity){
                                        ((SeriesBuscarActivity)mContext).onClickCorazonButton(contentView,direccionYpublicacion);
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

        void bindTo(SerieItemCatalog mCurrent) {
            contentView.setText(mCurrent.content);
            direccionYpublicacion.setText(mCurrent.directorYfecha);
            logo.setImageResource(R.drawable.play);
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
            List<SerieItemCatalog> filteredList = new ArrayList<>();


            if(constraint != null || constraint.length() != 0) {
                String filterPattern = constraint.toString().toLowerCase();

                for (SerieItemCatalog item : itemListFull) {
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
            itemList.addAll((Collection<? extends SerieItemCatalog>) filterResults.values);
            notifyDataSetChanged();
        }
    };


}

