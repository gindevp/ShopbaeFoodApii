package com.example.shopbaefood.service;

import com.example.shopbaefood.model.dto.AccountToken;
import com.example.shopbaefood.model.dto.ApiResponse;
import com.example.shopbaefood.model.dto.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    @POST("login")
    Call<ApiResponse> login(@Body LoginResponse response);

    @POST("forgotpass")
    Call<ApiResponse> forgot(@Query("username") String username);

    @POST("forgotpass/confirm")
    Call<ApiResponse> confirmOtp(@Query("otp") String otp, @Query("pass") String pass, @Query("username") String username);
}
