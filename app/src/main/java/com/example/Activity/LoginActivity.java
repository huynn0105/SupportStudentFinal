package com.example.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.Model.StudentInfo;
import com.example.Service.Request.RequestBody;
import com.example.Service.Request.RequestEnvelope;
import com.example.Service.Request.RequestModel;
import com.example.Service.Response.ResponseEnvelope;
import com.example.Service.RetrofitGenerator;
import com.example.quanlyhocsinh.R;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    Button btn_login, btn_dangky, btn_tracuu;
    TextInputLayout input_mssv, input_password;
    EditText edt_mssv, edt_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        btn_dangky.setOnClickListener(view -> startActivity(new Intent(LoginActivity.this, RegisterActivity.class)));
        btn_tracuu.setOnClickListener(view -> startActivity(new Intent(LoginActivity.this, TraCuuHSTSActivity.class)));
        btn_login.setOnClickListener(view -> {
            String mssv = edt_mssv.getText().toString().trim();
            String password = edt_password.getText().toString().trim();
            boolean isValid = validateForm(mssv, password);
            if (isValid) {
                login(mssv, password);
            }

        });

    }

    private void login(String mssv, String password) {
        RequestEnvelope requestEnvelop = new RequestEnvelope();
        RequestBody requestBody = new RequestBody();
        requestBody.LoginStudent = RequestModel.builder().loginName(mssv).password(password).build();
        requestEnvelop.setRequestBody(requestBody);
        Call<ResponseEnvelope> callback = RetrofitGenerator.getRetrofit().LoginStudent(requestEnvelop);
        callback.enqueue(new Callback<ResponseEnvelope>() {
            @Override
            public void onResponse(Call<ResponseEnvelope> call, Response<ResponseEnvelope> response) {
                ResponseEnvelope responseEnvelope = response.body();
                if (responseEnvelope != null) {
                    StudentInfo studentInfo = responseEnvelope.responseBody.getLoginStudentModel.resultLoginStudent;
                    if (studentInfo != null) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("Login",studentInfo);
                        intent.putExtra("mssv",mssv);
                        startActivity(intent);
                        finish();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseEnvelope> call, Throwable t) {

            }
        });
    }

    private boolean validateForm(String mssv, String password) {
        if (mssv.isEmpty())
            input_mssv.setError("Không được bỏ trống!!!");
        else input_mssv.setError("");
        if (password.isEmpty())
            input_password.setError("Không được bỏ trống!!!");
        else input_password.setError("");

        return !mssv.isEmpty()
                && !password.isEmpty();

    }

    private void init() {
        btn_login = findViewById(R.id.btn_login);
        btn_dangky = findViewById(R.id.btn_dangky);
        btn_tracuu = findViewById(R.id.btn_tracuu);
        input_mssv = findViewById(R.id.input_mssv);
        input_password = findViewById(R.id.input_password);
        edt_mssv = findViewById(R.id.edt_mssv);
        edt_password = findViewById(R.id.edt_password);
    }
}