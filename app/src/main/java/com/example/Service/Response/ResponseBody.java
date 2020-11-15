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
    public ResponseModel createStudentCollectionModel;

    @Element(name = "GetStudentCollectionResponse", required = false)
    public ResponseModel getStudentCollectionModel;

    @Element(name = "LoginStudentResponse", required = false)
    public ResponseModel getLoginStudentModel;

    @Element(name = "GetSubjectMarkResponse", required = false)
    public ResponseModel getSubjectMarkModel;

    @Element(name = "GetScheduleResponse", required = false)
    public ResponseModel getScheduleModel;

}
