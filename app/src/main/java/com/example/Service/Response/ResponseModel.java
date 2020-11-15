package com.example.Service.Response;

import com.example.Model.LearningLevelInfo;
import com.example.Model.ScheduleInfo;
import com.example.Model.SpecialBranchInfo;
import com.example.Model.StudentCollectionInfo;
import com.example.Model.StudentInfo;
import com.example.Model.SubjectMarkInfo;
import com.example.Model.TrainingLevelInfo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;


import java.util.List;

public class ResponseModel {

    @ElementList(name = "GetLearningLevelResult", required = false)
    public List<LearningLevelInfo> resultLearningLevel;

    @ElementList(name = "GetTrainingLevelResult", required = false)
    public List<TrainingLevelInfo> resultTrainingLevel;

    @ElementList(name = "GetSpecialBranchResult", required = false)
    public List<SpecialBranchInfo> resultSpecialBranch;

    @Element(name = "CreateStudentCollectionResult", required = false)
    public StudentCollectionInfo resultCreateStudentCollection;

    @ElementList(name = "GetStudentCollectionResult", required = false)
    public List<StudentCollectionInfo> resultStudentCollection;

    @Element(name = "LoginStudentResult", required = false)
    public StudentInfo resultLoginStudent;

    @ElementList(name = "GetSubjectMarkResult", required = false)
    public List<SubjectMarkInfo> resultSubjectMark;

    @ElementList(name = "GetScheduleResult", required = false)
    public List<ScheduleInfo> resultSchedule;
}