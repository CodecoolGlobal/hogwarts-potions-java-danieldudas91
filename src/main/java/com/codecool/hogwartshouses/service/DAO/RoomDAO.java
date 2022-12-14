package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.model.types.PetType;

import java.util.Set;
import java.util.UUID;

public interface RoomDAO {
    void addRoom(Room room);

    void addGivenNumberOfRooms(int numberOfRooms, int capacity);

    void deleteRoom(UUID roomId);

    void updateRoom(UUID roomId);
    Room findRoomById(UUID roomId);

    void assignStudentToRoom(UUID roomId, Student student);
    Set<Room> getAllAvailableRooms();
    Set<Room> getAvailableRoomsForRatOwners();

}