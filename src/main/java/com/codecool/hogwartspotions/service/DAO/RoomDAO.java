package com.codecool.hogwartspotions.service.DAO;

import com.codecool.hogwartspotions.model.Room;
import com.codecool.hogwartspotions.model.Student;
import com.codecool.hogwartspotions.model.types.HouseType;

import java.util.Set;
import java.util.UUID;

public interface RoomDAO {
    void addRoom(Room room);

    void addNewRoom(int capacity, HouseType houseType);

    void deleteRoom(UUID roomId);

    void updateRoom(UUID roomId);
    Room findRoomById(UUID roomId);

    void assignStudentToRoom(Student student);
    Set<Room> getAllAvailableRooms();
    Set<Room> getAvailableRoomsForRatOwners();

    Set<Room> getAllRooms();

}