package com.example.Service.Response;

import com.example.Model.LearningLevelInfo;
import com.example.Model.SpecialBranchInfo;
import com.example.Model.StudentCollectionInfo;
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


}