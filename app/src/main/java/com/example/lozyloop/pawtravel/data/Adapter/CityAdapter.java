package com.example.lozyloop.pawtravel.data.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lozyloop.pawtravel.R;

import java.util.ArrayList;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder>{

    private ArrayList<String> mNamesCity = new ArrayList<>();
    private ArrayList<Integer> mImageCity = new ArrayList<>();
    private Context mContext;

    public CityAdapter( Context mContext, ArrayList<String> mNamesCity, ArrayList<Integer> mImageCity) {
        this.mNamesCity = mNamesCity;
        this.mImageCity = mImageCity;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_city, parent, false);
        return new CityAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(mContext)
                .asBitmap()
                .load(mImageCity.get(position))
                .into(holder.image);

        holder.name.setText(mNamesCity.get(position));
    }

    @Override
    public int getItemCount() {
        return mImageCity.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_city);
            name = itemView.findViewById(R.id.text_city);
        }
    }
}
