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


    public int getLearningLevelID() {
        return LearningLevelID;
    }

    public String getLearningLevelName() {
        return LearningLevelName;
    }

    @Override
    public String toString() {
        return LearningLevelName;
    }

}

