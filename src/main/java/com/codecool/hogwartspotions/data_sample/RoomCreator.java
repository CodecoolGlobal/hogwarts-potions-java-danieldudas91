package com.codecool.hogwartspotions.data_sample;

import com.codecool.hogwartspotions.model.Room;
import com.codecool.hogwartspotions.model.types.HouseType;
import com.codecool.hogwartspotions.service.JPA.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RoomCreator {
    private static final int NUMBER_OF_ROOMS = 12;
    private static final int MAX_ROOM_CAPACITY = 4;
    @Autowired
    RoomRepository roomRepository;

    public RoomCreator() {
    }

    @PostConstruct
    public void initialize() {
        if(!roomRepository.findAll().iterator().hasNext()){
            for (int i = 0; i < NUMBER_OF_ROOMS; i++) {
                HouseType houseType;
                if (0 <= i && i < 3) {
                    houseType = HouseType.GRYFFINDOR;
                } else if (3 <= i && i < 6) {
                    houseType = HouseType.HUFFLEPUFF;
                } else if (6 <= i && i < 9) {
                    houseType = HouseType.RAVENCLAW;
                } else {
                    houseType = HouseType.SLYTHERIN;
                }
                String name = houseType.name() + "room";
                roomRepository.save(new Room(name, MAX_ROOM_CAPACITY, houseType));
            }
        }

    }

}
