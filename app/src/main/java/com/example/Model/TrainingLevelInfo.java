package com.example.Model;


import org.simpleframework.xml.Element;

public class TrainingLevel {
@Element(name="TrainingLevelID")
private String trainingLevelID;

@Element(name="trainingLevelName")
private String trainingLevelName;

@Element(name ="")
private int learningLevel;

public String getTrainingLevelID() {
return trainingLevelID;
}

public void setTrainingLevelID(String trainingLevelID) {
this.trainingLevelID = trainingLevelID;
}

public String getTrainingLevelName() {
return trainingLevelName;
}

public void setTrainingLevelName(String trainingLevelName) {
this.trainingLevelName = trainingLevelName;
}

public Integer getLearningLevel() {
return learningLevel;
}

public void setLearningLevel(Integer learningLevel) {
this.learningLevel = learningLevel;
}

}