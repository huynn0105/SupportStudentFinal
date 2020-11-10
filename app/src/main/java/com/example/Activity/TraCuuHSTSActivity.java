package com.example.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.Model.SpecialBranchInfo;
import com.example.Model.StudentCollectionInfo;
import com.example.Model.TrainingLevelInfo;
import com.example.Service.Request.RequestBody;
import com.example.Service.Request.RequestEnvelope;
import com.example.Service.Request.RequestModel;
import com.example.Service.Response.ResponseEnvelope;
import com.example.Service.RetrofitGenerator;
import com.example.quanlyhocsinh.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TraCuuHSTSActivity extends AppCompatActivity {

    Toolbar toolbar;
    Button btn_tracuu;
    EditText edt_fullName, edt_mshs;
    TextInputLayout input_fullName, input_mshs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tra_cuu_h_s_t_s);
        init();
        btn_tracuu.setOnClickListener(view -> {
            String keyword = edt_fullName.getText().toString().trim();
            String studentCollectionID = edt_mshs.getText().toString().trim();
            if (!keyword.isEmpty() && !studentCollectionID.isEmpty()) {
                getStudentCollection(Long.parseLong(studentCollectionID), keyword);
            } else {
                if (keyword.isEmpty()) input_fullName.setError("Không được bỏ trống");
                else input_fullName.setError("");

                if (studentCollectionID.isEmpty()) input_mshs.setError("Không được bỏ trống");
                else input_mshs.setError("");
            }
        });

    }


    public void getStudentCollection(long studentCollectionID, String keyWord) {
        RequestEnvelope requestEnvelop = new RequestEnvelope();
        RequestBody requestBody = new RequestBody();
        requestBody.GetStudentCollection = new RequestModel("", studentCollectionID, keyWord, "");
        requestEnvelop.setRequestBody(requestBody);
        Call<ResponseEnvelope> call = RetrofitGenerator.getRetrofit().GetStudentCollection(requestEnvelop);
        call.enqueue(new Callback<ResponseEnvelope>() {
            @Override
            public void onResponse(Call<ResponseEnvelope> call, Response<ResponseEnvelope> response) {
                ResponseEnvelope responseEnvelope = response.body();
                if (responseEnvelope != null) {
                    List<StudentCollectionInfo> studentCollectionInfo = responseEnvelope.responseBody.getStudentCollectionModel.resultStudentCollection;
                    if (studentCollectionInfo != null && studentCollectionInfo.size()!=0) {
                        Intent intent = new Intent(TraCuuHSTSActivity.this, StudentCollectionActivity.class);
                        intent.putExtra("Student", studentCollectionInfo.get(0));
                        startActivity(intent);
                    } else {
                        Toast.makeText(TraCuuHSTSActivity.this, "Mã hồ sơ hoặc tên không tồn tại", Toast.LENGTH_SHORT).show();
                    }
                }else Toast.makeText(TraCuuHSTSActivity.this, "Lỗi", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseEnvelope> call, Throwable t) {
                Log.e("TAG_Result", Objects.requireNonNull(t.getMessage()));
            }
        });
    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        btn_tracuu = findViewById(R.id.btn_tracuu);
        edt_fullName = findViewById(R.id.edt_fullName);
        edt_mshs = findViewById(R.id.edt_mshs);
        input_fullName = findViewById(R.id.input_fullName);
        input_mshs = findViewById(R.id.input_mshs);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Tra cứu hồ sơ tuyển sinh");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.black));
        toolbar.setNavigationOnClickListener(view -> finish());
    }
}