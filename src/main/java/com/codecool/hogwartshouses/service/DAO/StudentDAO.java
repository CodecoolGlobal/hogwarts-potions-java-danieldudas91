package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.model.Student;

import java.util.Set;

public interface StudentDAO {
    void addStudent(Student student);
    Student findStudentByName(String name);
    Set<Student> getAllStudents();

}
