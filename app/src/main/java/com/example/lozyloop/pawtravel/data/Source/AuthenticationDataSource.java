package com.example.lozyloop.pawtravel.data.Source;



import com.example.lozyloop.pawtravel.data.Model.Profile;
import com.example.lozyloop.pawtravel.data.Model.Root;
import com.example.lozyloop.pawtravel.data.Model.coffee_shops;
import com.example.lozyloop.pawtravel.data.Source.Remote.Api.Response.LoginResponse;
import com.example.lozyloop.pawtravel.data.Source.Remote.Api.Response.LogoutResponse;

import java.util.List;

import io.reactivex.Observable;


public interface AuthenticationDataSource {

    interface Local{
        LoginResponse getUser();

        void saveUser(LoginResponse loginResponse);

        void deleteUser();
    }

    interface Remote{

        Observable<LoginResponse> login(String username, String password);
        Observable<LoginResponse> create(String username, String password, String first_name, String last_name, String email);
        Observable<LogoutResponse> Logout();
        Observable<List<coffee_shops>> getCoffeeShop();
        Observable<Root> getTravelFragment();
        Observable<Profile> getProfile(String id, String username, String api_key);

    }
}
