package com.example.Model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Root(name = "StudentInfo")
public class StudentInfo implements Serializable {
    @Element(name = "StudentID", required = false)
    long StudentID;
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
    @Element(name = "LiveAddress", required = false)
    String LiveAddress;
    @Element(name = "Tel", required = false)
    String Tel;
    @Element(name = "ContactTel", required = false)
    String ContactTel;
    @Element(name = "Email", required = false)
    String Email;
    @Element(name = "Facebook", required = false)
    String Facebook;
    @Element(name = "ClassID", required = false)
    String ClassID;
    @Element(name = "CreatedDate", required = false)
    String CreatedDate;
    @Element(name = "ErrorCode", required = false)
    int ErrorCode;
    @Element(name = "ErrorDesc", required = false)
    String ErrorDesc;
}
