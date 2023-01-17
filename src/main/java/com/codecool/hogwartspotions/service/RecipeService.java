package com.codecool.hogwartspotions.service;

import com.codecool.hogwartspotions.model.Potion;
import com.codecool.hogwartspotions.model.Recipe;
import com.codecool.hogwartspotions.service.JPA.PotionRepository;
import com.codecool.hogwartspotions.service.JPA.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecipeService {
    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    PotionRepository potionRepository;

    public List<Recipe> getRecipesIncludingSameIngredients(Long potionId) {
        Optional<Potion> potion = potionRepository.findById(potionId);
        List<Recipe> allRecipes = (List<Recipe>) recipeRepository.findAll();
        List<Recipe> matchingRecipes = new ArrayList<>();
        if (potion.isPresent()) {
            for (Recipe recipe : allRecipes) {
                if(new HashSet<>(recipe.getIngredients()).containsAll(potion.get().getIngredients())){
                    matchingRecipes.add(recipe);
                }
            }
            return matchingRecipes;
        }
        else{
            throw new NoSuchElementException("No potion found with given name");
        }
    }
}
