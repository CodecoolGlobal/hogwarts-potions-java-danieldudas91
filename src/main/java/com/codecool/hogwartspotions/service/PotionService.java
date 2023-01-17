package com.codecool.hogwartspotions.service;

import com.codecool.hogwartspotions.model.Ingredient;
import com.codecool.hogwartspotions.model.Potion;
import com.codecool.hogwartspotions.model.Recipe;
import com.codecool.hogwartspotions.model.Student;
import com.codecool.hogwartspotions.service.JPA.IngredientRepository;
import com.codecool.hogwartspotions.service.JPA.PotionRepository;
import com.codecool.hogwartspotions.service.JPA.RecipeRepository;
import com.codecool.hogwartspotions.service.JPA.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private IngredientRepository ingredientRepository;

    //TODO use optionals
    public List<Potion> getAllPotions(){
        return (List<Potion>) potionRepository.findAll();
    }
    public void addNewPotion(Potion potion){
        List<Recipe> recipes = (List<Recipe>) recipeRepository.findAll();
        int studentRecipesNumber = recipeRepository.findAllByStudent(potion.getStudent()).size();
        String recipeName = potion.getStudent().getName() + "'s #" + studentRecipesNumber + " potion";
        potion.setUnique(recipes.stream().noneMatch(recipe -> recipe.hasSameIngredients(potion.getIngredients())));
        potion.determineStatus();
        potion.persistRecipe(recipeName);
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

    public void beginBrewing(Long studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        List<Recipe> recipes = (List<Recipe>) recipeRepository.findAll();

        if(student.isPresent()){
            //TODO use random generated names
            String potionName = "new potion";
            List<Ingredient> emptyIngredientList = new ArrayList<>();
            Potion potion = new Potion(potionName, student.get(), emptyIngredientList);
            //TODO extract method
            int studentRecipesNumber = recipeRepository.findAllByStudent(potion.getStudent()).size();
            String recipeName = potion.getStudent().getName() + "'s #" + studentRecipesNumber + " potion";
            potion.setUnique(recipes.stream().noneMatch(recipe -> recipe.hasSameIngredients(potion.getIngredients())));
            potion.determineStatus();
            potion.persistRecipe(recipeName);
            potionRepository.save(potion);
        }
        else{
            throw new NoSuchElementException("No student found with given id");
        }
    }

    public void addIngredientToPotion(Long potionId, Ingredient ingredient) {
        Optional<Potion> potion = potionRepository.findById(potionId);
        if(ingredient.getId() == null){
            ingredientRepository.save(ingredient);
        }
        if(potion.isPresent()){
            potion.get().addIngredient(ingredient);
            potionRepository.save(potion.get());
        }
        else{
            throw new NoSuchElementException("No student found with given id");
        }

    }
}
