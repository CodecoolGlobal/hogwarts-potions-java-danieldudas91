package com.codecool.hogwartspotions.service;

import com.codecool.hogwartspotions.model.Student;
import com.codecool.hogwartspotions.service.DAO.RoomDAO;
import com.codecool.hogwartspotions.service.DAO.StudentDAO;
import com.codecool.hogwartspotions.service.JPA.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student) {
        studentRepository.save(student);
    }


    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    public Student findStudentByName(String name) {
        return studentRepository.findStudentByName(name);
    }
}
