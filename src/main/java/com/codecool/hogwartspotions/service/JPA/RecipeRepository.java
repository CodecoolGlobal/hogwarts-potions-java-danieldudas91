package com.codecool.hogwartspotions.service.JPA;

import com.codecool.hogwartspotions.model.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
