package com.example.lozyloop.pawtravel.data.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Root {

    @Expose
    @SerializedName("name")
    private String mName;

    @Expose
    @SerializedName("title")
    private String mTitle;

    @Expose
    @SerializedName("short_description")
    private String mShort_description;

    @Expose
    @SerializedName("thumbnail")
    private String mThumbnail;

    @Expose
    @SerializedName("rate")
    private String mRate;

    @Expose
    @SerializedName("description")
    private String mDescription;

    @Expose
    @SerializedName("coffee_shops")
    private List<coffee_shops> coffeeShops = null;

    public Root(String mName, String mTitle, String mShort_description, String mThumbnail, String mRate, String mDescription, List<coffee_shops> mCoffee_shops) {
        this.mName = mName;
        this.mTitle = mTitle;
        this.mShort_description = mShort_description;
        this.mThumbnail = mThumbnail;
        this.mRate = mRate;
        this.mDescription = mDescription;
        this.coffeeShops = mCoffee_shops;
    }

    public Root() {
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmShort_description() {
        return mShort_description;
    }

    public void setmShort_description(String mShort_description) {
        this.mShort_description = mShort_description;
    }

    public String getmThumbnail() {
        return mThumbnail;
    }

    public void setmThumbnail(String mThumbnail) {
        this.mThumbnail = mThumbnail;
    }

    public String getmRate() {
        return mRate;
    }

    public void setmRate(String mRate) {
        this.mRate = mRate;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public List<coffee_shops> getmCoffee_shops() {
        return coffeeShops;
    }

    public void setmCoffee_shops(List<coffee_shops> mCoffee_shops) {
        this.coffeeShops = mCoffee_shops;
    }
}
