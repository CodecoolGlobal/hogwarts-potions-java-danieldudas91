package com.codecool.hogwartshouses.data_sample;

import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.service.DAO.RoomMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

@Component
public class RoomCreator {
    private static final int NUMBER_OF_ROOMS = 10;
    private static final int MAX_ROOM_CAPACITY = 4;
    private static final Random RANDOM = new Random();
    @Autowired
    RoomMemory roomMemory;
    public RoomCreator() {
    }
    @PostConstruct
    public void initialize() {
        for (int i = 0; i < NUMBER_OF_ROOMS; i++) {
            HouseType randomHouseType = HouseType.values()[RANDOM.nextInt(HouseType.values().length)];
            roomMemory.addNewRoom(MAX_ROOM_CAPACITY, randomHouseType);
        }
    }

}
