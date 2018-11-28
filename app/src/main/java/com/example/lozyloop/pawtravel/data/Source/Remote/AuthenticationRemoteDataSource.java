package com.example.lozyloop.pawtravel.data.Source.Remote;

import com.example.lozyloop.pawtravel.data.Model.Profile;
import com.example.lozyloop.pawtravel.data.Model.Root;
import com.example.lozyloop.pawtravel.data.Model.coffee_shops;
import com.example.lozyloop.pawtravel.data.Source.AuthenticationDataSource;
import com.example.lozyloop.pawtravel.data.Source.Remote.Api.ApiService.Api;
import com.example.lozyloop.pawtravel.data.Source.Remote.Api.Request.SignInRequest;
import com.example.lozyloop.pawtravel.data.Source.Remote.Api.Request.SignUpRequest;
import com.example.lozyloop.pawtravel.data.Source.Remote.Api.Response.LoginResponse;
import com.example.lozyloop.pawtravel.data.Source.Remote.Api.Response.LogoutResponse;

import java.util.List;

import io.reactivex.Observable;

public class AuthenticationRemoteDataSource implements AuthenticationDataSource.Remote {

    private Api mApiService;

    public AuthenticationRemoteDataSource(Api mApiService) {
        this.mApiService = mApiService;
    }

    @Override
    public Observable<LoginResponse> login(String username, String password) {
        return mApiService.login(new SignInRequest(username, password));
    }

    @Override
    public Observable<LoginResponse> create(String username, String password, String first_name, String last_name, String email) {
        return mApiService.create(new SignUpRequest(username,password,first_name,last_name,email));
    }

    @Override
    public Observable<LogoutResponse> Logout() {
        return mApiService.Logout();
    }

    @Override
    public Observable<List<coffee_shops>> getCoffeeShop() {
        return mApiService.getCoffeeShop();
    }

    @Override
    public Observable<Root> getTravelFragment() {
        return mApiService.getTravelFragment();
    }

    @Override
    public Observable<Profile> getProfile(String id, String username, String api_key) {
        return mApiService.getProfile(id,username,api_key);
    }
}
