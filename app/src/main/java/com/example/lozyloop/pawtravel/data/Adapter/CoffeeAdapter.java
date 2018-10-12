package com.example.lozyloop.pawtravel.data.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lozyloop.pawtravel.R;
import com.example.lozyloop.pawtravel.data.Model.coffee_shops;

import java.util.List;


public class CoffeeAdapter extends RecyclerView.Adapter<CoffeeAdapter.ViewHolder> {

//    private ArrayList<String> mNames = new ArrayList<>();
//    private ArrayList<String> mImage = new ArrayList<>();
    private Context mContext;
    private List<coffee_shops> coffeeshopsList;

    public CoffeeAdapter(Context mContext, List<coffee_shops> coffeeshopsList) {
        this.mContext = mContext;
        this.coffeeshopsList = coffeeshopsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_shopcf, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

//        Glide.with(mContext)
//                .asBitmap()
//                .load(mImage.get(position))
//                .into(holder.image);
//
//        holder.name.setText(mNames.get(position));

        holder.name.setText(String.valueOf(coffeeshopsList.get(position).getmName()));
        Glide.with(mContext)
                .asBitmap()
                .load(String.valueOf(coffeeshopsList.get(position).getmImage()))
                .into(holder.image);


    }

    @Override
    public int getItemCount() {
        return coffeeshopsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_shop);
            name = itemView.findViewById(R.id.text_coffee);
        }
    }
}
