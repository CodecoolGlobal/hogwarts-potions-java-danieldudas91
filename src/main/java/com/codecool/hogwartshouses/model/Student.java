package com.codecool.hogwartshouses.model;

import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.model.types.PetType;
import lombok.Data;

import java.util.UUID;

@Data
public class Student {

    private String name;
    private int age;
    private UUID id;
    private PetType petType;
    private HouseType houseType;

    public Student(String name, int age, PetType petType, HouseType houseType) {
        this.name = name;
        this.age = age;
        this.petType = petType;
        this.houseType = houseType;
        this.id = UUID.randomUUID();
    }
}
