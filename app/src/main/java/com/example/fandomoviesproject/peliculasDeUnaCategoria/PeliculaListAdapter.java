package com.example.fandomoviesproject.peliculasDeUnaCategoria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import com.example.fandomoviesproject.R;
import com.example.fandomoviesproject.data.PeliculaItemCatalog;

public class PeliculaListAdapter extends ArrayAdapter<PeliculaItemCatalog> {

    private final List<PeliculaItemCatalog> itemList;
    private final View.OnClickListener clickListener;


    public PeliculaListAdapter(
            Context context, List<PeliculaItemCatalog> items, View.OnClickListener listener) {

        super(context, 0, items);

        itemList = items;
        clickListener = listener;
    }


    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public PeliculaItemCatalog getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;

        if (itemView == null) {
            itemView = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.activity_peliculas_de_una_categorialistacontent, parent, false);
        }

        itemView.setTag(itemList.get(position));
        itemView.setOnClickListener(clickListener);

        final TextView contentView = itemView.findViewById(R.id.peliculaText);
        contentView.setText(itemList.get(position).content);

        return itemView;
    }


}

