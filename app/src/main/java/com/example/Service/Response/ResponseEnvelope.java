package com.example.Service.Response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

public class ResponseEnvelope {
    @Element(name = "Body")
    public ResponseBody responseBody;


}
