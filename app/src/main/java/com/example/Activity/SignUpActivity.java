package com.example.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import com.example.Model.LearningLevelInfo;
import com.example.Model.SpecialBranchInfo;
import com.example.Model.TrainingLevelInfo;
import com.example.Service.Request.RequestBody;
import com.example.Service.Request.RequestEnvelope;
import com.example.Service.Request.RequestModel;
import com.example.Service.Response.ResponseEnvelope;
import com.example.Service.RetrofitGenerator;
import com.example.quanlyhocsinh.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
    final String TAG = "Response";
    Calendar date;
    EditText edt_date;
    TextInputLayout input_date;
    Toolbar toolbar;
    TextView tv_web_link;
    String tempName ="";
    AutoCompleteTextView edt_TrainingLv, edt_LearningLv, edt_SpecialBranch;
    List<SpecialBranchInfo> specialBranchInfoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        init();
        getLearningLevel();
        String[] sex = getResources().getStringArray(R.array.Sex);
        AutoCompleteTextView editText = findViewById(R.id.dropdown_sex);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_expandable_list_item_1, sex);
        editText.setAdapter(adapter);


    }


    public void getLearningLevel() {
        RequestEnvelope requestEnvelop = new RequestEnvelope();
        RequestBody requestBody = new RequestBody();
        RequestModel requestModel = new RequestModel();
        requestModel.partnerIdentity = "";
        requestModel.signature = "";
        requestBody.GetLearningLevel = requestModel;
        requestEnvelop.setRequestBody(requestBody);

        Call<ResponseEnvelope> call = RetrofitGenerator.getRetrofit().GetLearningLevel(requestEnvelop);
        call.enqueue(new Callback<ResponseEnvelope>() {
            @Override
            public void onResponse(Call<ResponseEnvelope> call, Response<ResponseEnvelope> response) {
                ResponseEnvelope responseEnvelope = response.body();
                if (responseEnvelope != null) {
                    List<LearningLevelInfo> list = responseEnvelope.responseBody.getLearningLevelModel.resultLearningLevel;
                    if (list.size() != 0) {
                        ArrayAdapter<LearningLevelInfo> adapter = new ArrayAdapter(SignUpActivity.this, android.R.layout.simple_expandable_list_item_1, list);
                        edt_LearningLv.setAdapter(adapter);
                        edt_LearningLv.setOnItemClickListener((adapterView, view, i, l) -> {
                            LearningLevelInfo info = (LearningLevelInfo) adapterView.getAdapter().getItem(i);
                            getTrainingLevel(info.getLearningLevelID());
                            if(specialBranchInfoList!=null)
                                specialBranchInfoList.clear();
                        });
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseEnvelope> call, Throwable t) {
                Log.d(TAG, Objects.requireNonNull(t.getMessage()));
            }
        });
    }

    public void getTrainingLevel(int learningLevelID) {
        RequestEnvelope requestEnvelop = new RequestEnvelope();
        RequestBody requestBody = new RequestBody();
        RequestModel requestModel = new RequestModel();
        requestModel.partnerIdentity = "";
        requestModel.signature = "";
        requestModel.learningLevelID = learningLevelID;
        requestBody.GetTrainingLevel = requestModel;
        requestEnvelop.setRequestBody(requestBody);
        Call<ResponseEnvelope> call = RetrofitGenerator.getRetrofit().GetTrainingLevel(requestEnvelop);
        call.enqueue(new Callback<ResponseEnvelope>() {
            @Override
            public void onResponse(Call<ResponseEnvelope> call, Response<ResponseEnvelope> response) {
                ResponseEnvelope responseEnvelope = response.body();
                if (responseEnvelope != null) {
                    List<TrainingLevelInfo> list = new ArrayList<>();
                    list.clear();
                    list = responseEnvelope.responseBody.getTrainingLevelModel.resultTrainingLevel;
                    ArrayAdapter<TrainingLevelInfo> adapter = new ArrayAdapter(SignUpActivity.this, android.R.layout.simple_expandable_list_item_1, list);
                    edt_TrainingLv.setText("");
                    edt_SpecialBranch.setText("");
                    edt_TrainingLv.setAdapter(adapter);
                    edt_TrainingLv.setOnItemClickListener((adapterView, view, i, l) -> {
                        TrainingLevelInfo info = (TrainingLevelInfo) adapterView.getAdapter().getItem(i);
                        getSpecialBranch(learningLevelID, info.getTrainingLevelID());
                    });
                    if (list.get(0).getErrorDesc() != null) {
                        list.clear();
                        adapter.notifyDataSetChanged();
                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseEnvelope> call, Throwable t) {
                Log.d(TAG, Objects.requireNonNull(t.getMessage()));
            }
        });
    }

    public void getSpecialBranch(int learningLevelID, String trainingLevelID) {
        RequestEnvelope requestEnvelop = new RequestEnvelope();
        RequestBody requestBody = new RequestBody();
        RequestModel requestModel = new RequestModel();
        requestModel.partnerIdentity = "";
        requestModel.signature = "";
        requestModel.learningLevelID = learningLevelID;
        requestModel.trainingLevelID = trainingLevelID;
        requestBody.GetSpecialBranch = requestModel;
        requestEnvelop.setRequestBody(requestBody);
        Call<ResponseEnvelope> call = RetrofitGenerator.getRetrofit().GetSpecialBranch(requestEnvelop);
        call.enqueue(new Callback<ResponseEnvelope>() {
            @Override
            public void onResponse(Call<ResponseEnvelope> call, Response<ResponseEnvelope> response) {
                ResponseEnvelope responseEnvelope = response.body();
                if (responseEnvelope != null) {
                    specialBranchInfoList = responseEnvelope.responseBody.getSpecialBranchModel.resultSpecialBranch;
                    ArrayAdapter<TrainingLevelInfo> adapter = new ArrayAdapter(SignUpActivity.this, android.R.layout.simple_expandable_list_item_1, specialBranchInfoList);
                    edt_SpecialBranch.setText("");
                    edt_SpecialBranch.setAdapter(adapter);
                    edt_SpecialBranch.setOnItemClickListener((adapterView, view, i, l) -> {
                        SpecialBranchInfo info = (SpecialBranchInfo) adapterView.getAdapter().getItem(i);
                        if (info.getWeblink() != null) {
                            tv_web_link.setVisibility(View.VISIBLE);
                            tv_web_link.setText(info.getWeblink());
                        } else
                            tv_web_link.setVisibility(View.GONE);
                    });
                    if (specialBranchInfoList.get(0).getErrorDesc() != null || specialBranchInfoList.size()==0) {
                        specialBranchInfoList.clear();
                        adapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseEnvelope> call, Throwable t) {
                Log.e("TAG", Objects.requireNonNull(t.getMessage()));
            }
        });
    }


    @SuppressLint("SetTextI18n")
    public void showDateTimePicker() {
        final Calendar currentDate = Calendar.getInstance();
        date = Calendar.getInstance();
        new DatePickerDialog(this, (view, year, monthOfYear, dayOfMonth) -> {
            input_date.setError("");
            edt_date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
            date.set(year, monthOfYear, dayOfMonth);
            if (date.getTimeInMillis() > currentDate.getTimeInMillis() - 567648000007L) {
                input_date.setError("Bạn chưa đủ 18 tuổi");
                edt_date.setText("");
            }

        }, date.get(Calendar.YEAR) - 18, date.get(Calendar.MONTH), date.get(Calendar.DATE)).show();

    }


    public void setDate(View view) {
        showDateTimePicker();
    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        input_date = findViewById(R.id.input_date);
        edt_date = findViewById(R.id.edt_date);
        tv_web_link = findViewById(R.id.link_web);
        edt_LearningLv = findViewById(R.id.dropdown_learningLv);
        edt_TrainingLv = findViewById(R.id.dropdown_trainingLv);
        edt_SpecialBranch = findViewById(R.id.dropdown_specialBranch);

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Thông tin đăng ký");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.black));
        toolbar.setNavigationOnClickListener(view -> finish());
    }
}