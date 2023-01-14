package com.codecool.hogwartspotions.service.DAO;

import com.codecool.hogwartspotions.model.Student;

import java.util.Set;

public interface StudentDAO {
    void addStudent(Student student);
    Student findStudentByName(String name);
    Set<Student> getAllStudents();

}
