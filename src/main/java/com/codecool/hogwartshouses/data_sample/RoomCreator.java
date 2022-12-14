package com.codecool.hogwartshouses.data_sample;

import com.codecool.hogwartshouses.service.DAO.RoomMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomCreator {
    private static final int NUMBER_OF_ROOMS = 10;
    @Autowired
    RoomMemory roomMemory;

    public void initialize() {
        roomMemory.addGivenNumberOfRooms(NUMBER_OF_ROOMS);
    }

    public RoomCreator() {
        initialize();
    }
}
