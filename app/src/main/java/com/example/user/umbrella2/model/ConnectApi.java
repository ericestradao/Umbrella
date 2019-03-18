package com.example.user.umbrella2.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConnectApi {
    final String BASE_URL = "https://samples.openweathermap.org/data/2.5/";
    private Retrofit retrofit;
    static private ConnectApi instance;

    public static ConnectApi getInstance(){
        if(instance == null)
            instance = new ConnectApi();
        return instance;
    }

    public Retrofit initRetrofit() {
        Gson gson = new GsonBuilder().
                setLenient()
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit;
    }
}
