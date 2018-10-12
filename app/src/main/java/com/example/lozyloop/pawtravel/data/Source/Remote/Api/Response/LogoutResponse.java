package com.example.lozyloop.pawtravel.data.Source.Remote.Api.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LogoutResponse {

    @Expose
    @SerializedName("success")
    private String success;

    public LogoutResponse(String success) {
        this.success = success;
    }

    public LogoutResponse() {
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
