package com.example.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.Model.LearningLevelInfo;
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

public class RegisterActivity extends AppCompatActivity {
    final String TAG = "TAG_ERROR";
    EditText edt_fullName, edt_birthDay, edt_birthMonth, edt_birthYear, edt_birthPlace, edt_tel, edt_tel2, edt_address, edt_schoolName;
    TextInputLayout  input_fullName, input_birthDay, input_birthMonth, input_birthYear, input_gender, input_birthPlace, input_tel, input_tel2, input_address, input_learningLevelID, input_trainingLevelID, input_specialBranchID, input_schoolName;
    Toolbar toolbar;
    TextView tv_web_link;
    Button btn_submit;
    AutoCompleteTextView edt_TrainingLv, edt_LearningLv, edt_SpecialBranch;
    List<SpecialBranchInfo> specialBranchInfoList;
    LearningLevelInfo learningLevelInfo;
    TrainingLevelInfo trainingLevelInfo;
    SpecialBranchInfo specialBranchInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        getLearningLevel();
        String[] sex = getResources().getStringArray(R.array.Sex);
        AutoCompleteTextView edt_gender = findViewById(R.id.dropdown_sex);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_expandable_list_item_1, sex);
        edt_gender.setAdapter(adapter);
        btn_submit.setOnClickListener(view -> {
            String fullName = edt_fullName.getText().toString().trim();
            String birthDay = edt_birthDay.getText().toString().trim();
            String birthMonth = edt_birthMonth.getText().toString().trim();
            String birthYear = edt_birthYear.getText().toString().trim();
            String birthPlace = edt_birthPlace.getText().toString().trim();
            String gender = edt_gender.getText().toString().trim();
            String tel = edt_tel.getText().toString().trim();
            String tel2 = edt_tel2.getText().toString().trim();
            String address = edt_address.getText().toString().trim();
            String schoolName = edt_schoolName.getText().toString().trim();

            boolean isValid = validateForm(fullName, birthDay, birthMonth, birthYear, birthPlace, gender, tel, tel2, address, schoolName);
            if (isValid) {
                int genders;
                if (gender.equals("Nam")) genders = 0;
                else if (gender.equals("Nữ")) genders = 1;
                else genders = 2;
                createStudentCollection(fullName, Integer.parseInt(birthDay), Integer.parseInt(birthMonth), Integer.parseInt(birthYear), birthPlace, genders, address, tel, tel2, learningLevelInfo.getLearningLevelID(), trainingLevelInfo.getTrainingLevelID(), specialBranchInfo.getSpecialBranchID(), schoolName);
            } else {
                Toast.makeText(this, "Error!!!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private boolean validateForm(String fullName, String birthDay, String birthMonth, String birthYear,
                                 String birthPlace, String gender, String tel, String tel2, String address,
                                 String schoolName) {


        if (fullName.isEmpty())
            input_fullName.setError("Không được bỏ trống!!!");
        else input_fullName.setError("");

        if (!birthDay.isEmpty()) {
            if (isStringInt(birthDay)) {
                if (Integer.parseInt(birthDay) > 31 && Integer.parseInt(birthDay) <= 0)
                    input_birthMonth.setError("Không hợp lệ!!!");
                else input_birthMonth.setError("");
            } else
                input_birthMonth.setError("Không hợp lệ!!!");
        }else
            input_birthDay.setError("Không được bỏ trống!!!");


        if (!birthMonth.isEmpty()) {
            if (isStringInt(birthMonth)) {
                if (Integer.parseInt(birthMonth) > 12 && Integer.parseInt(birthMonth) <= 0)
                    input_birthMonth.setError("Không hợp lệ!!!");
                else input_birthMonth.setError("");
            } else
                input_birthMonth.setError("Không hợp lệ!!!");
        } else
            input_birthMonth.setError("Không được bỏ trống!!!");


        if (birthYear.isEmpty())
            input_birthYear.setError("Không được bỏ trống!!!");
        else {
            input_birthYear.setError("");
            if (isStringInt(birthYear)) {
                if (Integer.parseInt(birthYear) <= 0)
                    input_birthMonth.setError("Không hợp lệ!!!");
                else input_birthMonth.setError("");
            } else
                input_birthMonth.setError("Không hợp lệ!!!");
        }

        if (birthPlace.isEmpty())
            input_birthPlace.setError("Không được bỏ trống!!!");
        else input_birthPlace.setError("");

        if (gender.isEmpty())
            input_gender.setError("Không được bỏ trống!!!");
        else input_gender.setError("");

        if (tel.isEmpty())
            input_tel.setError("Không được bỏ trống!!!");
        else input_tel.setError("");

        if (address.isEmpty())
            input_address.setError("Không được bỏ trống!!!");
        else input_address.setError("");

        if (schoolName.isEmpty())
            input_schoolName.setError("Không được bỏ trống!!!");
        else input_schoolName.setError("");

        if (learningLevelInfo == null)
            input_learningLevelID.setError("Không được bỏ trống!!!");
        else input_learningLevelID.setError("");

        if (trainingLevelInfo == null)
            input_trainingLevelID.setError("Không được bỏ trống!!!");
        else input_trainingLevelID.setError("");

        if (specialBranchInfo == null)
            input_specialBranchID.setError("Không được bỏ trống!!!");
        else input_specialBranchID.setError("");

        //                && Patterns.EMAIL_ADDRESS.matcher(mail).matches())
        return !fullName.isEmpty()
                && !birthYear.isEmpty()
                && !birthDay.isEmpty()
                && !birthMonth.isEmpty()
                && !birthPlace.isEmpty()
                && learningLevelInfo != null
                && !address.isEmpty()
                && !tel.isEmpty()
                && trainingLevelInfo != null
                && !trainingLevelInfo.getTrainingLevelID().isEmpty()
                && trainingLevelInfo != null
                && !specialBranchInfo.getSpecialBranchID().isEmpty()
                && !schoolName.isEmpty();
    }

    public boolean isStringInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public void getLearningLevel() {
        RequestEnvelope requestEnvelop = new RequestEnvelope();
        RequestBody requestBody = new RequestBody();
        requestBody.GetLearningLevel = RequestModel.builder().build();
        requestEnvelop.setRequestBody(requestBody);
        Call<ResponseEnvelope> call = RetrofitGenerator.getRetrofit().GetLearningLevel(requestEnvelop);
        call.enqueue(new Callback<ResponseEnvelope>() {
            @Override
            public void onResponse(Call<ResponseEnvelope> call, Response<ResponseEnvelope> response) {
                ResponseEnvelope responseEnvelope = response.body();
                if (responseEnvelope != null) {
                    List<LearningLevelInfo> list = responseEnvelope.responseBody.getLearningLevelModel.resultLearningLevel;
                    if (list.size() != 0) {
                        ArrayAdapter<LearningLevelInfo> adapter = new ArrayAdapter(RegisterActivity.this, android.R.layout.simple_expandable_list_item_1, list);
                        edt_LearningLv.setAdapter(adapter);
                        edt_LearningLv.setOnItemClickListener((adapterView, view, i, l) -> {
                            learningLevelInfo = (LearningLevelInfo) adapterView.getAdapter().getItem(i);
                            getTrainingLevel(learningLevelInfo.getLearningLevelID());
                            if (specialBranchInfoList != null)
                                specialBranchInfoList.clear();
                        });
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseEnvelope> call, Throwable t) {
                Log.d(TAG, Objects.requireNonNull(t.getMessage()));
                Toast.makeText(RegisterActivity.this, "Có lỗi xảy ra!!!\nKiểm tra kết nối và thử lại sau", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getTrainingLevel(int learningLevelID) {
        RequestEnvelope requestEnvelop = new RequestEnvelope();
        RequestBody requestBody = new RequestBody();
        requestBody.GetTrainingLevel = RequestModel.builder().learningLevelID(learningLevelID).build();
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
                    ArrayAdapter<TrainingLevelInfo> adapter = new ArrayAdapter(RegisterActivity.this, android.R.layout.simple_expandable_list_item_1, list);
                    edt_TrainingLv.setText("");
                    edt_SpecialBranch.setText("");
                    edt_TrainingLv.setAdapter(adapter);
                    edt_TrainingLv.setOnItemClickListener((adapterView, view, i, l) -> {
                        trainingLevelInfo = (TrainingLevelInfo) adapterView.getAdapter().getItem(i);
                        getSpecialBranch(learningLevelID, trainingLevelInfo.getTrainingLevelID());
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


        requestBody.GetSpecialBranch = RequestModel.builder()
                .learningLevelID(learningLevelID)
                .trainingLevelID(trainingLevelID)
                .build();


        requestEnvelop.setRequestBody(requestBody);
        Call<ResponseEnvelope> call = RetrofitGenerator.getRetrofit().GetSpecialBranch(requestEnvelop);
        call.enqueue(new Callback<ResponseEnvelope>() {
            @Override
            public void onResponse(Call<ResponseEnvelope> call, Response<ResponseEnvelope> response) {
                ResponseEnvelope responseEnvelope = response.body();
                if (responseEnvelope != null) {
                    specialBranchInfoList = responseEnvelope.responseBody.getSpecialBranchModel.resultSpecialBranch;
                    ArrayAdapter<TrainingLevelInfo> adapter = new ArrayAdapter(RegisterActivity.this, android.R.layout.simple_expandable_list_item_1, specialBranchInfoList);
                    edt_SpecialBranch.setText("");
                    edt_SpecialBranch.setAdapter(adapter);
                    edt_SpecialBranch.setOnItemClickListener((adapterView, view, i, l) -> {
                        specialBranchInfo = (SpecialBranchInfo) adapterView.getAdapter().getItem(i);
                        if (specialBranchInfo.getWeblink() != null) {
                            tv_web_link.setVisibility(View.VISIBLE);
                            tv_web_link.setText(specialBranchInfo.getWeblink());
                        } else
                            tv_web_link.setVisibility(View.GONE);
                    });
                    if (specialBranchInfoList.get(0).getErrorDesc() != null || specialBranchInfoList.size() == 0) {
                        specialBranchInfoList.clear();
                        adapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseEnvelope> call, Throwable t) {
                Log.e("TAG", Objects.requireNonNull(t.getMessage()));
                Toast.makeText(RegisterActivity.this, "Có lỗi xảy ra!!!\nThử lại sau", Toast.LENGTH_SHORT).show();
            }
        });
    }



    private void init() {
        toolbar = findViewById(R.id.toolbar);
        edt_fullName = findViewById(R.id.edt_fullName);
        edt_birthDay = findViewById(R.id.edt_birthDay);
        edt_birthMonth = findViewById(R.id.edt_birthMonth);
        edt_birthYear = findViewById(R.id.edt_birthYear);
        edt_birthPlace = findViewById(R.id.edt_birthPlace);
        edt_tel = findViewById(R.id.edt_tel);
        edt_tel2 = findViewById(R.id.edt_tel2);
        edt_address = findViewById(R.id.edt_address);
        edt_schoolName = findViewById(R.id.edt_schoolName);
        btn_submit = findViewById(R.id.btn_submit);
        tv_web_link = findViewById(R.id.link_web);
        edt_LearningLv = findViewById(R.id.dropdown_learningLv);
        edt_TrainingLv = findViewById(R.id.dropdown_trainingLv);
        edt_SpecialBranch = findViewById(R.id.dropdown_specialBranch);
        input_fullName = findViewById(R.id.input_fullName);
        input_birthDay = findViewById(R.id.input_birthDay);
        input_birthMonth = findViewById(R.id.input_birthMonth);
        input_birthYear = findViewById(R.id.input_birthYear);
        input_gender = findViewById(R.id.input_gender);
        input_birthPlace = findViewById(R.id.input_birthPlace);
        input_tel = findViewById(R.id.input_tel);
        input_tel2 = findViewById(R.id.input_tel2);
        input_address = findViewById(R.id.input_address);
        input_trainingLevelID = findViewById(R.id.input_trainingLevelID);
        input_learningLevelID = findViewById(R.id.input_learningLevelID);
        input_specialBranchID = findViewById(R.id.input_specialBranchID);
        input_schoolName = findViewById(R.id.input_schoolName);

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Thông tin đăng ký");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.black));
        toolbar.setNavigationOnClickListener(view -> finish());
    }


    public void createStudentCollection(String fullName, int birthDay, int birthMonth, int birthYear, String birthPlace,
                                        int gender, String address, String tel, String tel2, int learningLevelID, String trainingLevelID,
                                        String specialBranchID, String schoolName) {

        final ProgressDialog progressDialog = new ProgressDialog(RegisterActivity.this);
        progressDialog.setMessage("Đang kiểm tra..");
        progressDialog.show();

        RequestEnvelope requestEnvelop = new RequestEnvelope();
        RequestBody requestBody = new RequestBody();


        requestBody.CreateStudentCollection = RequestModel.builder()
                .fullName(fullName)
                .birthDay(birthDay)
                .birthMonth(birthMonth)
                .birthYear(birthYear)
                .birthPlace(birthPlace)
                .gender(gender)
                .address(address)
                .tel(tel)
                .tel2(tel2)
                .learningLevelID(learningLevelID)
                .specialBranchID(specialBranchID)
                .trainingLevelID(trainingLevelID)
                .schoolName(schoolName)
                .build();


        requestEnvelop.setRequestBody(requestBody);
        Call<ResponseEnvelope> callback = RetrofitGenerator.getRetrofit().CreateStudentCollection(requestEnvelop);
        callback.enqueue(new Callback<ResponseEnvelope>() {
            @Override
            public void onResponse(Call<ResponseEnvelope> call, Response<ResponseEnvelope> response) {
                if (response.body() != null) {
                    progressDialog.dismiss();
                    StudentCollectionInfo studentCollectionInfo = response.body().responseBody.createStudentCollectionModel.resultCreateStudentCollection;
                    if (studentCollectionInfo.getErrorCode() != 0) {
                        Toast.makeText(RegisterActivity.this, studentCollectionInfo.getErrorDesc(), Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(RegisterActivity.this, StudentCollectionActivity.class);
                        intent.putExtra("Student", studentCollectionInfo);
                        intent.setFlags(-1);
                        startActivity(intent);
                        finish();
                    }

                } else {
                    Toast.makeText(RegisterActivity.this, "Lỗi không xác định", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseEnvelope> call, Throwable t) {
                progressDialog.dismiss();
                Log.e(TAG, t.getMessage());
                Toast.makeText(RegisterActivity.this, "Có lỗi xảy ra!!!\nThử vài sau", Toast.LENGTH_SHORT).show();
            }
        });


    }
}