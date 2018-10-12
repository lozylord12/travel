package com.example.lozyloop.pawtravel.data.Source.Remote.Api.Request;

import com.example.lozyloop.pawtravel.data.Model.BaseModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignInRequest extends BaseModel {
    @Expose
    @SerializedName("username")
    private String mUsername;
    @Expose
    @SerializedName("password")
    private String mPassword;

    public SignInRequest(String mUsername, String mPassword) {
        this.mUsername = mUsername;
        this.mPassword = mPassword;
    }
}
