package com.example.fandomoviesproject.peliculasDeUnaCategoria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.example.fandomoviesproject.R;
import com.example.fandomoviesproject.data.PeliculaItemCatalog;
import com.example.fandomoviesproject.data.SerieItemCatalog;
import com.example.fandomoviesproject.seriesDeUnaCategoria.SerieListAdapter;

public class PeliculaListAdapter extends RecyclerView.Adapter<PeliculaListAdapter.ViewHolder> {

    private List<PeliculaItemCatalog> itemList;
    private final View.OnClickListener clickListener;


    public PeliculaListAdapter(View.OnClickListener listener) {

        itemList = new ArrayList();
        clickListener = listener;
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
    public PeliculaListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_peliculas_de_una_categorialistacontent, parent, false);
        return new PeliculaListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PeliculaListAdapter.ViewHolder holder, int position) {
        holder.contentView.setText(itemList.get(position).content);

        holder.itemView.setTag(itemList.get(position));
        holder.itemView.setOnClickListener(clickListener);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView contentView;

        ViewHolder(View view) {
            super(view);
            contentView = view.findViewById(R.id.peliculaTexto);
        }
    }
}

