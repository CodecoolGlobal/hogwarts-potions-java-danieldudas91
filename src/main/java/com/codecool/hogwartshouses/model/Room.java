package com.codecool.hogwartshouses.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@Builder
public class Room {
    private UUID id;
    private Set<Student> students;
    private int capacity;

    public Room(int capacity) {
        this.capacity = capacity;
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
}
