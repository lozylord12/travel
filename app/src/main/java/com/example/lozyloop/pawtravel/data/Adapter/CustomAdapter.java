package com.example.lozyloop.pawtravel.data.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lozyloop.pawtravel.R;

public class CustomAdapter extends PagerAdapter {

    private int[] imgs = {R.drawable.img_dalat_tour1,
            R.drawable.img_dalat_tour2,
            R.drawable.img_dalat_tour3,
            R.drawable.img_dalat_tour4,
            R.drawable.ic_travel3,
            R.drawable.ic_travel4};

    private LayoutInflater inflater;
    private Context ctx;

    public CustomAdapter(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.swipe_hotel, container, false);
        ImageView img = (ImageView) v.findViewById(R.id.image_slide_hotel);
        img.setImageResource(imgs[position]);
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.invalidate();
    }
}
