package com.example.Service.Response;

import org.simpleframework.xml.Element;

public class ResponseEnvelope {
    @Element(name = "Body")
    public ResponseBody responseBody;
}
