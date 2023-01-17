package com.codecool.hogwartspotions.service.JPA;

import com.codecool.hogwartspotions.model.Potion;
import com.codecool.hogwartspotions.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PotionRepository extends CrudRepository<Potion, Long> {
    List<Potion> findAllByStudent(Student student);
}
