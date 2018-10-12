package com.example.lozyloop.pawtravel.data.Source.Local;

import com.example.lozyloop.pawtravel.data.Source.AuthenticationDataSource;
import com.example.lozyloop.pawtravel.data.Source.Local.sharedprf.SharedPrefsApi;
import com.example.lozyloop.pawtravel.data.Source.Local.sharedprf.SharedPrefsKey;
import com.example.lozyloop.pawtravel.data.Source.Remote.Api.Response.LoginResponse;
import com.google.gson.Gson;

public class AuthenticationLocalDataSource implements AuthenticationDataSource.Local {

    private SharedPrefsApi mSharedPrefsApi;

    public AuthenticationLocalDataSource(SharedPrefsApi mSharedPrefsApi) {
        this.mSharedPrefsApi = mSharedPrefsApi;
    }

    @Override
    public LoginResponse getUser() {
        String data = mSharedPrefsApi.get(SharedPrefsKey.PREFERENCE_USER_KEY, String.class);
        return new Gson().fromJson(data, LoginResponse.class);
    }

    @Override
    public void saveUser(LoginResponse loginResponse) {
        String data = new Gson().toJson(loginResponse);
        mSharedPrefsApi.put(SharedPrefsKey.PREFERENCE_USER_KEY, data);
    }

    @Override
    public void deleteUser() {
        mSharedPrefsApi.delete(SharedPrefsKey.PREFERENCE_USER_KEY);
    }
}
