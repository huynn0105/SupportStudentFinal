package com.example.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.Model.ScheduleInfo;
import com.example.quanlyhocsinh.R;
import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {

    Context context;
    List<ScheduleInfo> scheduleInfoList;


    public ScheduleAdapter(Context context, List<ScheduleInfo> scheduleInfoList) {
        this.context = context;
        this.scheduleInfoList = scheduleInfoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_schedule,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ScheduleInfo info = scheduleInfoList.get(position);
        String[] time = info.getTimeText().split("-");
        holder.tv_StartTime.setText(time[0]);
        holder.tv_EndTime.setText(time[1]);
        holder.tv_SubjectName.setText(info.getSubjectName());
        holder.tv_TeacherName.setText(info.getTeacherName());
        holder.tv_RoomName.setText(info.getRoomName());
    }


    @Override
    public int getItemCount() {
        return scheduleInfoList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_StartTime,tv_EndTime,tv_SubjectName,tv_TeacherName,tv_RoomName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_StartTime = itemView.findViewById(R.id.tv_StartTime);
            tv_EndTime = itemView.findViewById(R.id.tv_EndTime);
            tv_SubjectName = itemView.findViewById(R.id.tv_SubjectName);
            tv_TeacherName = itemView.findViewById(R.id.tv_TeacherName);
            tv_RoomName = itemView.findViewById(R.id.tv_RoomName);
        }
    }

}