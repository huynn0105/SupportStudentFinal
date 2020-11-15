package com.example.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.Activity.RegisterActivity;
import com.example.Activity.StudentInfoActivity;
import com.example.Model.FunctionModel;
import com.example.quanlyhocsinh.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    Context context;
    List<FunctionModel> functionModelList;
    private final ItemClickListener listener;

    public MainAdapter(Context context, ArrayList<FunctionModel> functionModelList, ItemClickListener listener) {
        this.context = context;
        this.functionModelList = functionModelList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(context).inflate(R.layout.row_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        FunctionModel func = functionModelList.get(position);
        holder.tv_func_name.setText(func.getFunctionName());
        holder.img_logo.setImageResource(func.getResourceId());

        holder.itemView.setOnClickListener(view -> {
            if(listener!=null){
                listener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return functionModelList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView img_logo;
        TextView tv_func_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_logo = itemView.findViewById(R.id.img_logo);
            tv_func_name = itemView.findViewById(R.id.tv_func_name);
        }
    }
}
