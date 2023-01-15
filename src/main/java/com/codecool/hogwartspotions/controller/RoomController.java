package com.codecool.hogwartspotions.controller;

import com.codecool.hogwartspotions.model.HouseManagerDTO;
import com.codecool.hogwartspotions.model.Room;
import com.codecool.hogwartspotions.model.Student;
import com.codecool.hogwartspotions.service.RoomService;
import com.codecool.hogwartspotions.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class RoomController {
    @Autowired
    RoomService roomService;
    @Autowired
    StudentService studentService;

    @GetMapping("/rooms")
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @PostMapping("/rooms")
    public void addNewRoom(@RequestBody HouseManagerDTO houseManagerDTO) {
        roomService.addNewRoom(houseManagerDTO.getCapacity(), houseManagerDTO.getHouseType());
    }

    @GetMapping("/rooms/{roomId}")
    public Room getRoomById(@PathVariable Long roomId) {
        return roomService.getRoomById(roomId);
    }


    @PostMapping("/rooms/assign/{name}")
    public void assignStudentToRoom(@PathVariable String name){
        Student student = studentService.findStudentByName(name);
        roomService.assignStudentToRoom(student);
    }

    @GetMapping("/rooms/available")
    public List<Room> getAvailableRooms() {
        return roomService.getAvailableRooms();
    }

    @GetMapping("/rooms/rat-owners")
    public List<Room> getAvailableRoomsForRatOwners() {
        return roomService.getAvailableRoomsForRatOwners();
    }

    @DeleteMapping("/rooms/{roomId}")
    public void deleteRoomById(@PathVariable Long roomId){
        roomService.deleteRoomById(roomId);
    }

}
