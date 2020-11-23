package com.example.Model;

import org.simpleframework.xml.Element;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class StudentCollectionInfo implements Serializable {
    @Element(name = "StudentCollectionID", required = false)
    long StudentCollectionID;
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


}
