package com.example.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quanlyhocsinh.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;
import java.util.Objects;

public class TraCuuSVActivity extends AppCompatActivity {
    Toolbar toolbar;
    Button tracuu;
    TextInputLayout input_date;
    EditText edt_date, edt_ma_baove, edt_hoten, edt_mssv;
    Calendar date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tra_cuu_s_v);
        init();
        tracuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edt_date.getText().toString().equals("") || edt_hoten.getText().toString().equals("") || edt_ma_baove.getText().toString().equals("") || edt_mssv.getText().toString().equals("")) {
                    Toast.makeText(TraCuuSVActivity.this, "Bạn chưa nhập thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void init() {
        tracuu = findViewById(R.id.btn_tracuu);
        input_date = findViewById(R.id.input_date);
        toolbar = findViewById(R.id.toolbar);
        edt_date = findViewById(R.id.edt_date);
        edt_ma_baove = findViewById(R.id.edt_ma_baove);
        edt_hoten = findViewById(R.id.edt_hoten);
        edt_mssv = findViewById(R.id.edt_mssv);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Tra cứu hồ sơ tuyển sinh");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.black));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void setDate(View view) {
        showDateTimePicker();
    }

    public void showDateTimePicker() {

        date = Calendar.getInstance();
        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                input_date.setError("");
                edt_date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                date.set(year, monthOfYear, dayOfMonth);

            }
        }, date.get(Calendar.YEAR) - 18, date.get(Calendar.MONTH), date.get(Calendar.DATE)).show();

    }

//    public void kiemtra(View view) {
//        Log.d("kiemtra","click");
//        if (edt_date.getText().equals("") || edt_hoten.equals("") || edt_ma_baove.equals("")|| edt_mssv.equals("")){
//            Toast.makeText(TraCuuSVActivity.this, "Bạn chưa nhập thông tin", Toast.LENGTH_SHORT).show();
//        }
//    }
}