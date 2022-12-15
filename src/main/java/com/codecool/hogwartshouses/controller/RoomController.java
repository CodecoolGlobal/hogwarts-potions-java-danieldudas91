package com.codecool.hogwartshouses.controller;

import com.codecool.hogwartshouses.model.HouseManagerDTO;
import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;
@CrossOrigin("*")
@RestController
public class RoomController {
    @Autowired
    RoomService roomService;

    @GetMapping("/rooms")
    public Set<Room> getAllRooms(){
        return roomService.getAllRooms();
    }
    @PostMapping("/rooms")
    public void addNewRoom(@RequestBody HouseManagerDTO houseManagerDTO){
        roomService.addNewRoom(houseManagerDTO.getCapacity());
    }

    @GetMapping("/rooms/{roomId}")
    public Room getRoomById(@PathVariable UUID roomId){
        return roomService.getRoomById(roomId);
    }

    @PutMapping("/rooms/{roomId}")
    public void renovateRoom(@PathVariable UUID roomId){
        roomService.renovateRoom(roomId);
    }

    @GetMapping("/rooms/available")
    public Set<Room> getAvailableRooms(){
        return roomService.getAvailableRooms();
    }

    @GetMapping("/rooms/rat-owners")
    public Set<Room> getAvailableRoomsForRatOwners(){
        return roomService.getAvailableRoomsForRatOwners();
    }
}
