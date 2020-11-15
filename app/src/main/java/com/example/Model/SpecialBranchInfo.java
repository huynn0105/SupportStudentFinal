package com.example.Model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
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

    @Override
    public String toString() {
        return SpecialBranchName;
    }
}