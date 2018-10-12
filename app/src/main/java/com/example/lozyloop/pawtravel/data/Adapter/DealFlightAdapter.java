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

public class DealFlightAdapter extends RecyclerView.Adapter<DealFlightAdapter.ViewHolder> {

    private ArrayList<Integer> mImageDeal = new ArrayList<>();
    private ArrayList<Integer> mNameDeal = new ArrayList<>();
    private ArrayList<Integer> mNameMoney = new ArrayList<>();
    private ArrayList<Integer> mNameInfo = new ArrayList<>();
    private ArrayList<Integer> mNameEmpty = new ArrayList<>();
    private Context mContext;

    public DealFlightAdapter(Context mContext, ArrayList<Integer> mImageDeal, ArrayList<Integer> mNameDeal, ArrayList<Integer> mNameMoney, ArrayList<Integer> mNameInfo, ArrayList<Integer> mNameEmpty) {
        this.mImageDeal = mImageDeal;
        this.mNameDeal = mNameDeal;
        this.mNameMoney = mNameMoney;
        this.mNameInfo = mNameInfo;
        this.mNameEmpty = mNameEmpty;
        this.mContext = mContext;


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_deal_flight, parent, false);
        return new DealFlightAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Glide.with(mContext)
                .asBitmap()
                .load(mImageDeal.get(position))
                .into(holder.image_deal_flight);

        holder.name_deal_flight.setText(mNameDeal.get(position));
        holder.name_money_flight.setText(mNameMoney.get(position));
        holder.name_info_flight.setText(mNameInfo.get(position));
        holder.name_empty_flight.setText(mNameEmpty.get(position));
    }

    @Override
    public int getItemCount() {
        return mImageDeal.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image_deal_flight;
        TextView name_deal_flight,name_money_flight,name_info_flight,name_empty_flight;


        public ViewHolder(View itemView) {
            super(itemView);
            image_deal_flight = itemView.findViewById(R.id.image_deal_flight);
            name_deal_flight = itemView.findViewById(R.id.text_deal_flight);
            name_money_flight = itemView.findViewById(R.id.text_money_flight);
            name_info_flight = itemView.findViewById(R.id.tet_info_deal_flight);
            name_empty_flight = itemView.findViewById(R.id.text_empty_flight);

        }


    }
}
