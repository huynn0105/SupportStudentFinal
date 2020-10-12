package com.example.Model;

public class FunctionModel {
    String functionName;
    int resourceId;

    public FunctionModel(String functionName, int resourceId) {
        this.functionName = functionName;
        this.resourceId = resourceId;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
}
