package com.example.fandomoviesproject.buscarPelis;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fandomoviesproject.R;
import com.example.fandomoviesproject.data.PeliculaItem;

import java.util.ArrayList;
import java.util.Collection;


public class PelisBuscarAdapter
        extends RecyclerView.Adapter<PelisBuscarAdapter.PeliViewHolder> implements Filterable {

    private ArrayList<PeliculaItem> mPeliList;
    private ArrayList<PeliculaItem> mPeliListFull;

    private LayoutInflater mInflater;
    private Context mContext;

    public PelisBuscarAdapter(Context context , ArrayList<PeliculaItem> mPeliList){
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
        this.mPeliList = mPeliList;
        this.mPeliListFull = mPeliList;

    }


    class PeliViewHolder extends RecyclerView.ViewHolder {
        private ImageView mDocusLogo;
        private ImageView mLikeImage;
        private ImageView mBuyImage;
        private TextView mTitleText;
        private TextView mInfoText;

        public PeliViewHolder(View itemView, PelisBuscarAdapter adapter){
            super(itemView);

            // Initialize
            mTitleText = itemView.findViewById(R.id.titulo);
            mInfoText = itemView.findViewById(R.id.directorypublicacion);
            mDocusLogo = itemView.findViewById(R.id.logo);
            mLikeImage = itemView.findViewById(R.id.likeboton);
            mBuyImage = itemView.findViewById(R.id.carroboton);
        }

        void bindTo(PeliculaItem mCurrent) {
            mTitleText.setText(mCurrent.getTitle());
            mInfoText.setText(mCurrent.getInfo());

            // Load images into ImageView using Glide
            Glide.with(mContext)
                    .load(mCurrent.getImageResourceLogo())
                    .into(mDocusLogo);
            Glide.with(mContext)
                    .load(mCurrent.getImageResourceLike())
                    .into(mLikeImage);
            Glide.with(mContext)
                    .load(mCurrent.getImageResourceCarro())
                    .into(mBuyImage);

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
    public PeliViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View mItemView = mInflater.inflate(
                R.layout.activity_buscar_pelisfila,parent,false);
        return new PeliViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(PeliViewHolder holder,int position) {
        PeliculaItem mCurrent= mPeliList.get(position);
        holder.bindTo(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mPeliList.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    Filter exampleFilter = new Filter() {

        //run on background thread
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            FilterResults results = new FilterResults();
            ArrayList<PeliculaItem> filteredList = new ArrayList<>();


            if(constraint != null || constraint.length() != 0) {
                String filterPattern = constraint.toString().toLowerCase();
                
                for (PeliculaItem item : mPeliListFull) {
                    if (item.getTitle().toLowerCase().contains(filterPattern) ||
                            item.getInfo().toLowerCase().contains(filterPattern)) {

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
            mPeliList.clear();
            mPeliList.addAll((Collection<? extends PeliculaItem>) filterResults.values);
            notifyDataSetChanged();
        }
    };

}
