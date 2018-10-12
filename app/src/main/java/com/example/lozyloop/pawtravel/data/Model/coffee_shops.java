package com.example.lozyloop.pawtravel.data.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class coffee_shops {

    @Expose
    @SerializedName("name")
    private String mName;

    @Expose
    @SerializedName("image")
    private String mImage;

    public coffee_shops(String mName, String mImage) {
        this.mName = mName;
        this.mImage = mImage;
    }

    public coffee_shops() {
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmImage() {
        return mImage;
    }

    public void setmImame(String mImamge) {
        this.mImage = mImage;
    }
}
