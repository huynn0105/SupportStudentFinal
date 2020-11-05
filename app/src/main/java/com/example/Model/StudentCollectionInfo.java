package com.example.Model;

import org.simpleframework.xml.Element;

public class StudentCollectionInfo {
    @Element(name = "partnerIdentity", required = false)
    String partnerIdentity;
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
    @Element(name = "learningLevelID", required = false)
    int learningLevelID;
    @Element(name = "trainingLevelID", required = false)
    int trainingLevelID;
    @Element(name = "specialBranchID", required = false)
    String specialBranchID;
    @Element(name = "schoolName", required = false)
    String schoolName;
    @Element(name = "signature", required = false)
    String signature;




}
