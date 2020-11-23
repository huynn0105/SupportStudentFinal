package com.example.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Adapter.SubjectMarkAdapter;
import com.example.Model.SubjectMarkInfo;
import com.example.Service.Request.RequestBody;
import com.example.Service.Request.RequestEnvelope;
import com.example.Service.Request.RequestModel;
import com.example.Service.Response.ResponseEnvelope;
import com.example.Service.RetrofitGenerator;
import com.example.quanlyhocsinh.R;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubjectMarkActivity extends AppCompatActivity {

    SubjectMarkAdapter adapter;
    RecyclerView rvSubjectMark;
    TextView tv_mark,tv_tinChi;
    Toolbar toolbar;
    LinearLayout layout_mark;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_mark);
        init();
        getDataIntent();



    }

    private void getDataIntent() {
        intent = getIntent();
        if(intent.hasExtra("SubjectMark")){
            String mssv = intent.getStringExtra("SubjectMark");
            getSubjectMark(mssv);
        }
    }

    private void init() {
        rvSubjectMark = findViewById(R.id.rvSubjectMark);
        layout_mark = findViewById(R.id.layout_mark);
        tv_mark = findViewById(R.id.tv_mark);
        tv_tinChi = findViewById(R.id.tv_tinChi);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Kết quả học tập");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.black));
        toolbar.setNavigationOnClickListener(view -> finish());
    }

    private void getSubjectMark(String studentCode) {
        final ProgressDialog progressDialog = new ProgressDialog(SubjectMarkActivity.this);
        progressDialog.setMessage("Đang kiểm tra..");
        progressDialog.show();

        RequestEnvelope requestEnvelop = new RequestEnvelope();
        RequestBody requestBody = new RequestBody();
        requestBody.GetSubjectMark = RequestModel.builder().studentCode(studentCode).build();
        requestEnvelop.setRequestBody(requestBody);
        Call<ResponseEnvelope> callback = RetrofitGenerator.getRetrofit().GetSubjectMark(requestEnvelop);
        callback.enqueue(new Callback<ResponseEnvelope>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<ResponseEnvelope> call, Response<ResponseEnvelope> response) {
                progressDialog.dismiss();
                layout_mark.setVisibility(View.VISIBLE);
                ResponseEnvelope responseEnvelope = response.body();
                if(responseEnvelope!=null){
                    List<SubjectMarkInfo> subjectMarkInfoList = responseEnvelope.responseBody.getSubjectMarkModel.resultSubjectMark;
                    adapter = new SubjectMarkAdapter(SubjectMarkActivity.this,subjectMarkInfoList);
                    rvSubjectMark.setHasFixedSize(true);
                    rvSubjectMark.setAdapter(adapter);
                    tv_mark.setText(sumMark(subjectMarkInfoList)+"");
                    tv_tinChi.setText(sumTinChi(subjectMarkInfoList)+ " tín chỉ");
                }
            }

            @Override
            public void onFailure(Call<ResponseEnvelope> call, Throwable t) {
                progressDialog.dismiss();
                Log.e("Dulieu",t.getMessage());
                Toast.makeText(SubjectMarkActivity.this, "Có lỗi xảy ra!!!\nKiểm tra kết nối và thử lại sau", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
    private float sumMark(List<SubjectMarkInfo> list){
        float sum=0.0f;
        int index=0;
        for (SubjectMarkInfo FinalSummary: list) {
            if(FinalSummary.getPassedText()!=null){
                sum += FinalSummary.getFinalSummary();
                index++;
            }
        }
        return (float) Math.round((sum/index)*100)/100;
    }
    private int sumTinChi(List<SubjectMarkInfo> list){
        int sum=0;
        for (SubjectMarkInfo subjectMarkInfo: list){
            sum+=subjectMarkInfo.getUnitText();
        }
        return sum;
    }

}