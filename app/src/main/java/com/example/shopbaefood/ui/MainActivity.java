package com.example.shopbaefood.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.shopbaefood.R;
import com.example.shopbaefood.model.dto.LoginResponse;
import com.example.shopbaefood.service.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {

    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://192.168.52.218:8443/ShopbaeFoodApi/").build();
    ApiService apiService= retrofit.create(ApiService.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submit= findViewById(R.id.buttonLogin);
        submit.setOnClickListener(v -> {
            EditText userName= findViewById(R.id.username);
            EditText passWord= findViewById(R.id.password);

            LoginResponse login= new LoginResponse();
            login.setUserName(userName.getText().toString());
            login.setPassword(userName.getText().toString());

            Call<String> call= apiService.call(login);
            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    Log.d("login",response.body().toString());
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {

                }
            });
        });


    }
}