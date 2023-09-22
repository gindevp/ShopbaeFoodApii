package com.example.shopbaefood.service;

import com.example.shopbaefood.model.dto.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @POST("login")
    Call<String> call(@Body LoginResponse response);
}
