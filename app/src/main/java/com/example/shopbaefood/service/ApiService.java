package com.example.shopbaefood.service;

import com.example.shopbaefood.model.dto.AccountToken;
import com.example.shopbaefood.model.dto.ApiResponse;
import com.example.shopbaefood.model.dto.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("login")
    Call<ApiResponse> login(@Body LoginResponse response);
}
