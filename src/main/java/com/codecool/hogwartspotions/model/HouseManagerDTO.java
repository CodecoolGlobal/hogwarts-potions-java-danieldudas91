package com.codecool.hogwartspotions.model;

import com.codecool.hogwartspotions.model.types.HouseType;
import com.codecool.hogwartspotions.model.types.PetType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class HouseManagerDTO {
    private int capacity;
    private Long roomId;
    private Long studentId;
    private String studentName;
    private int studentAge;
    private PetType studentPetType;
    private HouseType houseType;
    private List<String> ingredientNames;
    private String potionName;

}
