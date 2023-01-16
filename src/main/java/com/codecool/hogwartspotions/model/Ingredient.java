package com.codecool.hogwartspotions.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="ingredients")
public class Ingredient {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "recipe_id")
    private Long recipeId;
    private String name;

    public Ingredient(String name) {
        this.name = name;
    }
}
