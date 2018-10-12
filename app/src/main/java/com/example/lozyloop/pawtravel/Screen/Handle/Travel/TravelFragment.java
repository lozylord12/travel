package com.example.lozyloop.pawtravel.Screen.Handle.Travel;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lozyloop.pawtravel.R;
import com.example.lozyloop.pawtravel.Screen.ItemTravel.ItemTravelFragment;
import com.example.lozyloop.pawtravel.data.Model.Snap;
import com.example.lozyloop.pawtravel.data.Adapter.SnapAdapter;
import com.example.lozyloop.pawtravel.data.Model.App;

import java.util.ArrayList;
import java.util.List;

public class TravelFragment extends Fragment {

    public static final String ORIENTATION = "orientation";

    public final static String BACK_STACK_TRAVEL = "fragment travel";

    private RecyclerView mRecyclerView;
    private boolean mHorizontal;
    ImageView image_banner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.travel_fragment, container, false);


        init(v);
        checkInstanceState(savedInstanceState);
        Handling();
        setupAdapter();

        return v;
    }

    public void checkInstanceState(Bundle savedInstanceState){

        if (savedInstanceState == null) {
            mHorizontal = true;
        }else {
            mHorizontal = savedInstanceState.getBoolean(ORIENTATION);
        }
    }

    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putBoolean(ORIENTATION, mHorizontal);
    }

    public void setupAdapter(){
        List<App> apps = getApps();

        SnapAdapter snapAdapter = new SnapAdapter();
        if (mHorizontal) {
            snapAdapter.addSnap(new Snap(Gravity.CENTER_HORIZONTAL, "Relaxation", apps));
            snapAdapter.addSnap(new Snap(Gravity.START, "Hiking", apps));
            snapAdapter.addSnap(new Snap(Gravity.END, "Rest", apps));
            snapAdapter.addSnap(new Snap(Gravity.CENTER, "Anywhere", apps));
            snapAdapter.addSnap(new Snap(Gravity.CENTER, "SomeWhere", apps));
        } else {
            snapAdapter.addSnap(new Snap(Gravity.CENTER_VERTICAL, "Snap Relaxation", apps));
            snapAdapter.addSnap(new Snap(Gravity.TOP, "Hiking", apps));
            snapAdapter.addSnap(new Snap(Gravity.BOTTOM, "Rest", apps));
        }

        mRecyclerView.setAdapter(snapAdapter);

    }

    private List<App> getApps(){
        List<App> apps = new ArrayList<>();
        apps.add(new App("SomeWhere", R.drawable.img_dalat_trip2));
        apps.add(new App("AnyWhere", R.drawable.img_dalat_trip3));
        apps.add(new App("Dalat", R.drawable.img_dalat_trip4));
        apps.add(new App("DaNang", R.drawable.img_dalat_trip5));
        apps.add(new App("HaNoi", R.drawable.img_dalat_trip6));

        return apps;
    }

    public void init(View view){
        image_banner = view.findViewById(R.id.image_banner);

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setHasFixedSize(true);
        ViewCompat.setNestedScrollingEnabled(mRecyclerView, false);



    }

    public void Handling(){
        image_banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.addToBackStack(BACK_STACK_TRAVEL);
                transaction.replace(R.id.layout_travel, new ItemTravelFragment(), BACK_STACK_TRAVEL);
                transaction.commit();
            }
        });
    }




}
