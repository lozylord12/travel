package com.example.lozyloop.pawtravel.data.Source.Remote.Api.Error;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignUpError {

    @Expose
    @SerializedName("error")
    private String mError;

    public String getmError() {
        return mError;
    }

    public void setmError(String mError) {
        this.mError = mError;
    }

    public SignUpError(String mError) {
        this.mError = mError;
    }

    public SignUpError() {
    }
}
