package com.example.lozyloop.pawtravel.Screen.ItemHotel;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lozyloop.pawtravel.R;
import com.example.lozyloop.pawtravel.Screen.ItemTravel.ItemTravelFragment;

public class ItemHotelFragment extends Fragment {

    ImageView mImagePlace;
    TextView text_review;

    public final static String BACK_STACK_ItemHotel = "fragment ItemHotel";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.item_hotel_fragment, container, false);

        init(v);
        setWidget();

        Handling();

        return v;


    }

    public void init(View view){
        mImagePlace = view.findViewById(R.id.image_place_hotel);
        text_review = view.findViewById(R.id.text_review);
    }

    public void setWidget(){
        Glide.with(this)
                .asBitmap()
                .load(R.drawable.img_swimming_pool)
                .into(mImagePlace);
    }

    public void Handling(){
        text_review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.addToBackStack(BACK_STACK_ItemHotel);
                transaction.replace(R.id.layout_ItemHotel, new itemRateFragment(), BACK_STACK_ItemHotel);
                transaction.commit();
            }
        });
    }


}
