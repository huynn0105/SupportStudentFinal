package com.example.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.Model.StudentInfo;
import com.example.Model.SubjectMarkInfo;
import com.example.Service.Request.RequestBody;
import com.example.Service.Request.RequestEnvelope;
import com.example.Service.Request.RequestModel;
import com.example.Service.Response.ResponseEnvelope;
import com.example.Service.RetrofitGenerator;
import com.example.quanlyhocsinh.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubjectMarkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_mark);
        getSubjectMark("15.02.05.01.25");

    }
    private void getSubjectMark(String studentCode) {
        RequestEnvelope requestEnvelop = new RequestEnvelope();
        RequestBody requestBody = new RequestBody();
        requestBody.GetSubjectMark = RequestModel.builder().studentCode(studentCode).build();
        requestEnvelop.setRequestBody(requestBody);
        Call<ResponseEnvelope> callback = RetrofitGenerator.getRetrofit().GetSubjectMark(requestEnvelop);
        callback.enqueue(new Callback<ResponseEnvelope>() {
            @Override
            public void onResponse(Call<ResponseEnvelope> call, Response<ResponseEnvelope> response) {
                ResponseEnvelope responseEnvelope = response.body();
                if(responseEnvelope!=null){
                    List<SubjectMarkInfo> subjectMarkInfoList = responseEnvelope.responseBody.getSubjectMarkModel.resultSubjectMark;
                    Log.d("dulieu",subjectMarkInfoList.get(0).toString());
                }
            }

            @Override
            public void onFailure(Call<ResponseEnvelope> call, Throwable t) {
                Log.e("Dulieu",t.getMessage());
            }
        });
    }
}