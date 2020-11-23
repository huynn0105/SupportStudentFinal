package com.example.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.Model.DebtInfo;
import com.example.quanlyhocsinh.R;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class DebtAdapter extends RecyclerView.Adapter<DebtAdapter.ViewHolder> {
    Context context;
    List<DebtInfo> debtInfoList;

    public DebtAdapter(Context context, List<DebtInfo> debtInfoList) {
        this.context = context;
        this.debtInfoList = debtInfoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_debt, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DebtInfo debtInfo = debtInfoList.get(position);
        if (debtInfo.getErrorCode() == 0) {
            holder.tv_ReceiptSegmentName.setText(debtInfo.getReceiptSegmentName());
            holder.tv_Money.setText(convertTextMoney(debtInfo.getMoney()));
        } else {
            holder.ln_money.setVisibility(View.GONE);
            holder.tv_ReceiptSegmentName.setTextColor(Color.parseColor("#24d292"));
            holder.tv_ReceiptSegmentName.setText(debtInfo.getErrorDesc());
        }
    }

    @Override
    public int getItemCount() {
        return debtInfoList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_ReceiptSegmentName, tv_Money;
        LinearLayout ln_money;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_ReceiptSegmentName = itemView.findViewById(R.id.tv_ReceiptSegmentName);
            tv_Money = itemView.findViewById(R.id.tv_Money);
            ln_money = itemView.findViewById(R.id.ln_money);
        }
    }

    public static String convertTextMoney(long money) {
        Locale locale = new Locale("vi");
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        String[] result = format.format(money).split(",");
        return result[0] + " VNĐ";
    }
}
