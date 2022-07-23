package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.*;
import java.util.Arrays;

@Configuration
public class StudentConfig //To save data
{

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository)
    {
        return args ->
        {
             Student sara = new Student(
                     1l,
                     "sara",
                     "sara.ss@gmaol.com",
                     2008
            );

            Student ayoub = new Student(
                    2l,
                    "ayoub",
                    "ayoub.ss@gmaol.com",
                    2001
            );

             repository.saveAll(
                     //List.of(sara, ayoub)
                     Arrays.asList(sara, ayoub)
             );
        };
    }
}
