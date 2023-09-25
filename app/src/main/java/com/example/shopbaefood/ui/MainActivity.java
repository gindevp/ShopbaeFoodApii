package com.example.shopbaefood.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shopbaefood.R;
import com.example.shopbaefood.model.dto.AccountToken;
import com.example.shopbaefood.model.dto.ApiResponse;
import com.example.shopbaefood.model.dto.LoginResponse;
import com.example.shopbaefood.service.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.52.218:8080/ShopbaeFoodApi/").addConverterFactory(GsonConverterFactory.create()).build();
    ApiService apiService = retrofit.create(ApiService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submit = findViewById(R.id.buttonLogin);
        submit.setOnClickListener(v -> {
            EditText userName = findViewById(R.id.username);
            EditText passWord = findViewById(R.id.password);

            LoginResponse login = new LoginResponse();
            login.setUserName(userName.getText().toString());
            login.setPassword(passWord.getText().toString());

            Call<ApiResponse> call = apiService.call(login);
            call.enqueue(new Callback<ApiResponse>() {
                @Override
                public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                    if(response.isSuccessful()){
                        ApiResponse apiResponse = response.body();
                        if(apiResponse.getData()!=null){
                            Log.d("login",response.body().getData().toString());
                            Toast.makeText(v.getContext(),"login success", Toast.LENGTH_SHORT).show();
                        }else {
                            Log.d("login",response.body().getMessage());
                            Toast.makeText(v.getContext(),response.body().getMessage(),Toast.LENGTH_SHORT).show();
                        }

                    }else {
                        Log.d("login","sai");
                    }


                }

                @Override
                public void onFailure(Call<ApiResponse> call, Throwable t) {
                    Log.d("t",t.getMessage().toString());
                    Log.d("login", "fail");
                }
            });
        });


    }
}