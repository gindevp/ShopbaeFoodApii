package com.example.shopbaefood.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.shopbaefood.R;
import com.example.shopbaefood.model.dto.AccountToken;
import com.example.shopbaefood.util.Notification;
import com.google.gson.Gson;

public class HomeActivity extends AppCompatActivity {
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_MERCHANT = "ROLE_MERCHANT";
    private String token;
    private String role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        SharedPreferences info = getSharedPreferences("info", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        AccountToken accountToken = gson.fromJson(info.getString("info", ""), AccountToken.class);
        token = accountToken.getToken();
        role = accountToken.getRoles()[0];
        Log.d("role", role);
        if (role.equals(ROLE_ADMIN)) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_nav_home, new NavAdminFragment())
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_nav_home,new NavUserFragment()).commit();
        }
    }

    @Override
    public void onBackPressed() {
        Notification.showToast(new View(this),"bạn đã đăng nhập, cần đăng xuất để login lại");

    }
}