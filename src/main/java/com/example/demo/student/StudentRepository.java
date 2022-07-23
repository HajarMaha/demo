package com.example.demo.student;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
//for data access layer
public interface StudentRepository extends JpaRepository<Student, Long> //We specify the the class, in this case it's Student + the type of the primary key
{
    //@Query("SELECT s FROM Student s where s.email=?1 "); //we can use this to retrive data or the line just below
    Optional<Student> findStudentByEmail(Long id);

    //On declare
    //void deleteStudent(Long id);

    Student deleteStudentById(Long id);

    //Student findBtId(Long studentId);
}
