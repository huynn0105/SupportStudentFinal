package com.example.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.Model.StudentInfo;
import com.example.quanlyhocsinh.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import static com.example.Activity.MainActivity.prefsEditor;
import static com.example.Activity.MainActivity.sharedPref;

public class StudentInfoActivity extends AppCompatActivity {
    EditText edt_fullName, edt_birthDay, edt_birthMonth, edt_birthYear, edt_birthPlace, edt_tel, edt_contactTel, edt_address, edt_class;
    TextInputLayout input_class, input_fullName, input_birthDay, input_birthMonth, input_birthYear, input_contactTel, input_birthPlace, input_tel, input_address;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);
        init();
        getDataIntent();

    }

    @SuppressLint("SetTextI18n")
    private void getDataIntent() {
        Intent intent = getIntent();
        if(intent.hasExtra("StudentInfo")){
            StudentInfo studentInfo = (StudentInfo) intent.getSerializableExtra("StudentInfo");
            if(studentInfo!=null){
                edt_fullName.setText(studentInfo.getFullName());
                edt_birthDay.setText(studentInfo.getBirthDay()+"");
                edt_birthMonth.setText(studentInfo.getBirthMonth()+"");
                edt_birthYear.setText(studentInfo.getBirthYear()+"");
                edt_birthPlace.setText(studentInfo.getBirthPlace());
                edt_tel.setText(studentInfo.getTel());
                edt_contactTel.setText(studentInfo.getContactTel());
                edt_address.setText(studentInfo.getLiveAddress());
                edt_class.setText(studentInfo.getClassID());
            }
        }
    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        edt_class = findViewById(R.id.edt_class);
        edt_fullName = findViewById(R.id.edt_fullName);
        edt_birthDay = findViewById(R.id.edt_birthDay);
        edt_birthMonth = findViewById(R.id.edt_birthMonth);
        edt_birthYear = findViewById(R.id.edt_birthYear);
        edt_birthPlace = findViewById(R.id.edt_birthPlace);
        edt_tel = findViewById(R.id.edt_tel);
        edt_contactTel = findViewById(R.id.edt_contactTel);
        edt_address = findViewById(R.id.edt_address);
        input_fullName = findViewById(R.id.input_fullName);
        input_class = findViewById(R.id.input_class);
        input_birthDay = findViewById(R.id.input_birthDay);
        input_birthMonth = findViewById(R.id.input_birthMonth);
        input_birthYear = findViewById(R.id.input_birthYear);
        input_birthPlace = findViewById(R.id.input_birthPlace);
        input_tel = findViewById(R.id.input_tel);
        input_contactTel = findViewById(R.id.input_contactTel);
        input_address = findViewById(R.id.input_address);


        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Hồ sơ sinh viên");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.black));
        toolbar.setNavigationOnClickListener(view -> finish());
    }

    public void logout(View view) {
        if(isNetworkConnected()){
            sharedPref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
            prefsEditor = sharedPref.edit();
            prefsEditor.clear();
            prefsEditor.apply();
            startActivity(new Intent(StudentInfoActivity.this,LoginActivity.class));
            finish();
        }else
            Toast.makeText(this, "Có lỗi xảy ra!!!\nKiểm tra kết nối internet và thử lại sau", Toast.LENGTH_SHORT).show();
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
}