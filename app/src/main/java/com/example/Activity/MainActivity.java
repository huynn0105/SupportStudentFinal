package com.example.quanlyhocsinh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


import com.example.Adapter.MainAdapter;
import com.example.Model.ChucNang;



import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    ArrayList<ChucNang> chucNangArrayList;
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addChucNang();
        rv = findViewById(R.id.rv_main);
        adapter = new MainAdapter(this, chucNangArrayList);
        rv.setLayoutManager(new GridLayoutManager(MainActivity.this, 3));
        rv.setAdapter(adapter);

    }

    public void addChucNang() {
        chucNangArrayList = new ArrayList<>();
        chucNangArrayList.add(new ChucNang("Điểm học tập", R.drawable.ic_main_point_h));
        chucNangArrayList.add(new ChucNang("Lịch học", R.drawable.ic_calendar_study_h));
        chucNangArrayList.add(new ChucNang("Lịch thi", R.drawable.ic_calendar_pass_exam_h));
        chucNangArrayList.add(new ChucNang("Học phí", R.drawable.ic_payment_h));
        chucNangArrayList.add(new ChucNang("Hồ sơ HSSV", R.drawable.ic_profile_h));
        chucNangArrayList.add(new ChucNang("Đăng ký tuyển sinh", R.drawable.ic_register_h));
        chucNangArrayList.add(new ChucNang("Chương trình học", R.drawable.ic_plan_h));
        chucNangArrayList.add(new ChucNang("Điểm rèn luyện", R.drawable.ic_training_h));
        chucNangArrayList.add(new ChucNang("Thông báo", R.drawable.ic_info_h));
        chucNangArrayList.add(new ChucNang("Liên hệ", R.drawable.icon_email));

    }


}