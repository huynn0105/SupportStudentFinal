package com.example.Model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "SpecialBranchInfo")
public class SpecialBranchInfo {
    @Element(name = "SpecialBranchID")
    private String SpecialBranchID;

    @Element(name = "Weblink", required = false)
    private String Weblink;

    @Element(name = "ErrorDesc", required = false)
    private String ErrorDesc;

    @Element(name = "SpecialBranchShortName", required = false)
    private String SpecialBranchShortName;

    @Element(name = "ErrorCode", required = false)
    private String ErrorCode;

    @Element(name = "SpecialBranchName")
    private String SpecialBranchName;

    public String getSpecialBranchID() {
        return SpecialBranchID;
    }

    public void setSpecialBranchID(String SpecialBranchID) {
        this.SpecialBranchID = SpecialBranchID;
    }

    public String getWeblink() {
        return Weblink;
    }

    public void setWeblink(String Weblink) {
        this.Weblink = Weblink;
    }

    public String getErrorDesc() {
        return ErrorDesc;
    }

    public void setErrorDesc(String ErrorDesc) {
        this.ErrorDesc = ErrorDesc;
    }

    public String getSpecialBranchShortName() {
        return SpecialBranchShortName;
    }

    public void setSpecialBranchShortName(String SpecialBranchShortName) {
        this.SpecialBranchShortName = SpecialBranchShortName;
    }

    public String getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(String ErrorCode) {
        this.ErrorCode = ErrorCode;
    }

    public String getSpecialBranchName() {
        return SpecialBranchName;
    }

    public void setSpecialBranchName(String SpecialBranchName) {
        this.SpecialBranchName = SpecialBranchName;
    }

    @Override
    public String toString() {
        return getSpecialBranchName();
    }
}