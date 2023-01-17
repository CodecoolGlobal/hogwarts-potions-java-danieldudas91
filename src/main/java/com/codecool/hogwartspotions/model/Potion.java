package com.codecool.hogwartspotions.model;

import com.codecool.hogwartspotions.model.types.BrewingStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.*;
@Entity
@Data
@ToString(exclude = "ingredients")
@NoArgsConstructor
@Table(name = "potions")
public class Potion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "potion", cascade = CascadeType.ALL)
    private List<Ingredient> ingredients;
    @Enumerated(EnumType.STRING)
    @Column(name="brewing_status")
    private BrewingStatus brewingStatus;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_id", referencedColumnName = "id")
    private Recipe recipe;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;
    @Column(name = "is_uniq")
    private boolean unique;

    public Potion(String name, Student student, List<Ingredient> ingredients) {
        addIngredients(ingredients);
        this.student = student;
        this.name = name;
    }

    public void addIngredients(List<Ingredient> ingredients){
        ingredients.forEach(ingredient -> ingredient.setPotion(this));
        this.ingredients =ingredients;
    }

    public void determineStatus(){
        if(ingredients.size() < 5){
             this.brewingStatus = BrewingStatus.BREW;
        }
        else{
            if(this.unique){
                 this.brewingStatus = BrewingStatus.DISCOVERY;
            }
            else {
                 this.brewingStatus = BrewingStatus.REPLICA;
            }
        }
    }
    public void persistRecipe(String recipeName){
        if(this.brewingStatus.equals(BrewingStatus.DISCOVERY)){
            this.recipe = new Recipe(recipeName, this.student, this.ingredients);
        }
    }
}
