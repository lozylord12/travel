package com.example.lozyloop.pawtravel.Screen.ItemHotel;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lozyloop.pawtravel.R;


import static com.example.lozyloop.pawtravel.Screen.ItemHotel.itemRateFragment.BACK_STACK_ItemRate;

public class ItemWriteRateFragment extends Fragment {

    ImageView imageView3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.item_write_rate_fragment, container, false);

        init(v);
        EventOnClick();

        return v;

    }

    public void init(View view){
        imageView3 = view.findViewById(R.id.imageView3);
    }

    public void EventOnClick(){
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = getFragmentManager().getBackStackEntryCount() - 1;
                for (int i = count; i > 0; i--){

                    if (getFragmentManager().getBackStackEntryAt(i).getName().equals(BACK_STACK_ItemRate)){
                        getFragmentManager().popBackStack(BACK_STACK_ItemRate, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                        return;
                    }

                }
            }
        });
    }
}
