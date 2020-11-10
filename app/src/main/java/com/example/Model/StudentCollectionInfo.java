package com.example.Model;

import org.simpleframework.xml.Element;

import java.io.Serializable;

public class StudentCollectionInfo implements Serializable {
    @Element(name = "StudentCollectionID", required = false)
    String StudentCollectionID;
    @Element(name = "FullName", required = false)
    String FullName;
    @Element(name = "BirthDay", required = false)
    int BirthDay;
    @Element(name = "BirthMonth", required = false)
    int BirthMonth;
    @Element(name = "BirthYear", required = false)
    int BirthYear;
    @Element(name = "BirthDateText", required = false)
    String BirthDateText;
    @Element(name = "BirthPlace", required = false)
    String BirthPlace;
    @Element(name = "Address", required = false)
    String Address;
    @Element(name = "Tel", required = false)
    String Tel;
    @Element(name = "Tel2", required = false)
    String Tel2;
    @Element(name = "Email", required = false)
    String Email;
    @Element(name = "Facebook", required = false)
    String Facebook;
    @Element(name = "LearningLevelID", required = false)
    int LearningLevelID;
    @Element(name = "TrainingLevelID", required = false)
    String TrainingLevelID;
    @Element(name = "SpecialBranchID", required = false)
    String SpecialBranchID;
    @Element(name = "schoolName", required = false)
    String schoolName;
    @Element(name = "CreatedDate", required = false)
    String CreatedDate;
    @Element(name = "IsRegisterOnline", required = false)
    boolean IsRegisterOnline;
    @Element(name = "StudentCollectionStatusID", required = false)
    int StudentCollectionStatusID;
    @Element(name = "ErrorCode", required = false)
    int ErrorCode;
    @Element(name = "ErrorDesc", required = false)
    String ErrorDesc;

    @Override
    public String toString() {
        return "StudentCollectionInfo{" +
                "StudentCollectionID='" + StudentCollectionID + '\'' +
                ", FullName='" + FullName + '\'' +
                ", BirthDay=" + BirthDay +
                ", BirthMonth=" + BirthMonth +
                ", BirthYear=" + BirthYear +
                ", BirthDateText='" + BirthDateText + '\'' +
                ", BirthPlace='" + BirthPlace + '\'' +
                ", Address='" + Address + '\'' +
                ", Tel='" + Tel + '\'' +
                ", DateTime='" + CreatedDate + '\'' +
                ", Tel2='" + Tel2 + '\'' +
                ", Email='" + Email + '\'' +
                ", Facebook='" + Facebook + '\'' +
                ", LearningLevelID=" + LearningLevelID +
                ", TrainingLevelID='" + TrainingLevelID + '\'' +
                ", SpecialBranchID='" + SpecialBranchID + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", IsRegisterOnline=" + IsRegisterOnline +
                ", StudentCollectionStatusID=" + StudentCollectionStatusID +
                ", ErrorCode=" + ErrorCode +
                ", ErrorDesc='" + ErrorDesc + '\'' +
                '}';
    }

    public String getStudentCollectionID() {
        return StudentCollectionID;
    }

    public void setStudentCollectionID(String studentCollectionID) {
        StudentCollectionID = studentCollectionID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public int getBirthDay() {
        return BirthDay;
    }

    public void setBirthDay(int birthDay) {
        BirthDay = birthDay;
    }

    public int getBirthMonth() {
        return BirthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        BirthMonth = birthMonth;
    }

    public int getBirthYear() {
        return BirthYear;
    }

    public void setBirthYear(int birthYear) {
        BirthYear = birthYear;
    }

    public String getBirthDateText() {
        return BirthDateText;
    }

    public void setBirthDateText(String birthDateText) {
        BirthDateText = birthDateText;
    }

    public String getBirthPlace() {
        return BirthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        BirthPlace = birthPlace;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }
    public String getTel2() {
        return Tel2;
    }

    public void setTel2(String tel2) {
        Tel2 = tel2;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFacebook() {
        return Facebook;
    }

    public void setFacebook(String facebook) {
        Facebook = facebook;
    }

    public int getLearningLevelID() {
        return LearningLevelID;
    }

    public void setLearningLevelID(int learningLevelID) {
        LearningLevelID = learningLevelID;
    }

    public String getTrainingLevelID() {
        return TrainingLevelID;
    }

    public void setTrainingLevelID(String trainingLevelID) {
        TrainingLevelID = trainingLevelID;
    }

    public String getSpecialBranchID() {
        return SpecialBranchID;
    }

    public void setSpecialBranchID(String specialBranchID) {
        SpecialBranchID = specialBranchID;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public boolean isRegisterOnline() {
        return IsRegisterOnline;
    }

    public void setRegisterOnline(boolean registerOnline) {
        IsRegisterOnline = registerOnline;
    }

    public int getStudentCollectionStatusID() {
        return StudentCollectionStatusID;
    }

    public void setStudentCollectionStatusID(int studentCollectionStatusID) {
        StudentCollectionStatusID = studentCollectionStatusID;
    }

    public int getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(int errorCode) {
        ErrorCode = errorCode;
    }

    public String getErrorDesc() {
        return ErrorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        ErrorDesc = errorDesc;
    }
}
