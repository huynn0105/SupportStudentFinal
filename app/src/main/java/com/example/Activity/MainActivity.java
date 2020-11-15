package com.example.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


import com.example.Adapter.ItemClickListener;
import com.example.Adapter.MainAdapter;
import com.example.Model.FunctionModel;
import com.example.Model.StudentInfo;
import com.example.quanlyhocsinh.R;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    ArrayList<FunctionModel> chucNangArrayList;
    MainAdapter adapter;
    TextView tv_class, tv_fullName, tv_mssv;
    StudentInfo studentInfo;
    String mssv;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFunction();
        rv = findViewById(R.id.rv_main);
        adapter = new MainAdapter(this, chucNangArrayList, position -> {
            switch (position){
                case 0:
                    intent = new Intent(MainActivity.this, SubjectMarkActivity.class);
                    intent.putExtra("SubjectMark",mssv);
                    startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(MainActivity.this, ScheduleActivity.class);
                    intent.putExtra("Schedule",mssv);
                    startActivity(intent);
                    break;
                case 4:
                    intent = new Intent(MainActivity.this, StudentInfoActivity.class);
                    intent.putExtra("StudentInfo",studentInfo);
                    startActivity(intent);
                    break;
            }

        });
        rv.setLayoutManager(new GridLayoutManager(MainActivity.this, 3));
        rv.setAdapter(adapter);
        init();
        getDataIntent();

    }

    private void init() {
        tv_class = findViewById(R.id.tv_class);
        tv_fullName = findViewById(R.id.tv_fullName);
        tv_mssv = findViewById(R.id.tv_mssv);
    }

    @SuppressLint("SetTextI18n")
    private void getDataIntent() {
        Intent intent1 = getIntent();
        if(intent1.hasExtra("Login") && intent1.hasExtra("mmsv")) {
            studentInfo = (StudentInfo) intent1.getSerializableExtra("Login");
            mssv = intent1.getStringExtra("mssv");
            tv_fullName.setText(studentInfo.getFullName());
            tv_class.setText("Lớp: " +studentInfo.getClassID());
            tv_mssv.setText("MSSV: "+mssv);
        }
    }

    public void addFunction() {
        chucNangArrayList = new ArrayList<>();
        chucNangArrayList.add(new FunctionModel("Điểm học tập", R.drawable.ic_main_point_h));
        chucNangArrayList.add(new FunctionModel("Lịch học", R.drawable.ic_calendar_study_h));
        chucNangArrayList.add(new FunctionModel("Lịch thi", R.drawable.ic_calendar_pass_exam_h));
        chucNangArrayList.add(new FunctionModel("Học phí", R.drawable.ic_payment_h));
        chucNangArrayList.add(new FunctionModel("Hồ sơ HSSV", R.drawable.ic_profile_h));
//        chucNangArrayList.add(new FunctionModel("Đăng ký tuyển sinh", R.drawable.ic_register_h));
//        chucNangArrayList.add(new FunctionModel("Chương trình học", R.drawable.ic_plan_h));
//        chucNangArrayList.add(new FunctionModel("Điểm rèn luyện", R.drawable.ic_training_h));
        chucNangArrayList.add(new FunctionModel("Thông báo", R.drawable.ic_info_h));
        chucNangArrayList.add(new FunctionModel("Liên hệ", R.drawable.icon_email));
    }


}