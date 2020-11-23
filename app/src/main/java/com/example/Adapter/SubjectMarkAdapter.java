package com.example.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.Model.SubjectMarkInfo;
import com.example.quanlyhocsinh.R;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import java.util.List;

public class SubjectMarkAdapter extends RecyclerView.Adapter<SubjectMarkAdapter.ViewHolder> {
    private final List<SubjectMarkInfo> subjectMarkInfoList;
    private final Context context;

    public SubjectMarkAdapter(Context context,List<SubjectMarkInfo> subjectMarkInfoList) {
        this.subjectMarkInfoList = subjectMarkInfoList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_subject_mark,parent,false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SubjectMarkInfo subjectMarkInfo = subjectMarkInfoList.get(position);
        holder.tv_SubjectName.setText(subjectMarkInfo.getSubjectName());

        holder.tv_Passed.setText(subjectMarkInfo.getPassedText());
        showView(holder.tv_FinalSummary,subjectMarkInfo.getFinalSummary());
        showView(holder.tv_UnitText,subjectMarkInfo.getUnitText());
        showView(holder.tv_TestAverage,subjectMarkInfo.getTestAverage());
        showView(holder.tv_Exam1,subjectMarkInfo.getExam1());
        showView(holder.tv_Summary1,subjectMarkInfo.getSummary1());
        showView(holder.tv_Exam2,subjectMarkInfo.getExam2());
        showView(holder.tv_Summary2,subjectMarkInfo.getSummary2());


        if(subjectMarkInfo.isPassed()){
            setColor(holder.tv_Passed,"#24d292");
            setColor(holder.tv_SubjectName,"#24d292");}
        else if(!subjectMarkInfo.isPassed() && subjectMarkInfo.getPassedText()!=null){
            setColor(holder.tv_Passed,"#fc5b3f");
            setColor(holder.tv_SubjectName,"#fc5b3f");}
        else{
            setColor(holder.tv_Passed,"#f9d423");
            setColor(holder.tv_SubjectName,"#f9d423");
        }
        holder.expandableLayout.collapse();
        holder.itemView.setOnClickListener(view -> holder.expandableLayout.toggle());

    }
    @Override
    public int getItemCount() {
        return subjectMarkInfoList.size();
    }
    @SuppressLint("SetTextI18n")
    private void showView(TextView tv, float mark){
        if(mark!=0.0f)
            tv.setText(mark+"");
        else tv.setText("");
    }
    private void setColor(TextView tv,String color){
        tv.setTextColor(Color.parseColor(color));
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_SubjectName,tv_UnitText,tv_Passed,tv_FinalSummary,tv_TestAverage,tv_Exam1,tv_Summary1,tv_Exam2,tv_Summary2;
        ExpandableRelativeLayout expandableLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);
            tv_SubjectName = itemView.findViewById(R.id.tv_SubjectName);
            tv_FinalSummary = itemView.findViewById(R.id.tv_FinalSummary);
            tv_UnitText = itemView.findViewById(R.id.tv_UnitText);
            tv_Passed = itemView.findViewById(R.id.tv_Passed);
            tv_TestAverage = itemView.findViewById(R.id.tv_TestAverage);
            tv_Exam1 = itemView.findViewById(R.id.tv_Exam1);
            tv_Summary1 = itemView.findViewById(R.id.tv_Summary1);
            tv_Exam2 = itemView.findViewById(R.id.tv_Exam2);
            tv_Summary2 = itemView.findViewById(R.id.tv_Summary2);
        }
    }
}
