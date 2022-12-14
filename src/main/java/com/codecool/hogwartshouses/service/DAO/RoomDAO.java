package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.types.PetType;

import java.util.Set;
import java.util.UUID;

public interface RoomDAO {
    void addRoom(Room room);

    void addGivenNumberOfRooms(int numberOfRooms);

    void deleteRoom(UUID roomId);

    void updateRoom(UUID roomId);
    Room findRoomById(UUID roomId);

    void assignStudentToRoom(UUID roomId, String studentName);
    Set<Room> getAllAvailableRooms();
    Set<Room> getAvailableRoomsForStudentsWithCertainTypeOfPet(PetType petType);

}