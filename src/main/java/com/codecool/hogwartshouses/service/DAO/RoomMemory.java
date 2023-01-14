package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.model.types.HouseType;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class RoomMemory implements RoomDAO {

    private Set<Room> rooms;
    private static final int INDEX_CORRECTION_NUMBER = 1;

    public RoomMemory() {
        this.rooms = new HashSet<>();
    }

    public void addRoom(Room room){
        if(room != null){
            rooms.add(room);
        }
        else{
            System.out.println("Room is null");
        }
    }

    public void addNewRoom(int capacity, HouseType houseType) {
        String roomName = "Room number " + (rooms.size() + INDEX_CORRECTION_NUMBER);
        Room newRoom = new Room(roomName, capacity, houseType);
        rooms.add(newRoom);
    }

    @Override
    public void deleteRoom(UUID roomId) {
        Room roomToFind = rooms.stream().filter(room -> room.getId().equals(roomId)).findFirst().orElse(null);
        if (roomToFind != null) {
            rooms.remove(roomToFind);
        } else {
            System.out.println("No room found with given id!");
        }
    }

    @Override
    public void updateRoom(UUID roomId) {

    }

    @Override
    public Room findRoomById(UUID roomId) {
        return rooms.stream().filter(room -> room.getId().equals(roomId)).findFirst().orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void assignStudentToRoom(Student student) {
        Room foundRoom = rooms.stream().filter(Room::isAvailable)
                .filter(room -> room.getHouseType().equals(student.getHouseType()))
                .max(Comparator.comparing(room -> room.getStudents().size())).orElse(null);
        if (foundRoom != null) {
            foundRoom.addStudent(student);
        } else {
            System.out.println("No empty rooms found!");
        }
    }

    @Override
    public Set<Room> getAllAvailableRooms() {
        return rooms.stream().filter(Room::isAvailable).collect(Collectors.toSet());
    }

    @Override
    public Set<Room> getAvailableRoomsForRatOwners() {
        return rooms.stream().filter(Room::hasOwlOrCat).collect(Collectors.toSet());
    }

    @Override
    public Set<Room> getAllRooms() {
        return rooms;
    }


}
