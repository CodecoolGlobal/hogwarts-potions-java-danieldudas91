package com.codecool.hogwartshouses.model;

import com.codecool.hogwartshouses.model.types.PetType;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
public class Room {
    private UUID id;
    private String name;
    private Set<Student> students;
    private int capacity;

    public Room(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.students = new HashSet<>();
        this.id= UUID.randomUUID();
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
