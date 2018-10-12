package com.example.lozyloop.pawtravel.data.Model;

public class App {

    private int mDrawable;
    private String mName;

    public App(String mName, int mDrawable) {
        this.mDrawable = mDrawable;
        this.mName = mName;
    }

    public int getmDrawable() {
        return mDrawable;
    }

    public void setmDrawable(int mDrawable) {
        this.mDrawable = mDrawable;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }
}
