package com.example.lozyloop.pawtravel.data.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragments = new ArrayList<>();

    public Adapter(FragmentManager fm) {
        super(fm);
    }
    public void addFragment(Fragment fragment) {
        mFragments.add(fragment);

    }
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }
    @Override
    public int getCount() {
        return mFragments.size();
    }

}
