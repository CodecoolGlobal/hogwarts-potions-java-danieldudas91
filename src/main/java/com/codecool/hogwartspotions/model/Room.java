package com.codecool.hogwartspotions.model;

import com.codecool.hogwartspotions.model.types.HouseType;
import com.codecool.hogwartspotions.model.types.PetType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany()
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private List<Student> students;
    private int capacity;
    @Enumerated(EnumType.STRING)
    @Column(name = "house_type")
    private HouseType houseType;
    @Column(name = "rat_friendly")
    private boolean ratFriendly;
    private boolean available;

    public Room(String name, int capacity, HouseType houseType) {
        this.name = name;
        this.capacity = capacity;
        this.students = new ArrayList<>();
        this.houseType = houseType;
        this.ratFriendly = !hasOwlOrCat();
        this.available = isAvailable();
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
