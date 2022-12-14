package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.model.Room;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

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

    public void addGivenNumberOfRooms(int numberOfRooms){
        for (int i = 0; i < numberOfRooms; i++) {
            Room newRoom = new Room();
            rooms.add(newRoom);
        }
    }
}
