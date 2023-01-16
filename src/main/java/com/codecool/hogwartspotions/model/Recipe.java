package com.codecool.hogwartspotions.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;
@Entity
@Data
@NoArgsConstructor
@Table(name="recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "student_recipe_id")
    private Student student;
    @OneToMany
    @JoinColumn(name = "recipe_id", referencedColumnName = "id")
    private List<Ingredient> ingredients;

    public Recipe(String name, Student student, List<Ingredient> ingredients) {
        this.name = name;
        this.student = student;
        this.ingredients = ingredients;
        joinStudent();
        joinIngredients();
    }

    public void joinStudent(){
        this.student.setRecipeId(id);
    }
    public void joinIngredients(){
        ingredients.forEach(ingredient -> ingredient.setRecipeId(id));
    }
}
