package com.example.lozyloop.pawtravel.Screen.Handle;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.lozyloop.pawtravel.R;

public class TravelActivity extends AppCompatActivity {

    BottomNavigationView nav_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);

        init();
        BottomNavigationViewHelper.disableShiftMode(nav_view);
        setOnClickNavigation();
    }

    public void init(){
        nav_view = findViewById(R.id.nav_view);
    }

    public void setOnClickNavigation(){
        nav_view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()){
                    case R.id.nav_travel:
                        selectedFragment = new TravelFragment();
                        break;

                    case R.id.nav_flight:
                        selectedFragment = new FlightFragment();
                        break;

                    case R.id.nav_chatbox:
                        selectedFragment = new ChatboxFragment();
                        break;

                    case R.id.nav_hotel:
                        selectedFragment = new HotelFragment();
                        break;

                    case R.id.nav_profile:
                        selectedFragment = new ProfileFragment();
                        break;

                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                return true;
            }
        });
    }
}
