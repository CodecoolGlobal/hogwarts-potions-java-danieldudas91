package com.codecool.hogwartspotions.controller;

import com.codecool.hogwartspotions.model.Student;
import com.codecool.hogwartspotions.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
@CrossOrigin("*")
@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/student/all")
    public Set<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @PostMapping("/student/add")
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }
    @PostMapping("student/assign/{name}")
    public void assignStudentToRoom(@PathVariable String name){
        Student student = studentService.findStudentByName(name);
        studentService.assignStudentToRoom(student);
    }
}