package com.codecool.hogwartshouses.service;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.service.DAO.RoomDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class RoomService {

    @Autowired
    private RoomDAO roomDAO;


    public Set<Room> getAllRooms() {
        return roomDAO.getAllRooms();
    }

    public void addNewRoom(int capacity) {
        roomDAO.addNewRoom(capacity);
    }

    public Room getRoomById(UUID roomId) {
        return roomDAO.findRoomById(roomId);
    }

    public void renovateRoom(UUID roomId) {
        roomDAO.updateRoom(roomId);
    }

    public Set<Room> getAvailableRooms() {
        return roomDAO.getAllAvailableRooms();
    }

    public Set<Room> getAvailableRoomsForRatOwners() {
        return roomDAO.getAvailableRoomsForRatOwners();
    }
}
