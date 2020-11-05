package com.example.Service.Response;

import org.simpleframework.xml.Element;


public class ResponseBody {
    @Element(name = "GetLearningLevelResponse", required = false)
    public ResponseModel getLearningLevelModel;

    @Element(name = "GetTrainingLevelResponse", required = false)
    public ResponseModel getTrainingLevelModel;

    @Element(name = "GetSpecialBranchResponse", required = false)
    public ResponseModel getSpecialBranchModel;

    @Element(name = "CreateStudentCollectionResponse", required = false)
    public ResponseModel getStudentCollectionModel;
}
