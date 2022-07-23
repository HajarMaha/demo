package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController
{
    private final StudentService studentService; // declarer une variable de la classe StudentService

    @Autowired
    public StudentController(StudentService studentService) //Constructor
    {
        this.studentService = studentService; // not working without dependencies
        //this.studentService = new studentService; // working, but we should avoid it
    }

    /*@GetMapping //GET to just get data
    public List<Student> getStudent() //Method
    {
        //return Arrays.asList(new Student("1nn", "hajar", "hajar@bbgmail.com)", "22"));
        return studentService.getStudent(); // call the methode getStudent from the class StudentService
    }

    @PostMapping //POST to insert and save data
    public void registerNewStudent(@RequestBody Student student) //Take the data from the request body and insert it in student
    {
        //StudentService studentService1 = new StudentService().addNewStudent(student);
        //studentService.addNewStudent(student);
        studentService.addStudent(student);
    }

    @DeleteMapping(path = {"studentId"}) //DELETE
    public void deleteStudent(@PathVariable("studenId") Long studentId)
    {
        studentService.deleteStudent(studentId); //Cette methode n'existe pas, on doit le definir
    }*/

    @GetMapping("/all")
    public List<Student> getStudent() //Method
    {
        return studentService.getStudent(); // call the methode getStudent from the class StudentService
    }

    @GetMapping("/find/{id}")
    public List<Student> findStudent(@PathVariable("id") Long id) //so that the id of the method matches the id of the url
    {
        //return studentService.findStudent(id);
        return studentService.findStudent(id);
    }

    @PostMapping("/add")
    public void addStudent(@RequestBody Student student)
    {
        studentService.addStudent(student);
    }
}
