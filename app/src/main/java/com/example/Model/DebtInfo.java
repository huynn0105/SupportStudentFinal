package com.example.Model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Root(name = "DebtInfo")
public class DebtInfo {
    @Element(name = "StudentCode", required = false)
    String StudentCode;
    @Element(name = "Fullname", required = false)
    String Fullname;
    @Element(name = "ReceiptSegmentID", required = false)
    String ReceiptSegmentID;
    @Element(name = "ReceiptSegmentName", required = false)
    String ReceiptSegmentName;
    @Element(name = "Year", required = false)
    int Year;
    @Element(name = "Semester", required = false)
    int Semester;
    @Element(name = "Money", required = false)
    long Money;
    @Element(name = "ErrorCode", required = false)
    int ErrorCode;
    @Element(name = "ErrorDesc", required = false)
    String ErrorDesc;
}
