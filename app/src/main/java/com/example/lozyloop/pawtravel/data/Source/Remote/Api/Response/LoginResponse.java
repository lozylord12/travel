package com.example.lozyloop.pawtravel.data.Source.Remote.Api.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @Expose
    @SerializedName("api_key")
    private String api_key;

    @Expose
    @SerializedName("id")
    private int id;

    @Expose
    @SerializedName("success")
    private String success;

    @Expose
    @SerializedName("username")
    private String username;

    public LoginResponse(String api_key, int id, String success, String username) {
        this.api_key = api_key;
        this.id = id;
        this.success = success;
        this.username = username;
    }

    public LoginResponse() {
    }

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
