package com.codecool.hogwartshouses.model;

import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.model.types.PetType;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class Student {

    private String name;
    private int age;
    private PetType petType;
    private HouseType houseType;

    public Student(String name, int age, PetType petType, HouseType houseType) {
        this.name = name;
        this.age = age;
        this.petType = petType;
        this.houseType = houseType;
    }
}
