package com.codecool.hogwartspotions.model;

import com.codecool.hogwartspotions.model.types.HouseType;
import com.codecool.hogwartspotions.model.types.PetType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@Table(name = "students")
public class Student {

    private String name;
    private int age;
    @Id
    private UUID id;
    @Enumerated(EnumType.STRING)
    private PetType petType;
    @Enumerated(EnumType.STRING)
    private HouseType houseType;

    public Student(String name, int age, PetType petType, HouseType houseType) {
        this.name = name;
        this.age = age;
        this.petType = petType;
        this.houseType = houseType;
        this.id = UUID.randomUUID();
    }
}
