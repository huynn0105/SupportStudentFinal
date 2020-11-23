package com.example.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.Adapter.DebtAdapter;
import com.example.Model.DebtInfo;
import com.example.Service.Request.RequestBody;
import com.example.Service.Request.RequestEnvelope;
import com.example.Service.Request.RequestModel;
import com.example.Service.Response.ResponseEnvelope;
import com.example.Service.RetrofitGenerator;
import com.example.quanlyhocsinh.R;
import java.util.List;
import java.util.Objects;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DebtActivity extends AppCompatActivity {
    Intent intent;
    RecyclerView rv_debt;
    DebtAdapter adapter;
    TextView tv_sumMoney;
    LinearLayout ln_sumMoney,layout_debt;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debt);

        init();
        getDataIntent();
    }

    private void init() {
        rv_debt = findViewById(R.id.rv_debt);
        layout_debt = findViewById(R.id.layout_debt);
        tv_sumMoney = findViewById(R.id.tv_sumMoney);
        ln_sumMoney = findViewById(R.id.ln_sumMoney);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Công nợ");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.black));
        toolbar.setNavigationOnClickListener(view -> finish());
    }

    private void getDataIntent() {
        intent = getIntent();
        if (intent.hasExtra("Debt")) {
            String mssv = intent.getStringExtra("Debt");
            getDebt(mssv);
        }
    }

    private void getDebt(String studentCode) {
        final ProgressDialog progressDialog = new ProgressDialog(DebtActivity.this);
        progressDialog.setMessage("Đang kiểm tra..");
        progressDialog.show();

        RequestEnvelope requestEnvelop = new RequestEnvelope();
        RequestBody requestBody = new RequestBody();
        requestBody.GetDebt = RequestModel.builder().studentCode(studentCode).build();
        requestEnvelop.setRequestBody(requestBody);
        Call<ResponseEnvelope> callback = RetrofitGenerator.getRetrofit().GetDebt(requestEnvelop);
        callback.enqueue(new Callback<ResponseEnvelope>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<ResponseEnvelope> call, Response<ResponseEnvelope> response) {
                layout_debt.setVisibility(View.VISIBLE);
                progressDialog.dismiss();
                ResponseEnvelope responseEnvelope = response.body();
                if (responseEnvelope != null) {
                    List<DebtInfo> debtInfoList = responseEnvelope.responseBody.getDebtModel.resultDebt;
                    adapter = new DebtAdapter(DebtActivity.this, debtInfoList);
                    rv_debt.setHasFixedSize(true);
                    rv_debt.setAdapter(adapter);
                    long sumMoney = sumMoney(debtInfoList);
                    if(sumMoney!=0){
                        tv_sumMoney.setText(DebtAdapter.convertTextMoney(sumMoney));
                    }else
                        ln_sumMoney.setVisibility(View.GONE);
                }else{
                    Toast.makeText(DebtActivity.this, "Có lỗi xảy ra!!!\nThử vài sau", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseEnvelope> call, Throwable t) {
                setProgressBarVisibility(false);
                progressDialog.dismiss();
                Toast.makeText(DebtActivity.this, "Có lỗi xảy ra!!!\nKiểm tra kết nối và thử lại sau", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private long sumMoney(List<DebtInfo> debtInfoList) {
        long sum = 0L;
        for(DebtInfo info: debtInfoList){
            if(info.getErrorCode()==0){
                sum+=info.getMoney();
            }
        }
        return sum;
    }


}