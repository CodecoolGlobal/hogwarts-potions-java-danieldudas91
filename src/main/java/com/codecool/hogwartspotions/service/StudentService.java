package com.codecool.hogwartspotions.service;

import com.codecool.hogwartspotions.model.Student;
import com.codecool.hogwartspotions.service.DAO.RoomDAO;
import com.codecool.hogwartspotions.service.DAO.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class StudentService {
    @Autowired
    StudentDAO studentDAO;
    @Autowired
    RoomDAO roomDAO;

    public void addStudent(Student student) {
        studentDAO.addStudent(student);
    }

    public void assignStudentToRoom(Student student) {
        roomDAO.assignStudentToRoom(student);
    }

    public Set<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    public Student findStudentByName(String name) {
        return studentDAO.findStudentByName(name);
    }
}
