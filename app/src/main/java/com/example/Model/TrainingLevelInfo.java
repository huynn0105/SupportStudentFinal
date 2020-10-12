package com.example.Model;



import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


@Root(name = "TrainingLevelInfo")
public class TrainingLevelInfo {

    @Element(name = "TrainingLevelID",required = false)
    private String TrainingLevelID;

    @Element(name = "TrainingLevelName",required = false)
    private String TrainingLevelName;

    @Element(name = "ErrorCode", required = false)
    private int ErrorCode;

    @Element(name = "ErrorDesc", required = false)
    private String ErrorDesc;

    public String getErrorDesc() {
        return ErrorDesc;
    }

    public void setErrorDesc(String ErrorDesc) {
        this.ErrorDesc = ErrorDesc;
    }

    public String getTrainingLevelName() {
        return TrainingLevelName;
    }

    public void setTrainingLevelName(String TrainingLevelName) {
        this.TrainingLevelName = TrainingLevelName;
    }

    public int getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(int ErrorCode) {
        this.ErrorCode = ErrorCode;
    }

    public String getTrainingLevelID() {
        return TrainingLevelID;
    }

    public void setTrainingLevelID(String TrainingLevelID) {
        this.TrainingLevelID = TrainingLevelID;
    }

    @Override
    public String toString() {
        return getTrainingLevelName();
    }
}