package com.example.lozyloop.pawtravel.Screen.ItemHotel;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.lozyloop.pawtravel.R;
import com.example.lozyloop.pawtravel.Screen.ItemTravel.ItemTravelFragment;

import java.util.Timer;
import java.util.TimerTask;

public class itemRateFragment extends Fragment{

    ProgressBar progressBar,progressBar2,progressBar3,progressBar4,progressBar5;
    TextView tv_write;
    Handler handler;

    public final static String BACK_STACK_ItemRate = "fragment ItemRate";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.item_rate_fragment, container, false);

        init(v);
        Handling();
        EventOnclick();

        return v;

    }

    public void init(View view){
        progressBar = view.findViewById(R.id.progressBar);
        progressBar2 = view.findViewById(R.id.progressBar2);
        progressBar3= view.findViewById(R.id.progressBar3);
        progressBar4 = view.findViewById(R.id.progressBar4);
        progressBar5 = view.findViewById(R.id.progressBar5);
        tv_write = view.findViewById(R.id.tv_write);
    }

    public void Handling() {

        progressBar.setProgress(80);
        progressBar.setMax(100);

        progressBar2.setProgress(20);
        progressBar2.setMax(100);

        progressBar3.setProgress(20);
        progressBar3.setMax(100);

        handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
                progressBar2.setVisibility(View.GONE);
                progressBar3.setVisibility(View.GONE);

            }
        };
    }

    public void EventOnclick(){
        tv_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.addToBackStack(BACK_STACK_ItemRate);
                transaction.replace(R.id.layout_ItemRate, new ItemWriteRateFragment(), BACK_STACK_ItemRate);
                transaction.commit();
            }
        });
    }




}
