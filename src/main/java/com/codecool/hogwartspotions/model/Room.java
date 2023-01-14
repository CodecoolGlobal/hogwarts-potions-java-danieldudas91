package com.codecool.hogwartspotions.model;

import com.codecool.hogwartspotions.model.types.HouseType;
import com.codecool.hogwartspotions.model.types.PetType;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
public class Room {
    private UUID id;
    private String name;
    private Set<Student> students;
    private int capacity;
    private HouseType houseType;

    public Room(String name, int capacity, HouseType houseType) {
        this.name = name;
        this.capacity = capacity;
        this.students = new HashSet<>();
        this.id= UUID.randomUUID();
        this.houseType = houseType;
    }

    public boolean isAvailable() {
        return students.size() < capacity;
    }

    public void addStudent(Student student){
        if(isAvailable()){
            students.add(student);
        }
        else{
            System.out.println("Room is full");
        }
    }

    public boolean hasOwlOrCat() {
        return students.stream().anyMatch(student -> student.getPetType()
                .equals(PetType.CAT) || student.getPetType().equals(PetType.OWL));
    }
}