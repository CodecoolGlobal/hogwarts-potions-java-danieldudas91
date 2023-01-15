package com.codecool.hogwartspotions.service;

import com.codecool.hogwartspotions.model.Room;
import com.codecool.hogwartspotions.model.Student;
import com.codecool.hogwartspotions.model.types.HouseType;
import com.codecool.hogwartspotions.service.JPA.RoomRepository;
import com.codecool.hogwartspotions.service.JPA.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private StudentRepository studentRepository;


    public List<Room> getAllRooms() {
        return (List<Room>) roomRepository.findAll();
    }

    public void addNewRoom(int capacity, HouseType houseType) {
        String name = houseType.name() + "room";
        roomRepository.save(new Room(name, capacity, houseType));
    }

    public Room getRoomById(Long roomId) {
        return roomRepository.findById(roomId).orElseThrow(NoSuchElementException::new);
    }

    public void assignStudentToRoom(Student student) {
        Room foundRoom = roomRepository.findAllByAvailableTrueAndHouseType(student.getHouseType())
                .stream()
                .max(Comparator.comparing(room -> room.getStudents().size()))
                .orElseThrow(NoSuchElementException::new);
        foundRoom.addStudent(student);
        student.setRoomId(foundRoom.getId());
        roomRepository.save(foundRoom);
        studentRepository.save(student);
    }

    public List<Room> getAvailableRooms() {
        return roomRepository.findAllByAvailableTrue();
    }

    public List<Room> getAvailableRoomsForRatOwners() {
        return roomRepository.findAllByAvailableTrueAndRatFriendlyTrue();
    }

    public void deleteRoomById(Long roomId) {
        roomRepository.deleteById(roomId);
    }

    public List<Student> getStudentsInRoom(Long roomId){
        Room foundRoom = roomRepository.findById(roomId).orElseThrow(NoSuchElementException::new);
        return foundRoom.getStudents();
    }
}
