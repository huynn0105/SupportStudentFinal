package com.example.Service.Request;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;


public class RequestModel {

    @Element(name = "partnerIdentity",required =  false)
    public String partnerIdentity;

    @Element(name = "signature",required =  false)
    public String signature;

    //GetLearningLevel
    @Element(name="learningLevelID",required =  false)
    public int learningLevelID;

    //GetTrainingLevel
    @Element(name="trainingLevelID",required =  false)
    public String trainingLevelID;

    //GetStudentCollection
    @Element(name="studentCollectionID",required =  false)
    public long studentCollectionID;

    @Element(name="keyWord",required =  false)
    public String keyWord;

    @Element(name="pageIndexForGet",required =  false)
    public int pageIndexForGet;

    @Element(name="topRow",required =  false)
    public int topRow;



    //CreateStudentCollectionResponse

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





    //Constructor

    //GetLearningLevel
    public RequestModel() {
        this.partnerIdentity = "";
        this.signature = "";
    }

    //GetTrainingLevel
    public RequestModel(String partnerIdentity, String signature, int learningLevelID) {
        this.partnerIdentity = partnerIdentity;
        this.signature = signature;
        this.learningLevelID = learningLevelID;
    }


    //GetSpecialBranch
    public RequestModel(String partnerIdentity, String signature, int learningLevelID, String trainingLevelID) {
        this.partnerIdentity = partnerIdentity;
        this.signature = signature;
        this.learningLevelID = learningLevelID;
        this.trainingLevelID = trainingLevelID;
    }

    //GetStudentCollection
    public RequestModel(String partnerIdentity, long studentCollectionID, String keyWord, String signature) {
        this.partnerIdentity = partnerIdentity;
        this.signature = signature;
        this.studentCollectionID = studentCollectionID;
        this.keyWord = keyWord;
        this.pageIndexForGet = 1;
        this.topRow = 1;
    }

    //CreateStudentCollection
    public RequestModel(String fullName, int birthDay, int birthMonth, int birthYear, String birthPlace,
                                 int gender, String address, String tel,String tel2, int learningLevelID, String trainingLevelID,
                                 String specialBranchID, String schoolName) {
        this.partnerIdentity = "";
        this.apiTransactionUuid = "";
        this.requestUser = "";
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.birthPlace = birthPlace;
        this.gender = gender;
        this.address = address;
        this.tel = tel;
        this.tel2 = tel2;
        this.email = "";
        this.facebook = "";
        this.learningLevelID = learningLevelID;
        this.trainingLevelID = trainingLevelID;
        this.specialBranchID = specialBranchID;
        this.schoolName = schoolName;
        this.signature = "";
    }
}



