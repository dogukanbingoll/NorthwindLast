package com.etiya.northwind.Business.Abstracts;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    public List<Student> students=new ArrayList();
    public StudentService(){
        students.add(new Student(1,"Hasan"));
        students.add(new Student(2,"Mert"));
        students.add(new Student(3,"Dogukan"));
        students.add(new Student(4,"ahmet"));
    }
    public void StudentAdd(Student student){
        CheckName(student);
        students.add(student);
    }
    public void CheckName(Student student1){
        for(Student student:students){
            if(student.getName().equals(student1.getName()))
                throw new RuntimeException("Kullanıcı kayıtlı");
        }
    }
}
