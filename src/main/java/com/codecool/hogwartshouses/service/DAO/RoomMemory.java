package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.model.types.PetType;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class RoomMemory implements RoomDAO {

    private Set<Room> rooms;

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

    public void addGivenNumberOfRooms(int numberOfRooms, int capacity){
        for (int i = 0; i < numberOfRooms; i++) {
            Room newRoom = new Room(capacity);
            rooms.add(newRoom);
        }
    }

    @Override
    public void deleteRoom(UUID roomId) {
        Room roomToFind = rooms.stream().filter(room -> room.getId().equals(roomId)).findFirst().orElse(null);
        if(roomToFind != null){
            rooms.remove(roomToFind);
        }
        else{
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
    public void assignStudentToRoom(UUID roomId, Student student) {
        Room foundRoom = rooms.stream().filter(room -> room.getId().equals(roomId)).findFirst().orElse(null);
        if(foundRoom != null){
            foundRoom.addStudent(student);
        }
        else{
            System.out.println("No room found with given id!");
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


}
