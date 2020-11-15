package com.example.Service.Request;

import com.example.Model.StudentCollectionInfo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;


@NamespaceList({
        @Namespace(reference = "http://thienhaso.com/")
})
public class RequestBody {

    @Element(name = "GetLearningLevel",required = false)
    public RequestModel GetLearningLevel;

    @Element(name = "GetTrainingLevel",required = false)
    public RequestModel GetTrainingLevel;

    @Element(name = "GetSpecialBranch",required = false)
    public RequestModel GetSpecialBranch;

    @Element(name = "CreateStudentCollection",required = false)
    public RequestModel CreateStudentCollection;

    @Element(name = "GetStudentCollection",required = false)
    public RequestModel GetStudentCollection;

    @Element(name ="LoginStudent",required = false)
    public RequestModel LoginStudent;

    @Element(name ="GetSubjectMark",required = false)
    public RequestModel GetSubjectMark;



    @Element(name ="GetSchedule",required = false)
    public RequestModel GetSchedule;
}
