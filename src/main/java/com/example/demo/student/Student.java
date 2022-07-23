package com.example.demo.student;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@Entity
public class Student
{
    @Id
    @SequenceGenerator(
            name = "stud_sequence",
            sequenceName = "stud_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "stud_sequence"
    )
    @Column(
            name = "id",
            nullable = false
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    @Column(
            name = "email",
            nullable = false,
            unique = true
    )
    private String email;

    @Column(
            name = "age",
            nullable = false
    )
    //private LocalDate dob;
    @Transient
    private int age;

    @Column(
            name = "yob",
            nullable = false
    )
    private int yob;

    public Student(Long id, String name, String email, int yob)
    {
        this.id=id;
        this.name=name;
        this.email=email;
        //this.dob=dob;
        this.yob=yob;
    }

    public Student()
    {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }*/

    public int getAge() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int a = year - this.yob;
        return a;
        //return Period.between(this.yob, year);
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", yob=" + yob +
                '}';
    }
}
