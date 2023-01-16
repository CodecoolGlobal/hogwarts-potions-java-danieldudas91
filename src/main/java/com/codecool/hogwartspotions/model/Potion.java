package com.codecool.hogwartspotions.model;

import com.codecool.hogwartspotions.model.types.BrewingStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;
@Entity
@Data
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
        this.student = student;
        this.name = name;
    }
}
