package com.codecool.hogwartspotions.model;

import com.codecool.hogwartspotions.model.types.HouseType;
import com.codecool.hogwartspotions.model.types.PetType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class HouseManagerDTO {
    private int capacity;
    private UUID roomId;
    private String studentName;
    private int studentAge;
    private PetType studentPetType;
    private HouseType houseType;
}