package com.example.lozyloop.pawtravel.Screen.Handle;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.lozyloop.pawtravel.R;
import com.example.lozyloop.pawtravel.Screen.Handle.Chatbox.ChatboxFragment;
import com.example.lozyloop.pawtravel.Screen.Handle.Flight.FlightFragment;
import com.example.lozyloop.pawtravel.Screen.Handle.Hotel.HotelFragment;
import com.example.lozyloop.pawtravel.Screen.Handle.Profile.ProfileFragment;
import com.example.lozyloop.pawtravel.Screen.Handle.Travel.TravelFragment;
import com.example.lozyloop.pawtravel.Utils.BottomNavigationViewHelper;
import com.example.lozyloop.pawtravel.data.Adapter.Adapter;

import static com.example.lozyloop.pawtravel.Screen.Handle.Hotel.HotelFragment.BACK_STACK_HOTEL;
import static com.example.lozyloop.pawtravel.Screen.Handle.Travel.TravelFragment.BACK_STACK_TRAVEL;
import static com.example.lozyloop.pawtravel.Screen.ItemHotel.ItemHotelFragment.BACK_STACK_ItemHotel;
import static com.example.lozyloop.pawtravel.Screen.ItemHotel.itemRateFragment.BACK_STACK_ItemRate;

public class TravelActivity extends AppCompatActivity {

    BottomNavigationView nav_view;
    ViewPager fragment_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);

        init();
        BottomNavigationViewHelper.disableShiftMode(nav_view);
        setOnClickNavigation();
    }

    public void init() {
        nav_view = findViewById(R.id.nav_view);
        fragment_container = findViewById(R.id.fragment_container);
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(new TravelFragment());
        adapter.addFragment(new FlightFragment());
        adapter.addFragment(new ChatboxFragment());
        adapter.addFragment(new HotelFragment());
        adapter.addFragment(new ProfileFragment());
        fragment_container.setAdapter(adapter);
        fragment_container.setOffscreenPageLimit(4);
    }

    public void setOnClickNavigation() {
        nav_view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()) {
                    case R.id.nav_travel:
                        fragment_container.setCurrentItem(0);
                        break;

                    case R.id.nav_flight:
                        fragment_container.setCurrentItem(1);
                        break;

                    case R.id.nav_chatbox:
                        fragment_container.setCurrentItem(2);
                        break;

                    case R.id.nav_hotel:
                        fragment_container.setCurrentItem(3);
                        break;

                    case R.id.nav_profile:
                        fragment_container.setCurrentItem(4);
                        break;

                }


                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        switch (nav_view.getSelectedItemId()){

            case R.id.nav_travel:
                for (int i = 0; i <getSupportFragmentManager().getBackStackEntryCount(); i++){

                    if (getSupportFragmentManager().getBackStackEntryAt(i).getName().equals(BACK_STACK_TRAVEL)){
                        getSupportFragmentManager().popBackStack(BACK_STACK_TRAVEL, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                        return;
                    }
                }

            case R.id.nav_hotel:
                int count = getSupportFragmentManager().getBackStackEntryCount() - 1;
                for (int i = count; i > 0; i--){

                    if (getSupportFragmentManager().getBackStackEntryAt(i).getName().equals(BACK_STACK_ItemRate)){
                        getSupportFragmentManager().popBackStack(BACK_STACK_ItemRate, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                        return;
                    }
                    else if (getSupportFragmentManager().getBackStackEntryAt(i).getName().equals(BACK_STACK_ItemHotel)){
                        getSupportFragmentManager().popBackStack(BACK_STACK_ItemHotel, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                        return;
                    }
                   else if (getSupportFragmentManager().getBackStackEntryAt(i).getName().equals(BACK_STACK_HOTEL)){
                       getSupportFragmentManager().popBackStack(BACK_STACK_HOTEL, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                       return;
                    }
                }

        }
        getSupportFragmentManager().popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE);
        super.onBackPressed();
    }
}
