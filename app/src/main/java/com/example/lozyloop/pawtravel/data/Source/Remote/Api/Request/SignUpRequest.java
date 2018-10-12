package com.example.lozyloop.pawtravel.data.Source.Remote.Api.Request;

import com.example.lozyloop.pawtravel.data.Model.BaseModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignUpRequest extends BaseModel {

    @Expose
    @SerializedName("username")
    private String mUsername;

    @Expose
    @SerializedName("password")
    private String mPassword;

    @Expose
    @SerializedName("first_name")
    private String mFirst_name;

    @Expose
    @SerializedName("last_name")
    private String mLast_name;

    @Expose
    @SerializedName("email")
    private String mEmail;

    public SignUpRequest(String mUsername, String mPassword, String mFirst_name, String mLast_name, String mEmail) {
        this.mUsername = mUsername;
        this.mPassword = mPassword;
        this.mFirst_name = mFirst_name;
        this.mLast_name = mLast_name;
        this.mEmail = mEmail;
    }
}
