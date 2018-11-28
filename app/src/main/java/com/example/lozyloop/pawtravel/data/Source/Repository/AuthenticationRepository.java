package com.example.lozyloop.pawtravel.data.Source.Repository;


import com.example.lozyloop.pawtravel.data.Model.Profile;
import com.example.lozyloop.pawtravel.data.Model.Root;
import com.example.lozyloop.pawtravel.data.Model.coffee_shops;
import com.example.lozyloop.pawtravel.data.Source.AuthenticationDataSource;
import com.example.lozyloop.pawtravel.data.Source.Remote.Api.Response.LoginResponse;
import com.example.lozyloop.pawtravel.data.Source.Remote.Api.Response.LogoutResponse;

import java.util.List;

import io.reactivex.Observable;


public class AuthenticationRepository {

    private AuthenticationDataSource.Local mLocal;
    private AuthenticationDataSource.Remote mRemote;

    public AuthenticationRepository(AuthenticationDataSource.Local mLocal,
                                    AuthenticationDataSource.Remote mRemote) {
        this.mLocal = mLocal;
        this.mRemote = mRemote;
    }

    public Observable<LoginResponse> loginToServer(String username, String password){
        return mRemote.login(username, password);
    }

    public Observable<LoginResponse> CreateToServer(String username, String password, String first_name, String last_name, String email){
        return mRemote.create(username,password,first_name,last_name,email);
    }

    public Observable<LogoutResponse> Logout(){
        return mRemote.Logout();
    }

    public Observable<List<coffee_shops>> getCoffeeShop(){
        return mRemote.getCoffeeShop();
    }

    public Observable<Root> getTravelFragment(){
        return mRemote.getTravelFragment();
    }

    public Observable<Profile> getProfile(String id, String username, String api_key){
        return mRemote.getProfile(id,username,api_key);
    }


    public LoginResponse getLocalUser(){
        return mLocal.getUser();
    }

    public void saveUserToLocal(LoginResponse loginResponse){
        mLocal.saveUser(loginResponse);
    }

    public void deleteUser(){
        mLocal.deleteUser();
    }
}
