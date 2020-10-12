package com.example.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.quanlyhocsinh.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;
import java.util.Objects;

public class SignupActivity extends AppCompatActivity {
    Calendar date;
    EditText edt_date;
    TextInputLayout input_date;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        init();

        String[] sex = getResources().getStringArray(R.array.Sex);
        AutoCompleteTextView editText = findViewById(R.id.dropdown_sex);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_expandable_list_item_1,  sex);
        editText.setAdapter(adapter);

        String[] educational = getResources().getStringArray(R.array.educational);
        AutoCompleteTextView editText1 = findViewById(R.id.dropdown_educational);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this,
                android.R.layout.simple_expandable_list_item_1,  educational);
        editText1.setAdapter(adapter1);


        String[] bachoc = getResources().getStringArray(R.array.bachoc);
        AutoCompleteTextView editText2 = findViewById(R.id.dropdown_bachoc);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this,
                android.R.layout.simple_expandable_list_item_1,  bachoc);
        editText2.setAdapter(adapter2);



    }

    public void showDateTimePicker() {
        final Calendar currentDate = Calendar.getInstance();
        date = Calendar.getInstance();
        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                input_date.setError("");
                edt_date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                date.set(year, monthOfYear, dayOfMonth);
                if (date.getTimeInMillis() > currentDate.getTimeInMillis()-567648000007L) {
                    input_date.setError("Bạn chưa đủ 18 tuổi");
                    edt_date.setText("");
                }


            }
        }, date.get(Calendar.YEAR) - 18, date.get(Calendar.MONTH), date.get(Calendar.DATE)).show();

    }


    public void setDate(View view) {
        showDateTimePicker();
    }
    private void init(){
        toolbar = findViewById(R.id.toolbar);
        input_date = findViewById(R.id.input_date);
        edt_date = findViewById(R.id.edt_date);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Thông tin đăng ký");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.black));

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}