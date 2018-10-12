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

public class WorldAdapter extends RecyclerView.Adapter<WorldAdapter.ViewHolder> {

    private ArrayList<Integer> mImageWord1 = new ArrayList<>();
    private ArrayList<Integer> mImageWord2 = new ArrayList<>();
    private Context mContext;

    public WorldAdapter(Context mContext, ArrayList<Integer> mImageWord1, ArrayList<Integer> mImageWord2) {
        this.mImageWord1 = mImageWord1;
        this.mImageWord2 = mImageWord2;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_world, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Glide.with(mContext)
                .asBitmap()
                .load(mImageWord1.get(position))
                .into(holder.image_world_1);

        Glide.with(mContext)
                .asBitmap()
                .load(mImageWord2.get(position))
                .into(holder.image_world_2);
    }

    @Override
    public int getItemCount() {
        return mImageWord1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image_world_1;
        ImageView image_world_2;

        public ViewHolder(View itemView) {
            super(itemView);
            image_world_1 = itemView.findViewById(R.id.image_world_1);
            image_world_2 = itemView.findViewById(R.id.image_world_2);
        }
    }
}
