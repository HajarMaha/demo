package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService
{
    private final StudentRepository studentRepository;

    @Autowired //To get our dependencies
    public StudentService(StudentRepository studentRepository) // Contructor
    {
        this.studentRepository = studentRepository;
    }

    /*public void addNewStudent(Student student)
    {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent())
        {
            throw new IllegalStateException("Email alredy exists !!");
        }
        studentRepository.save(student);
        System.out.println(student);
    }


    public List<Student> getStudent() //method to display data that is coming from the repository
    {
        return studentRepository.findAll();
        //return Arrays.asList(new Student("1nn", "hajar", "hajar@bbgmail.com)", "22"));
    }

    public void deleteStudent(Long studentId)
    {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists)
        {
            throw new IllegalStateException("Id dosn't exists !!");
        }
        studentRepository.deleteById(studentId);
    }*/

    //Ajouter
    public void addStudent(Student student)
    {
        //student.setId(UUID.randomUUID().toString());
        studentRepository.save(student);
    }

    //Afficher
    public List<Student> getStudent() //method to display data that is coming from the repository
    {
        return studentRepository.findAll();
    }

    /*public List<Student> findStudent(Long id) //method to display data that is coming from the repository
    {
        return studentRepository.findAll();
    }*/

    //Update
    public void updateStudent(Student student)
    {
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId)
    {
        studentRepository.deleteStudentById(studentId);
    }

    public List<Student> findStudent(Long id)
    {
        //Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getId());

        /*if(studentByEmail.isPresent())
        {
            throw new EntityNotFoundException("Id not found !!");
        }*/
        studentRepository.findById(id);
        return studentRepository.findAll();
        //System.out.println(student);
    }
}
