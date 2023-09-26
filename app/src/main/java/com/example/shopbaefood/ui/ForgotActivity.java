package com.example.shopbaefood.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.example.shopbaefood.R;

public class ForgotActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot);

        Button myButton = findViewById(R.id.button); // Thay thế "my_button" bằng ID của nút của bạn

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ẩn nút sau khi được ấn
                myButton.setVisibility(View.INVISIBLE);

                // Tạo một đối tượng Handler
                Handler handler = new Handler();

                // Tạo một Runnable để đếm ngược trong 15 giây
                Runnable runnable = () -> {
                    // Hiển thị nút lại sau khi đếm ngược
                    myButton.setVisibility(View.VISIBLE);
                };

                // Đặt Runnable để chạy sau 15 giây
                handler.postDelayed(runnable, 15000); // 15000 milliseconds = 15 giây
            }
        });
    }
}