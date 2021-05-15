package com.example.fandomoviesproject.buscarSeries;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import com.example.fandomoviesproject.data.SerieItem;

import java.util.ArrayList;
import java.util.Collection;


public class SeriesBuscarAdapter
        extends RecyclerView.Adapter<SeriesBuscarAdapter.SerieViewHolder> implements Filterable {

    private ArrayList<SerieItem> mSerieList;
    private ArrayList<SerieItem> mSerieListFull;

    private LayoutInflater mInflater;
    private Context mContext;

    public SeriesBuscarAdapter(Context context , ArrayList<SerieItem> mSerieList){
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
        this.mSerieList = mSerieList;
        this.mSerieListFull = mSerieList;

    }


    class SerieViewHolder extends RecyclerView.ViewHolder {
        private ImageView mSeriesLogo;
        private ImageView mLikeImage;
        private ImageView mBuyImage;
        private TextView mTitleText;
        private TextView mInfoText;

        public SerieViewHolder(View itemView, SeriesBuscarAdapter adapter){
            super(itemView);

            // Initialize
            mTitleText = itemView.findViewById(R.id.titulo);
            mInfoText = itemView.findViewById(R.id.directorypublicacion);
            mSeriesLogo = itemView.findViewById(R.id.logo);
            mLikeImage = itemView.findViewById(R.id.likeboton);
            mBuyImage = itemView.findViewById(R.id.carroboton);

            mBuyImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new AlertDialog.Builder(mContext)
                            .setTitle(R.string.realizarcompratitulo)
                            .setMessage(R.string.realizarcompraSerie)

                            // Specifying a listener allows you to take an action before dismissing the dialog.
                            // The dialog is automatically dismissed when a dialog button is clicked.
                            .setPositiveButton(R.string.siComprar, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // Continue with compra operation
                                    if(mContext instanceof SeriesBuscarActivity){
                                        ((SeriesBuscarActivity)mContext).onClickCarroButton(mTitleText,mInfoText);
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
                                        ((SeriesBuscarActivity)mContext).onClickCorazonButton(mTitleText,mInfoText);
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

        void bindTo(SerieItem mCurrent) {
            mTitleText.setText(mCurrent.getTitle());
            mInfoText.setText(mCurrent.getInfo());

            // Load images into ImageView using Glide
            Glide.with(mContext)
                    .load(mCurrent.getImageResourceLogo())
                    .into(mSeriesLogo);
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
    public SerieViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View mItemView = mInflater.inflate(
                R.layout.activity_buscar_seriesfila,parent,false);
        return new SerieViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(SerieViewHolder holder,int position) {
        SerieItem mCurrent= mSerieList.get(position);
        holder.bindTo(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mSerieList.size();
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
            ArrayList<SerieItem> filteredList = new ArrayList<>();


            if(constraint != null || constraint.length() != 0) {
                String filterPattern = constraint.toString().toLowerCase();
                
                for (SerieItem item : mSerieListFull) {
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
            mSerieList.clear();
            mSerieList.addAll((Collection<? extends SerieItem>) filterResults.values);
            notifyDataSetChanged();
        }
    };

}
