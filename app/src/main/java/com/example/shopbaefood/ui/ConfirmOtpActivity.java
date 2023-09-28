package com.example.shopbaefood.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shopbaefood.R;

public class ConfirmOtpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_otp);

        Resources resources= getResources();
        EditText editOtp=findViewById(R.id.username);
        Button send = findViewById(R.id.send); // Thay thế "my_button" bằng ID của nút của bạn
        TextView count= findViewById(R.id.count);
        count.setTextColor(resources.getColor(R.color.blue));
        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hiển thị số đếm ngược ban đầu (15)
                count.setText("Gửi lại(15)");
                count.setEnabled(false);
                count.setTextColor(resources.getColor(R.color.blueClicked));
                // Tạo một đối tượng Handler
                Handler handler = new Handler();

                // Tạo một Runnable để đếm ngược trong 15 giây
                Runnable runnable = new Runnable() {
                    int countdown = 15;
                    @Override
                    public void run() {

                        countdown--;
                        count.setText("Gửi lại("+String.valueOf(countdown)+")");
                        if (countdown == 0) {
                            // Khi số đếm ngược đạt 0, hiển thị lại nút và ẩn TextView
                            count.setEnabled(true);
                            count.setTextColor(resources.getColor(R.color.blue));
                            count.setText("Gửi lại OTP");
                        } else {
                            // Nếu số đếm ngược chưa đạt 0, đặt lịch chạy lại sau 1 giây
                            handler.postDelayed(this, 1000); // 1000 milliseconds = 1 giây
                        }
                    }
                };
                // Đặt Runnable để chạy sau 15 giây
                handler.postDelayed(runnable, 0); // 15000 milliseconds = 15 giây
            }
        });
    }
}