package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.Student;

import java.util.Set;
import java.util.UUID;

public interface RoomDAO {
    void addRoom(Room room);

    void addNewRoom(int capacity);

    void deleteRoom(UUID roomId);

    void updateRoom(UUID roomId);
    Room findRoomById(UUID roomId);

    void assignStudentToRoom(Student student);
    Set<Room> getAllAvailableRooms();
    Set<Room> getAvailableRoomsForRatOwners();

    Set<Room> getAllRooms();

}