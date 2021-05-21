package com.example.fandomoviesproject.categoriasSeries;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.fandomoviesproject.R;
import com.example.fandomoviesproject.data.CategorySerieItemCatalog;

import java.util.ArrayList;
import java.util.List;

public class CategorySerieListAdapter extends RecyclerView.Adapter<CategorySerieListAdapter.ViewHolder> {

    private List<CategorySerieItemCatalog> itemList;
    private final View.OnClickListener clickListener;


    public CategorySerieListAdapter(View.OnClickListener listener) {

        itemList = new ArrayList();
        clickListener = listener;
    }


    public void addItem(CategorySerieItemCatalog item){
        itemList.add(item);
        notifyDataSetChanged();
    }

    public void addItems(List<CategorySerieItemCatalog> items){
        itemList.addAll(items);
        notifyDataSetChanged();
    }

    public void setItems(List<CategorySerieItemCatalog> items){
        itemList = items;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_categorias_de_serieslistacontent, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.itemView.setTag(itemList.get(position));
        holder.itemView.setOnClickListener(clickListener);

        holder.contentView.setText(itemList.get(position).content);

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView contentView;

        ViewHolder(View view) {
            super(view);
            contentView = view.findViewById(R.id.serieText);
        }
    }
}
