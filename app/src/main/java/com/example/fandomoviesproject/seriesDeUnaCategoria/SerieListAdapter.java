package com.example.fandomoviesproject.seriesDeUnaCategoria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.fandomoviesproject.R;
import com.example.fandomoviesproject.data.SerieItemCatalog;

import java.util.ArrayList;
import java.util.List;

public class SerieListAdapter extends RecyclerView.Adapter<SerieListAdapter.ViewHolder> {

    private List<SerieItemCatalog> itemList;
    private final View.OnClickListener clickListener;


    public SerieListAdapter(View.OnClickListener listener) {

        itemList = new ArrayList();
        clickListener = listener;
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
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_series_de_una_categorialistacontent, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
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
            contentView = view.findViewById(R.id.serieText);
        }
    }
}

