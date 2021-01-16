package com.example.springbootsoapexample;

import com.example.springbootsoapexample.student.GetResponse;
import com.example.springbootsoapexample.student.GetStudent;
import com.example.springbootsoapexample.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class StudentEndpoint {

    private StudentService studentService;

    @Autowired
    public StudentEndpoint(StudentService studentService) {
        this.studentService = studentService;
    }

    @PayloadRoot(namespace = "http://example.com/soap-example", localPart = "getStudent")
    @ResponsePayload
    public GetResponse getStudentById(@RequestPayload GetStudent getStudent){
        Student studentById = studentService.getStudentById(getStudent.getId());
        GetResponse getResponse=new GetResponse();
        getResponse.setStudent(studentById);
        return getResponse;
    }
}
