package com.example.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Adapter.MainAdapter;
import com.example.Model.FunctionModel;
import com.example.Model.StudentInfo;
import com.example.quanlyhocsinh.R;
import com.google.gson.Gson;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static SharedPreferences sharedPref;
    public static SharedPreferences.Editor prefsEditor;
    RecyclerView rv;
    RelativeLayout viewTop;
    ArrayList<FunctionModel> chucNangArrayList;
    MainAdapter adapter;
    TextView tv_class, tv_fullName, tv_mssv;
    StudentInfo studentInfo;
    String mssv;
    Intent intent;
    public static String json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFunction();
        sharedPref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        json = sharedPref.getString("MyObject", "");
        rv = findViewById(R.id.rv_main);
        adapter = new MainAdapter(this, chucNangArrayList, position -> {
            switch (position) {
                case 0:
                    intent = new Intent(MainActivity.this, SubjectMarkActivity.class);
                    intent.putExtra("SubjectMark", mssv);
                    startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(MainActivity.this, ScheduleActivity.class);
                    intent.putExtra("Schedule", mssv);
                    startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(MainActivity.this,DebtActivity.class);
                    intent.putExtra("Debt",mssv);
                    startActivity(intent);
                    break;
                case 3:
                    startInfo();
                    break;
                case 4:
                    Toast.makeText(this, "Chưa có thông báo nào!", Toast.LENGTH_SHORT).show();
                    break;
                case 5:
                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                            "mailto", "huynn0105@gmail.com", null));
                    startActivity(Intent.createChooser(emailIntent, null));
            }

        });
        rv.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        rv.setAdapter(adapter);
        init();
        getDataIntent();
        viewTop.setOnClickListener(view->startInfo());

    }

    private void startInfo() {
        intent = new Intent(MainActivity.this, StudentInfoActivity.class);
        intent.putExtra("StudentInfo", studentInfo);
        startActivity(intent);
    }

    private void init() {
        tv_class = findViewById(R.id.tv_class);
        viewTop = findViewById(R.id.viewTop);
        tv_fullName = findViewById(R.id.tv_fullName);
        tv_mssv = findViewById(R.id.tv_mssv);
    }

    @SuppressLint("SetTextI18n")
    private void getDataIntent() {
        Intent intent1 = getIntent();
        if (studentInfo == null && json.isEmpty()) {
            if (intent1.hasExtra("Login") && intent1.hasExtra("mssv")) {
                studentInfo = (StudentInfo) intent1.getSerializableExtra("Login");
                mssv = intent1.getStringExtra("mssv");
               prefsEditor = sharedPref.edit();
                Gson gson = new Gson();
                String json = gson.toJson(studentInfo);
                prefsEditor.putString("MyObject", json);
                prefsEditor.putString("Mssv", mssv);
                prefsEditor.apply();
            }
        } else {
            Gson gson = new Gson();
            studentInfo = gson.fromJson(json, StudentInfo.class);
            mssv = sharedPref.getString("Mssv", "");
        }
        tv_fullName.setText(studentInfo.getFullName());
        tv_class.setText("Lớp: " + studentInfo.getClassID());
        tv_mssv.setText("MSSV: " + mssv);
    }

    public void addFunction() {
        chucNangArrayList = new ArrayList<>();
        chucNangArrayList.add(new FunctionModel("Điểm số", R.drawable.ic_main_point_h));
        chucNangArrayList.add(new FunctionModel("Lịch học", R.drawable.ic_calendar_study_h));
//        chucNangArrayList.add(new FunctionModel("Lịch thi", R.drawable.ic_calendar_pass_exam_h));
        chucNangArrayList.add(new FunctionModel("Học phí", R.drawable.ic_payment_h));
        chucNangArrayList.add(new FunctionModel("Hồ sơ HSSV", R.drawable.ic_profile_h));
//        chucNangArrayList.add(new FunctionModel("Đăng ký tuyển sinh", R.drawable.ic_register_h));
//        chucNangArrayList.add(new FunctionModel("Chương trình học", R.drawable.ic_plan_h));
//        chucNangArrayList.add(new FunctionModel("Điểm rèn luyện", R.drawable.ic_training_h));
        chucNangArrayList.add(new FunctionModel("Thông báo", R.drawable.ic_info_h));
        chucNangArrayList.add(new FunctionModel("Liên hệ", R.drawable.icon_email));
    }




}