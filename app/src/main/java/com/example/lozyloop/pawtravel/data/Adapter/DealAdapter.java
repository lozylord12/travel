package com.example.lozyloop.pawtravel.data.Adapter;


import android.app.FragmentManager;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lozyloop.pawtravel.R;


import java.util.ArrayList;

public class DealAdapter extends RecyclerView.Adapter<DealAdapter.ViewHolder> {

    private ArrayList<Integer> mImageDeal = new ArrayList<>();
    private ArrayList<Integer> mNameDeal = new ArrayList<>();
    private ArrayList<Integer> mNameMoney = new ArrayList<>();
    private ArrayList<Integer> mNameInfo = new ArrayList<>();
    private ArrayList<Integer> mNameEmpty = new ArrayList<>();
    private Context mContext;

    private final OnItemClick click;

    public interface OnItemClick{
        void onClick(int position);
    }


    public DealAdapter(Context mContext, ArrayList<Integer> mImageDeal, ArrayList<Integer> mNameDeal, ArrayList<Integer> mNameMoney, ArrayList<Integer> mNameInfo, ArrayList<Integer> mNameEmpty, OnItemClick click) {
        this.mImageDeal = mImageDeal;
        this.mNameDeal = mNameDeal;
        this.mNameMoney = mNameMoney;
        this.mNameInfo = mNameInfo;
        this.mNameEmpty = mNameEmpty;
        this.mContext = mContext;
        this.click = click;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_deal, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Glide.with(mContext)
                .asBitmap()
                .load(mImageDeal.get(position))
                .into(holder.image_deal);

        holder.name_deal.setText(mNameDeal.get(position));
        holder.name_money.setText(mNameMoney.get(position));
        holder.name_info.setText(mNameInfo.get(position));
        holder.name_empty.setText(mNameEmpty.get(position));

    }

    @Override
    public int getItemCount() {
        return mImageDeal.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView image_deal;
        TextView name_deal,name_money,name_info,name_empty;


        public ViewHolder(View itemView) {
            super(itemView);
            image_deal = itemView.findViewById(R.id.image_deal);
            name_deal = itemView.findViewById(R.id.text_deal);
            name_money = itemView.findViewById(R.id.text_money);
            name_info = itemView.findViewById(R.id.tet_info_deal);
            name_empty = itemView.findViewById(R.id.text_empty);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            click.onClick(position);
        }
    }
}
