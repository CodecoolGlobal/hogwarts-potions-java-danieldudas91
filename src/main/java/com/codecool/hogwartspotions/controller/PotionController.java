package com.codecool.hogwartspotions.controller;

import com.codecool.hogwartspotions.model.HouseManagerDTO;
import com.codecool.hogwartspotions.model.Ingredient;
import com.codecool.hogwartspotions.model.Potion;
import com.codecool.hogwartspotions.model.Student;
import com.codecool.hogwartspotions.service.IngredientService;
import com.codecool.hogwartspotions.service.PotionService;
import com.codecool.hogwartspotions.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PotionController {
    @Autowired
    PotionService potionService;
    @Autowired
    StudentService studentService;
    @Autowired
    IngredientService ingredientService;

    @GetMapping("/potions")
    public List<Potion> getAllPotions(){
        return potionService.getAllPotions();
    }

    @PostMapping("/potions")
    public void addNewPotion(@RequestBody HouseManagerDTO houseManagerDTO){
        Student student = studentService.findStudentByName(houseManagerDTO.getStudentName());
        List<Ingredient> ingredients = new ArrayList<>();
        houseManagerDTO.getIngredientNames()
                .forEach(ingredient -> ingredients.add(new Ingredient(ingredient)));
        if(student != null){
            Potion potion = new Potion(houseManagerDTO.getPotionName(), student, ingredients);
            potionService.addNewPotion(potion);
        }
        else {
            throw new RuntimeException("No such student in list!");
        }
    }
}