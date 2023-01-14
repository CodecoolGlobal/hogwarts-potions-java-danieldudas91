package com.codecool.hogwartspotions.service.DAO;

import com.codecool.hogwartspotions.model.Student;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
@Repository
public class StudentMemory implements StudentDAO {
    private Set<Student> students;

    public StudentMemory() {
        this.students = new HashSet<>();
    }

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public Student findStudentByName(String name) {
        return students.stream().filter(student -> student.getName().equals(name)).findFirst().orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Set<Student> getAllStudents() {
        return students;
    }
}
