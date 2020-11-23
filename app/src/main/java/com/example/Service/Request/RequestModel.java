package com.example.Service.Request;
import org.simpleframework.xml.Element;

import lombok.Builder;

@Builder
public class RequestModel {
    //GetLearningLevel
    @Element(name = "partnerIdentity", required = false)
    public String partnerIdentity;

    @Element(name = "signature", required = false)
    public String signature;

    @Element(name = "learningLevelID", required = false)
    public int learningLevelID;

    //GetTrainingLevel
    @Element(name = "trainingLevelID", required = false)
    public String trainingLevelID;

    //GetStudentCollection
    @Element(name = "studentCollectionID", required = false)
    public long studentCollectionID;

    @Element(name = "keyWord", required = false)
    public String keyWord;

    @Element(name = "pageIndexForGet", required = false)
    public int pageIndexForGet;

    @Element(name = "topRow", required = false)
    public int topRow;


    //CreateStudentCollection

    @Element(name = "apiTransactionUuid", required = false)
    String apiTransactionUuid;
    @Element(name = "requestUser", required = false)
    String requestUser;
    @Element(name = "fullName", required = false)
    String fullName;
    @Element(name = "birthDay", required = false)
    int birthDay;
    @Element(name = "birthMonth", required = false)
    int birthMonth;
    @Element(name = "birthYear", required = false)
    int birthYear;
    @Element(name = "birthPlace", required = false)
    String birthPlace;
    @Element(name = "gender", required = false)
    int gender;
    @Element(name = "address", required = false)
    String address;
    @Element(name = "tel", required = false)
    String tel;
    @Element(name = "tel2", required = false)
    String tel2;
    @Element(name = "email", required = false)
    String email;
    @Element(name = "facebook", required = false)
    String facebook;
    @Element(name = "specialBranchID", required = false)
    String specialBranchID;
    @Element(name = "schoolName", required = false)
    String schoolName;


    //LoginStudent
    @Element(name = "loginName", required = false)
    String loginName;
    @Element(name = "password", required = false)
    String password;

    //GetSubjectMark
    @Element(name = "studentCode", required = false)
    String studentCode;


    //String studentCode;

    //GetSchedule
    @Element(name = "yearID", required = false)
    int yearID;
    @Element(name = "semester", required = false)
    int semester;


}



