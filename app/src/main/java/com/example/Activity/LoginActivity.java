package com.example.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.Model.StudentInfo;
import com.example.Service.Request.RequestBody;
import com.example.Service.Request.RequestEnvelope;
import com.example.Service.Request.RequestModel;
import com.example.Service.Response.ResponseEnvelope;
import com.example.Service.RetrofitGenerator;
import com.example.quanlyhocsinh.R;
import com.google.android.material.textfield.TextInputLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import static com.example.Activity.MainActivity.sharedPref;

public class LoginActivity extends AppCompatActivity {
    Button btn_login, btn_dangky, btn_tracuu;
    TextInputLayout input_mssv, input_password;
    EditText edt_mssv, edt_password;
    TextView tv_error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();


        btn_dangky.setOnClickListener(view -> startActivity(new Intent(LoginActivity.this, RegisterActivity.class)));
        btn_tracuu.setOnClickListener(view -> startActivity(new Intent(LoginActivity.this, FindStudentCollectionActivity.class)));
        btn_login.setOnClickListener(view -> {
            String mssv = edt_mssv.getText().toString().trim();
            String password = edt_password.getText().toString().trim();
            boolean isValid = validateForm(mssv, password);
            if (isValid) {
                login(mssv, password);
                tv_error.setText("");
            }else
                tv_error.setText("");

        });

    }

    private void login(String mssv, String password) {
        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setMessage("Đang kiểm tra..");
        progressDialog.show();
        RequestEnvelope requestEnvelop = new RequestEnvelope();
        RequestBody requestBody = new RequestBody();
        requestBody.LoginStudent = RequestModel.builder().loginName(mssv).password(password).build();
        requestEnvelop.setRequestBody(requestBody);
        Call<ResponseEnvelope> callback = RetrofitGenerator.getRetrofit().LoginStudent(requestEnvelop);
        callback.enqueue(new Callback<ResponseEnvelope>() {
            @Override
            public void onResponse(Call<ResponseEnvelope> call, Response<ResponseEnvelope> response) {
                ResponseEnvelope responseEnvelope = response.body();
                progressDialog.dismiss();
                if (responseEnvelope != null) {
                    StudentInfo studentInfo = responseEnvelope.responseBody.getLoginStudentModel.resultLoginStudent;
                    if (studentInfo != null) {
                        if(studentInfo.getErrorCode()==0){
                            tv_error.setVisibility(View.INVISIBLE);
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            intent.putExtra("Login",studentInfo);
                            intent.putExtra("mssv",mssv);
                            startActivity(intent);
                            finish();
                        }else{
                            tv_error.setVisibility(View.VISIBLE);
                            tv_error.setText(studentInfo.getErrorDesc());
                            edt_password.setText("");
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseEnvelope> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(LoginActivity.this, "Có lỗi xảy ra!!!\nKiểm tra kết nối và thử lại sau", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validateForm(String mssv, String password) {
        if (mssv.isEmpty())
            input_mssv.setError("Không được bỏ trống!!!");
        else input_mssv.setError("");
        if (password.isEmpty())
            input_password.setError("Không được bỏ trống!!!");
        else input_password.setError("");

        return !mssv.isEmpty()
                && !password.isEmpty();

    }

    private void init() {
        btn_login = findViewById(R.id.btn_login);
        btn_dangky = findViewById(R.id.btn_dangky);
        btn_tracuu = findViewById(R.id.btn_tracuu);
        input_mssv = findViewById(R.id.input_mssv);
        tv_error = findViewById(R.id.tv_error);
        input_password = findViewById(R.id.input_password);
        edt_mssv = findViewById(R.id.edt_mssv);
        edt_password = findViewById(R.id.edt_password);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }

    @Override
    protected void onStart() {
        super.onStart();
        sharedPref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String json = sharedPref.getString("MyObject","");
        if(!json.isEmpty()){
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            finish();
        }
    }
}