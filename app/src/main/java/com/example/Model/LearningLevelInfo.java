package com.example.Model;



import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "LearningLevelInfo")
public class LearningLevelInfo {
    @Element(name = "LearningLevelID")
    int LearningLevelID;

    @Element(name = "LearningLevelName")
    String LearningLevelName;

    @Element(name = "ErrorCode",required = false)
    int ErrorCode;

    @Element(name = "ErrorDesc",required = false)
    String ErrorDesc;

    public LearningLevelInfo(int learningLevelID, String learningLevelName) {
        LearningLevelID = learningLevelID;
        LearningLevelName = learningLevelName;
    }

    public LearningLevelInfo() {
    }

    public int getLearningLevelID() {
        return LearningLevelID;
    }

    public void setLearningLevelID(int learningLevelID) {
        LearningLevelID = learningLevelID;
    }

    public String getLearningLevelName() {
        return LearningLevelName;
    }

    public void setLearningLevelName(String learningLevelName) {
        LearningLevelName = learningLevelName;
    }

    public int getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(int errorCode) {
        ErrorCode = errorCode;
    }

    public String getErrorDesc() {
        return ErrorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        ErrorDesc = errorDesc;
    }

    @Override
    public String toString() {
        return getLearningLevelName();
    }

}

