package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController
{
    private final StudentService studentService; // declarer une variable de la classe StudentService

    @Autowired
    public StudentController(StudentService studentService)
    {
        this.studentService = studentService; // not working without dependencies
        //this.studentService = new studentService; // working, but we should avoid it
    }

    @GetMapping
    public List<Student> getStudent()
    {
        //return Arrays.asList(new Student("1nn", "hajar", "hajar@bbgmail.com)", "22"));
        return studentService.getStudent(); // call the methode getStudent from the class StudentService
    }
}
