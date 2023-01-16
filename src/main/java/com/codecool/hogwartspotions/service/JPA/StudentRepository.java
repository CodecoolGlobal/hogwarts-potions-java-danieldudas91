package com.codecool.hogwartspotions.service.JPA;

import com.codecool.hogwartspotions.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface StudentRepository extends CrudRepository<Student, Long> {
    Student findStudentByName(String name);

    List<Student> findAllByRoomId(Long roomId);

}
