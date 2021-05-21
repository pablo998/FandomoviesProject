package com.example.fandomoviesproject.docusDeUnaCategoria;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.fandomoviesproject.R;
import com.example.fandomoviesproject.data.DocuItemCatalog;
import java.util.ArrayList;
import java.util.List;


public class DocuListAdapter extends RecyclerView.Adapter<DocuListAdapter.ViewHolder> {

    private List<DocuItemCatalog> itemList;
    private final View.OnClickListener clickListener;


    public DocuListAdapter(View.OnClickListener listener) {

        itemList = new ArrayList();
        clickListener = listener;
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
    public DocuListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_documentales_de_una_categorialistacontent, parent, false);
        return new DocuListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final DocuListAdapter.ViewHolder holder, int position) {
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
            contentView = view.findViewById(R.id.documentalText);
        }
    }
}

