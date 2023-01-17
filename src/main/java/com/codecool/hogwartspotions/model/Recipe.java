package com.codecool.hogwartspotions.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.*;
@Entity
@Data
@ToString(exclude = {"potion"})
@NoArgsConstructor
@Table(name="recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "recipe")
    @JsonIgnore
    private Potion potion;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    @JsonIgnore
    private Student student;
    @OneToMany(mappedBy = "recipe")
    private List<Ingredient> ingredients;

    public Recipe(String name, Student student, List<Ingredient> ingredients) {
        addIngredients(ingredients);
        this.name = name;
        this.student = student;
    }

    public void addIngredients(List<Ingredient> ingredients){
        this.ingredients =ingredients;
        ingredients.forEach(ingredient -> ingredient.setRecipe(this));
    }

    public boolean hasSameIngredients(List<Ingredient> ingredients){
        this.ingredients.sort(Comparator.comparing(Ingredient::getName));
        ingredients.sort(Comparator.comparing(Ingredient::getName));
        return this.ingredients.equals(ingredients);
    }
}
