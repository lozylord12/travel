package com.example.lozyloop.pawtravel.data.Source.Remote.Api;

import com.example.lozyloop.pawtravel.data.Source.Remote.Api.ApiService.Api;
import com.example.lozyloop.pawtravel.data.Source.Remote.Api.ApiService.BooleanAdapter;
import com.example.lozyloop.pawtravel.data.Source.Remote.Api.ApiService.IntegerAdapter;
import com.example.lozyloop.pawtravel.data.Source.Remote.Api.Middleware.ScalarsConverterFactory;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static Retrofit ourInstance;
    public static Retrofit ourInstance1;

    public static Retrofit getGetInstance(){
        if (ourInstance == null)
            ourInstance = new Retrofit.Builder()
                    .baseUrl("https://paw-travel.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

        return ourInstance;
    }

    public RetrofitClient(){

    }

    public Api provideNameApi(Retrofit retrofit){
        return retrofit.create(Api.class);
    }

    public static Gson provideGson() {
        BooleanAdapter booleanAdapter = new BooleanAdapter();
        IntegerAdapter integerAdapter = new IntegerAdapter();
        return new GsonBuilder().registerTypeAdapter(Boolean.class, booleanAdapter)
                .registerTypeAdapter(boolean.class, booleanAdapter)
                .registerTypeAdapter(Integer.class, integerAdapter)
                .registerTypeAdapter(int.class, integerAdapter)
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .excludeFieldsWithoutExposeAnnotation()
                .create();
    }



    public static Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl("http://paw-travel.herokuapp.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    public static OkHttpClient provideOkHttp(){
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        return httpClientBuilder.build();

    }

    public static Retrofit getGetInstanceFake(){
        if (ourInstance1 == null)
            ourInstance1 = new Retrofit.Builder()
                    .baseUrl("https://api.myjson.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

        return ourInstance1;
    }


}
