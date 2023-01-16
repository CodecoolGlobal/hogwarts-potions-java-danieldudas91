package com.codecool.hogwartspotions.service.JPA;

import com.codecool.hogwartspotions.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
