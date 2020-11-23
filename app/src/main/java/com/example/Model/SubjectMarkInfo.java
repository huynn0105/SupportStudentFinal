package com.example.Model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Root(name = "SubjectMarkInfo")
public class SubjectMarkInfo implements Serializable {
    @Element(name = "StudentID", required = false)
    long StudentID;
    @Element(name = "SubjectID", required = false)
    String SubjectID;
    @Element(name = "SubjectName", required = false)
    String SubjectName;
    @Element(name = "UnitText", required = false)
    int UnitText;
    @Element(name = "YearID", required = false)
    int YearID;
    @Element(name = "Semester", required = false)
    int Semester;
    @Element(name = "TestAverage", required = false)
    float TestAverage;
    @Element(name = "Exam1", required = false)
    float Exam1;
    @Element(name = "Exam2", required = false)
    float Exam2;
    @Element(name = "Summary1", required = false)
    float Summary1;
    @Element(name = "Summary2", required = false)
    float Summary2;
    @Element(name = "FinalSummary", required = false)
    float FinalSummary;
    @Element(name = "Passed", required = false)
    boolean Passed;
    @Element(name = "PassedText", required = false)
    String PassedText;
    @Element(name = "ErrorCode", required = false)
    int ErrorCode;
    @Element(name = "ErrorDesc", required = false)
    String ErrorDesc;
}
