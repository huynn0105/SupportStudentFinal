package com.example.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.Adapter.ScheduleAdapter;
import com.example.Model.ScheduleInfo;
import com.example.Service.Request.RequestBody;
import com.example.Service.Request.RequestEnvelope;
import com.example.Service.Request.RequestModel;
import com.example.Service.Response.ResponseEnvelope;
import com.example.Service.RetrofitGenerator;
import com.example.quanlyhocsinh.R;
import org.joda.time.DateTime;
import org.joda.time.Weeks;
import org.joda.time.format.DateTimeFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScheduleActivity extends AppCompatActivity {
    List<ScheduleInfo> scheduleInfoList;
    RecyclerView[] rv_schedule = new RecyclerView[9];
    LinearLayout layout_schedule;
    TextView notFound;
    String [] week;
    RelativeLayout[] rl = new RelativeLayout[9];
    AutoCompleteTextView dropdown_week;
    Intent intent;
    Toolbar toolbar;
    DateTime dateTime;
    String mssv;
    int year, semester;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        init();
        dateTime = DateTime.now();
        year = dateTime.getYear();
        semester = 0;
        if (dateTime.getMonthOfYear() >= 8)
            semester = 1;
        else semester = 2;

        getDataIntent();
        week = getResources().getStringArray(R.array.week);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_expandable_list_item_1, week);
        dropdown_week.setAdapter(adapter);
        dropdown_week.setOnItemClickListener((adapterView, view, i, l) -> {
            String wk= adapterView.getAdapter().getItem(i).toString();
            dropdown_week.setText(wk,false);
            setScheduleWeek(Integer.parseInt(wk));

        });




    }

    private void getDataIntent() {
        intent = getIntent();
        if (intent.hasExtra("Schedule")) {
            mssv = intent.getStringExtra("Schedule");
            if (semester != 0) {
                getSchedule(mssv, year, semester);
            } else {
                Toast.makeText(this, "Có lỗi xảy ra!!!\nThử lại sau", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void init() {
        rv_schedule[2] = findViewById(R.id.rv_schedule2);
        rv_schedule[3] = findViewById(R.id.rv_schedule3);
        rv_schedule[4] = findViewById(R.id.rv_schedule4);
        rv_schedule[5] = findViewById(R.id.rv_schedule5);
        rv_schedule[6] = findViewById(R.id.rv_schedule6);
        rv_schedule[7] = findViewById(R.id.rv_schedule7);
        rv_schedule[8] = findViewById(R.id.rv_schedule8);
        dropdown_week = findViewById(R.id.dropdown_week);
        layout_schedule = findViewById(R.id.layout_schedule);
        notFound = findViewById(R.id.notFound);
        rl[2] = findViewById(R.id.rl2);
        rl[3] = findViewById(R.id.rl3);
        rl[4] = findViewById(R.id.rl4);
        rl[5] = findViewById(R.id.rl5);
        rl[6] = findViewById(R.id.rl6);
        rl[7] = findViewById(R.id.rl7);
        rl[8] = findViewById(R.id.rl8);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Lịch học");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.black));
        toolbar.setNavigationOnClickListener(view -> finish());


    }

    private void getSchedule(String studentCode, int yearID, int semester) {
        final ProgressDialog progressDialog = new ProgressDialog(ScheduleActivity.this);
        progressDialog.setMessage("Đang kiểm tra..");
        progressDialog.show();

        RequestEnvelope requestEnvelop = new RequestEnvelope();
        RequestBody requestBody = new RequestBody();
        requestBody.GetSchedule = RequestModel.builder().studentCode(studentCode).yearID(yearID).semester(semester).build();
        requestEnvelop.setRequestBody(requestBody);
        Call<ResponseEnvelope> callback = RetrofitGenerator.getRetrofit().GetSchedule(requestEnvelop);
        callback.enqueue(new Callback<ResponseEnvelope>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<ResponseEnvelope> call, Response<ResponseEnvelope> response) {
                progressDialog.dismiss();
                ResponseEnvelope responseEnvelope = response.body();
                if (responseEnvelope != null) {
                    scheduleInfoList = responseEnvelope.responseBody.getScheduleModel.resultSchedule;
                    if (scheduleInfoList.size() > 0) {
                        layout_schedule.setVisibility(View.VISIBLE);
                        notFound.setVisibility(View.GONE);
                        dropdown_week.setText(getWeekNum(scheduleInfoList.get(0))+"",false);
                        setScheduleWeek(getWeekNum(scheduleInfoList.get(0)));


                    } else {
                        notFound.setVisibility(View.VISIBLE);
                        layout_schedule.setVisibility(View.GONE);
                    }
                } else {
                    Toast.makeText(ScheduleActivity.this, "Có lỗi xảy ra!!!\nThử lại sau", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseEnvelope> call, Throwable t) {
                progressDialog.dismiss();
                Log.e("Dulieu", t.getMessage());
                Toast.makeText(ScheduleActivity.this, "Có lỗi xảy ra!!!\nKiểm tra kết nối và thử lại sau", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
    private void setScheduleWeek(int week){
        List<ScheduleInfo>[] lists = new List[9];
        ScheduleAdapter[] adapter = new ScheduleAdapter[9];
        for (int i = 2; i <= 8; i++) {
            lists[i] = new ArrayList<>();
            for (ScheduleInfo info : scheduleInfoList) {
                if (info.getDayText() == i) {
                    if (week >= info.getStartWeek() && week <= info.getEndWeek()) {
                        lists[i].add(info);
                    }
                }
            }
            adapter[i] = new ScheduleAdapter(ScheduleActivity.this, lists[i]);
        }

        for(int i =2;i<=8;i++)
            rv_schedule[i].setAdapter(adapter[i]);

        setViewDay(scheduleInfoList.get(0));
    }

    @SuppressLint("SetTextI18n")
    public int getWeekNum(ScheduleInfo info) {
        int weeks = info.getStartWeek();
        DateTime dateTime1 = DateTime.parse(info.getStartDate(),
                DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss"));
        dateTime = DateTime.now();

        weeks += Weeks.weeksBetween(dateTime1, dateTime).getWeeks();
        return weeks;

    }

    @SuppressLint("SetTextI18n")
    public void setViewDay(ScheduleInfo info) {
        String dayOfWeek;
        int day = dateTime.getDayOfWeek()+1;
        if(dropdown_week.getText().toString().equals(getWeekNum(info)+"")){
            rl[day].setBackgroundColor(Color.parseColor("#f68084"));
        }else{
            rl[day].setBackgroundColor(Color.parseColor("#94bdff"));
        }
    }


}