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

    public String getTrainingLevelName() {
        return TrainingLevelName;
    }

    public String getTrainingLevelID() {
        return TrainingLevelID;
    }


    @Override
    public String toString() {
        return TrainingLevelName;
    }
}