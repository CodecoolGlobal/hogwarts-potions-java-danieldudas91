package com.codecool.hogwartspotions.model;

import com.codecool.hogwartspotions.model.types.HouseType;
import com.codecool.hogwartspotions.model.types.PetType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString(exclude = {"potion", "room", "recipe"})
@Entity
@NoArgsConstructor
@Table(name = "students")
public class Student {

    private String name;
    private int age;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "room_id")
    @JsonIgnore
    private Room room;
    @OneToOne(mappedBy = "student")
    @JsonIgnore
    private Recipe recipe;
    @OneToOne(mappedBy = "student")
    @JsonIgnore
    private Potion potion;
    @Enumerated(EnumType.STRING)
    @Column(name = "pet_type")
    private PetType petType;

    @Enumerated(EnumType.STRING)
    @Column(name = "house_type")
    private HouseType houseType;

    public Student(String name, int age, PetType petType, HouseType houseType) {
        this.name = name;
        this.age = age;
        this.petType = petType;
        this.houseType = houseType;
    }

}
