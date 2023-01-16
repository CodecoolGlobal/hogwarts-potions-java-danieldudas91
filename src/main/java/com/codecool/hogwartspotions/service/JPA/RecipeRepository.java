package com.codecool.hogwartspotions.service.JPA;

import com.codecool.hogwartspotions.model.Recipe;
import com.codecool.hogwartspotions.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    List<Recipe> findAllByStudent(Student student);
}
