package com.example.Model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@Root(name = "ScheduleInfo")
public class ScheduleInfo {
    @Element(name = "ClassID", required = false)
    String ClassID;
    @Element(name = "ClassTitle", required = false)
    String ClassTitle;
    @Element(name = "SubjectID", required = false)
    String SubjectID;
    @Element(name = "SubjectName", required = false)
    String SubjectName;
    @Element(name = "TotalQuantity", required = false)
    int TotalQuantity;
    @Element(name = "TeacherID", required = false)
    String TeacherID;
    @Element(name = "TeacherName", required = false)
    String TeacherName;
    @Element(name = "RoomID", required = false)
    String RoomID;
    @Element(name = "RoomName", required = false)
    String RoomName;
    @Element(name = "DayText", required = false)
    int DayText;
    @Element(name = "TimeText", required = false)
    String TimeText;
    @Element(name = "StartWeek", required = false)
    int StartWeek;
    @Element(name = "EndWeek", required = false)
    int EndWeek;
    @Element(name = "StartDate", required = false)
    String StartDate;
    @Element(name = "EndDate", required = false)
    String EndDate;
    @Element(name = "ErrorCode", required = false)
    int ErrorCode;
    @Element(name = "ErrorDesc", required = false)
    String ErrorDesc;
}
