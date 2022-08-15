package com.etiya.northwind.BusinessTests;

import com.etiya.northwind.Business.Abstracts.Student;
import com.etiya.northwind.Business.Abstracts.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceTest {
    StudentService studentService;


    @BeforeEach
    public void setup(){
        studentService=new StudentService();

    }

    @Test
    public void AddStudentTest(){
        //arrange
        Student student1=new Student(1,"ahmet");

        //act
        studentService.StudentAdd(student1);

        //assert
        Assertions.assertEquals(student1.getName(),studentService.students.get(studentService.students.size()-1).getName());
    }
}
