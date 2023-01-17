package com.codecool.hogwartspotions.service;

import com.codecool.hogwartspotions.model.Potion;
import com.codecool.hogwartspotions.model.Recipe;
import com.codecool.hogwartspotions.model.Student;
import com.codecool.hogwartspotions.service.JPA.PotionRepository;
import com.codecool.hogwartspotions.service.JPA.RecipeRepository;
import com.codecool.hogwartspotions.service.JPA.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class PotionService {
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private PotionRepository potionRepository;

    @Autowired
    private StudentRepository studentRepository;

    //TODO use optionals
    public List<Potion> getAllPotions(){
        return (List<Potion>) potionRepository.findAll();
    }
    public void addNewPotion(Potion potion){
        List<Recipe> recipes = (List<Recipe>) recipeRepository.findAll();
        int studentRecipesNumber = recipeRepository.findAllByStudent(potion.getStudent()).size();
        String potionName = potion.getStudent().getName() + "'s #" + studentRecipesNumber + " potion";
        potion.setUnique(recipes.stream().noneMatch(recipe -> recipe.hasSameIngredients(potion.getIngredients())));
        potion.determineStatus();
        potion.persistRecipe(potionName);
        if(potion.getRecipe() != null){
            recipeRepository.save(potion.getRecipe());
        }
        potionRepository.save(potion);
    }


    public List<Potion> getAllPotionsByStudent(Long studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        if(student.isPresent()){
            return potionRepository.findAllByStudent(student.get());
        }
        else{
            throw new NoSuchElementException("No student found with given id");
        }
    }
}
