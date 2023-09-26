package com.example.shopbaefood.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shopbaefood.R;
import com.example.shopbaefood.model.dto.ApiResponse;
import com.example.shopbaefood.model.dto.LoginResponse;
import com.example.shopbaefood.service.ApiService;
import com.example.shopbaefood.util.Notification;
import com.example.shopbaefood.util.UtilApp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        intent= new Intent();
        loginClick();
        forgotClick();
        registerClick();

    }

    private void registerClick() {
        TextView register= findViewById(R.id.register);
        register.setOnClickListener(v->{
            intent.setClass(this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    private void forgotClick() {
        TextView forgotView= findViewById(R.id.forgotpass);
        forgotView.setOnClickListener(v->{
            EditText username= findViewById(R.id.username);
            intent.setClass(this,ForgotActivity.class);
            intent.putExtra("username",username.getText().toString());
            startActivity(intent);
        });
    }

    private void loginClick() {
        ApiService apiService = UtilApp.retrofitCF().create(ApiService.class);
        Button submit = findViewById(R.id.button);
        submit.setOnClickListener(v -> {
            EditText userName = findViewById(R.id.username);
            EditText passWord = findViewById(R.id.password);

            LoginResponse login = new LoginResponse();
            login.setUserName(userName.getText().toString());
            login.setPassword(passWord.getText().toString());

            Call<ApiResponse> call = apiService.login(login);
            call.enqueue(new Callback<ApiResponse>() {
                @Override
                public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                    if(response.isSuccessful()){
                        ApiResponse apiResponse = response.body();
                        if(apiResponse.getData()!=null){
                            Log.d("login",response.body().getData().toString());
                            Notification.showToast(v,"LoginSuccess");
                        }else {
                            Log.d("login",response.body().getMessage());
                            Notification.showToast(v,response.body().getMessage());
                        }

                    }else {
                        Log.d("login","sai");
                        Notification.showToast(v,"sai tk hoặc mk");
                    }


                }

                @Override
                public void onFailure(Call<ApiResponse> call, Throwable t) {
                    Log.d("t",t.getMessage().toString());
                    Log.d("login", "fail");
                    Notification.showToast(v,"server lỗi");
                }
            });
        });
    }
}