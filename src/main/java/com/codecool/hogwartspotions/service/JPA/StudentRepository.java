package com.codecool.hogwartspotions.service.JPA;

import com.codecool.hogwartspotions.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface StudentRepository extends CrudRepository<Student, UUID> {
}
