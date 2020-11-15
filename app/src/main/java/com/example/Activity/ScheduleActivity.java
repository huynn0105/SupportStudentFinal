package com.example.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.Model.ScheduleInfo;
import com.example.Model.StudentInfo;
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

public class ScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        getSchedule("15.02.05.01.25",2020,1);
    }

    private void getSchedule(String studentCode, int yearID,int semester ) {
        RequestEnvelope requestEnvelop = new RequestEnvelope();
        RequestBody requestBody = new RequestBody();
        requestBody.GetSchedule = RequestModel.builder().studentCode(studentCode).yearID(yearID).semester(semester).build();
        requestEnvelop.setRequestBody(requestBody);
        Call<ResponseEnvelope> callback = RetrofitGenerator.getRetrofit().GetSchedule(requestEnvelop);
        callback.enqueue(new Callback<ResponseEnvelope>() {
            @Override
            public void onResponse(Call<ResponseEnvelope> call, Response<ResponseEnvelope> response) {
                ResponseEnvelope responseEnvelope = response.body();
                if(responseEnvelope!=null){
                    List<ScheduleInfo> scheduleInfoList = responseEnvelope.responseBody.getScheduleModel.resultSchedule;
                    Log.d("dulieu",scheduleInfoList.get(0).toString());
                }
            }

            @Override
            public void onFailure(Call<ResponseEnvelope> call, Throwable t) {
                Log.e("Dulieu",t.getMessage());
            }
        });
    }

}