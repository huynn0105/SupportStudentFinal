package com.example.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Model.StudentCollectionInfo;
import com.example.quanlyhocsinh.R;

import java.util.Objects;

public class StudentCollectionActivity extends AppCompatActivity {

    Toolbar toolbar;
    String statusStudent = "";
    TextView tv_studentCollectionID, tv_fullName, tv_birthDateText, tv_address, tv_tel, tv_tel2, tv_email, tv_facebook, tv_schoolName, tv_studentCollectionStatusID, text_birthDateText, text_address, text_tel, text_tel2, text_email, text_facebook, text_schoolName,text_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_collection);
        init();
        GetData();
    }

    @SuppressLint("SetTextI18n")
    private void GetData() {
        Intent intent = getIntent();
        if (intent.hasExtra("Student")) {
            if(intent.getFlags()!=-1)
                text_title.setVisibility(View.GONE);
            StudentCollectionInfo studentCollectionInfo = (StudentCollectionInfo) intent.getSerializableExtra("Student");
            if (studentCollectionInfo != null) {
                tv_studentCollectionID.setText(studentCollectionInfo.getStudentCollectionID());
                tv_fullName.setText(studentCollectionInfo.getFullName());
                if (studentCollectionInfo.getBirthDateText() != null)
                    tv_birthDateText.setText(studentCollectionInfo.getBirthDateText());
                else {
                    tv_birthDateText.setVisibility(View.GONE);
                    text_birthDateText.setVisibility(View.GONE);
                }
                if (studentCollectionInfo.getAddress() != null)
                    tv_address.setText(studentCollectionInfo.getAddress());
                else {
                    text_address.setVisibility(View.GONE);
                    tv_address.setVisibility(View.GONE);
                }
                if (studentCollectionInfo.getTel() != null)
                    tv_tel.setText(studentCollectionInfo.getTel());
                else {
                    text_tel.setVisibility(View.GONE);
                    tv_tel.setVisibility(View.GONE);
                }
                if (studentCollectionInfo.getTel2() != null)
                    tv_tel2.setText(studentCollectionInfo.getTel2());
                else {
                    tv_tel2.setVisibility(View.GONE);
                    text_tel2.setVisibility(View.GONE);
                }
                if (studentCollectionInfo.getEmail() != null)
                    tv_email.setText(studentCollectionInfo.getEmail());
                else {
                    tv_email.setVisibility(View.GONE);
                    text_email.setVisibility(View.GONE);
                }
                if (studentCollectionInfo.getFacebook() != null)
                    tv_facebook.setText(studentCollectionInfo.getFacebook());
                else {
                    text_facebook.setVisibility(View.GONE);
                    tv_facebook.setVisibility(View.GONE);
                }
                if (studentCollectionInfo.getSchoolName() != null) {
                    tv_schoolName.setText(studentCollectionInfo.getSchoolName());
                } else {
                    tv_schoolName.setVisibility(View.GONE);
                    text_schoolName.setVisibility(View.GONE);
                }
                if (studentCollectionInfo.getStudentCollectionStatusID() == 0)
                    statusStudent = "Chưa xác định";
                else if (studentCollectionInfo.getStudentCollectionStatusID() == 1)
                    statusStudent = "Chưa xử lý";
                else if (studentCollectionInfo.getStudentCollectionStatusID() == 2)
                    statusStudent = "Đã xử lý";
                tv_studentCollectionStatusID.setText(statusStudent);
            }

        }


    }

    private void init() {
        tv_address = findViewById(R.id.tv_address);
        tv_studentCollectionID = findViewById(R.id.tv_studentCollectionID);
        tv_fullName = findViewById(R.id.tv_fullName);
        tv_birthDateText = findViewById(R.id.tv_birthDateText);
        tv_tel = findViewById(R.id.tv_tel);
        tv_tel2 = findViewById(R.id.tv_tel2);
        tv_email = findViewById(R.id.tv_email);
        tv_facebook = findViewById(R.id.tv_facebook);
        tv_schoolName = findViewById(R.id.tv_schoolName);
        text_birthDateText = findViewById(R.id.text_birthDateText);
        text_address = findViewById(R.id.text_address);
        text_tel = findViewById(R.id.text_tel);
        text_tel2 = findViewById(R.id.text_tel2);
        text_email = findViewById(R.id.text_email);
        text_facebook = findViewById(R.id.text_facebook);
        text_schoolName = findViewById(R.id.text_schoolName);
        text_title = findViewById(R.id.text_title);
        tv_studentCollectionStatusID = findViewById(R.id.tv_studentCollectionStatusID);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Thông tin hồ sơ");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.black));
        toolbar.setNavigationOnClickListener(view->startActivity(new Intent(StudentCollectionActivity.this,SignInActivity.class)));
    }
}