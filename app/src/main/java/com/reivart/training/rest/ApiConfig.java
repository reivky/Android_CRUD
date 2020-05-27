package com.reivart.training.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfig {
    public static ApiService getApiService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reivky.000webhostapp.com/lesKohDerry/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiService.class);
    }
}