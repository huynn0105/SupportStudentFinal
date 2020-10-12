package com.example.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SpecialBranch {

@SerializedName("SpecialBranchID")
@Expose
private String specialBranchID;
@SerializedName("SpecialBranchName")
@Expose
private String specialBranchName;
@SerializedName("SpecialBranchShortName")
@Expose
private String specialBranchShortName;
@SerializedName("BranchID")
@Expose
private String branchID;
@SerializedName("SpecialBranchNameEn")
@Expose
private Object specialBranchNameEn;

public String getSpecialBranchID() {
return specialBranchID;
}

public void setSpecialBranchID(String specialBranchID) {
this.specialBranchID = specialBranchID;
}

public String getSpecialBranchName() {
return specialBranchName;
}

public void setSpecialBranchName(String specialBranchName) {
this.specialBranchName = specialBranchName;
}

public String getSpecialBranchShortName() {
return specialBranchShortName;
}

public void setSpecialBranchShortName(String specialBranchShortName) {
this.specialBranchShortName = specialBranchShortName;
}

public String getBranchID() {
return branchID;
}

public void setBranchID(String branchID) {
this.branchID = branchID;
}

public Object getSpecialBranchNameEn() {
return specialBranchNameEn;
}

public void setSpecialBranchNameEn(Object specialBranchNameEn) {
this.specialBranchNameEn = specialBranchNameEn;
}

}