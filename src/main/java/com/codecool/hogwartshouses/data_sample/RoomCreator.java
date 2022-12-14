package com.codecool.hogwartshouses.data_sample;

import com.codecool.hogwartshouses.service.DAO.RoomMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RoomCreator {
    private static final int NUMBER_OF_ROOMS = 10;
    private static final int MAX_ROOM_CAPACITY = 4;
    @Autowired
    RoomMemory roomMemory;
    @PostConstruct
    public void initialize() {
        for (int i = 0; i < NUMBER_OF_ROOMS; i++) {
            roomMemory.addNewRoom(MAX_ROOM_CAPACITY);
        }
    }

    public RoomCreator() {
    }
}
