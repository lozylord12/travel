package com.example.lozyloop.pawtravel.data.Source.Remote.Api.ApiService;


import com.example.lozyloop.pawtravel.data.Model.Profile;
import com.example.lozyloop.pawtravel.data.Model.Root;
import com.example.lozyloop.pawtravel.data.Model.coffee_shops;
import com.example.lozyloop.pawtravel.data.Source.Remote.Api.Request.SignInRequest;
import com.example.lozyloop.pawtravel.data.Source.Remote.Api.Request.SignUpRequest;
import com.example.lozyloop.pawtravel.data.Source.Remote.Api.Response.LoginResponse;
import com.example.lozyloop.pawtravel.data.Source.Remote.Api.Response.LogoutResponse;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface Api {

    @Headers("Content-Type: application/json ")
    @POST("api/v1/authentication/sign_in/")
    Observable<LoginResponse> login(@Body SignInRequest signInRequest);

    @Headers("Content-Type: application/json ")
    @POST("api/v1/authentication/sign_up/")
    Observable<LoginResponse> create(@Body SignUpRequest signUpRequest);

    @Headers("Content-Type: application/json ")
    @GET("api/v1/authentication/sign_out/")
    Observable<LogoutResponse> Logout();

    @Headers("Content-Type: application/json ")
    @GET("bins/ns8k8/")
    Observable<List<coffee_shops>> getCoffeeShop();

    @Headers("Content-Type: application/json ")
    @GET("bins/kr5v4")
    Observable<Root> getTravelFragment();

    @Headers("Content-Type: application/json ")
    @GET("api/v1/auth/users/{id}/")
    Observable<Profile> getProfile(@Path("id") String id,
                             @Query("username") String username,
                             @Query("api_key") String api_key);







}
