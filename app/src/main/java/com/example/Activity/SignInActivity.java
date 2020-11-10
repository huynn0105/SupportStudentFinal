package com.example.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.quanlyhocsinh.R;

public class SignInActivity extends AppCompatActivity {
    Button btn_login,btn_dangky,btn_tracuu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        btn_dangky.setOnClickListener(view -> startActivity(new Intent(SignInActivity.this,SignUpActivity.class)));

        btn_tracuu.setOnClickListener(view -> startActivity(new Intent(SignInActivity.this,TraCuuHSTSActivity.class)));
    }

    private void init() {
        btn_login = findViewById(R.id.btn_login);
        btn_dangky = findViewById(R.id.btn_dangky);
        btn_tracuu = findViewById(R.id.btn_tracuu);
    }
}