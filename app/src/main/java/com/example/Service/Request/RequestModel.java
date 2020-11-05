package com.example.Service.Request;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;


public class RequestModel {

    @Element(name = "partnerIdentity",required =  false)
    public String partnerIdentity;

    @Element(name = "signature",required =  false)
    public String signature;

    @Element(name="learningLevelID",required =  false)
    public int learningLevelID;

    @Element(name="trainingLevelID",required =  false)
    public String trainingLevelID;


}



