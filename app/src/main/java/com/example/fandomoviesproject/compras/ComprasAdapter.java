package com.example.fandomoviesproject.compras;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fandomoviesproject.R;
import com.example.fandomoviesproject.data.ComprasItem;

import java.util.ArrayList;


public class ComprasAdapter
        extends RecyclerView.Adapter<ComprasAdapter.CompraViewHolder> {

    private ArrayList<ComprasItem> comprasList;

    private LayoutInflater mInflater;
    private Context mContext;

    public ComprasAdapter(Context context , ArrayList<ComprasItem> comprasList){
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
        this.comprasList = comprasList;
    }


    class CompraViewHolder extends RecyclerView.ViewHolder {
        private ImageView carro;
        private TextView mTitleText;
        private TextView mInfoText;

        public CompraViewHolder(View itemView, ComprasAdapter adapter){
            super(itemView);

            // Initialize
            mTitleText = itemView.findViewById(R.id.tituloCompra);
            mInfoText = itemView.findViewById(R.id.directorypublicacionCompra);
            carro = itemView.findViewById(R.id.logoCompra);


        }

        void bindTo(ComprasItem mCurrent) {
            mTitleText.setText(mCurrent.getTitle());
            mInfoText.setText(mCurrent.getInfo());

            // Load images into ImageView using Glide
            Glide.with(mContext)
                    .load(mCurrent.getCarroImage())
                    .into(carro);

        }

       /* @Override
        public void onClick(View view){
            // Get position of item that was clicked
            int mPosition = getLayoutPosition();
            // Use it to access selected item in word list
            LinearLayout element = mDocuList.get(mPosition);
            // Change word in word list
            mWordList.set(mPosition, "Clicked! " + element);
            // Notify adapter so it updates RecyclerView to show updated data
            mAdapter.notifyDataSetChanged();
        }
        */
    }


    @Override
    public CompraViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View mItemView = mInflater.inflate(
                R.layout.activity_comprasfila,parent,false);
        return new CompraViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(CompraViewHolder holder,int position) {
        ComprasItem mCurrent= comprasList.get(position);
        holder.bindTo(mCurrent);
    }

    @Override
    public int getItemCount() {
        return comprasList.size();
    }


}
