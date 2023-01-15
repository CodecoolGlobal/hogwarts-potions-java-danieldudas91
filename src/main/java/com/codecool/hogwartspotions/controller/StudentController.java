package com.codecool.hogwartspotions.controller;

import com.codecool.hogwartspotions.model.Student;
import com.codecool.hogwartspotions.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
@CrossOrigin("*")
@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/student/all")
    public List<Student> getAllStudents(){
        System.out.println(studentService.getAllStudents());
        return studentService.getAllStudents();
    }
    @PostMapping("/student/add")
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

}
