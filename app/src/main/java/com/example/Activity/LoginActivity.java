package com.example.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.quanlyhocsinh.R;

public class LoginActivity extends AppCompatActivity {
    Button btn_login,btn_dangky;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        btn_dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,SignupActivity.class));
            }
        });
    }

    private void init() {
        btn_login = findViewById(R.id.btn_login);
        btn_dangky = findViewById(R.id.btn_dangky);
    }
}