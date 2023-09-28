package com.example.shopbaefood.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shopbaefood.R;

import java.util.concurrent.atomic.AtomicInteger;

public class ForgotActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot);

        Button send= findViewById(R.id.send);
        send.setOnClickListener(view -> {
            Intent intent= new Intent(ForgotActivity.this,ConfirmOtpActivity.class);
            startActivity(intent);
        });
    }
}