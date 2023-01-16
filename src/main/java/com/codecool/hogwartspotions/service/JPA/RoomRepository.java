package com.codecool.hogwartspotions.service.JPA;

import com.codecool.hogwartspotions.model.Room;
import com.codecool.hogwartspotions.model.types.HouseType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface RoomRepository extends CrudRepository<Room, Long> {

    List<Room> findAllByAvailableTrue();
    List<Room> findAllByAvailableTrueAndRatFriendlyTrue();

    List<Room> findAllByAvailableTrueAndHouseType(HouseType houseType);
    List<Room> findAllByAvailableTrueAndHouseTypeAndRatFriendlyTrue(HouseType houseType);
    List<Room> findAllByAvailableTrueAndHouseTypeAndRatFriendlyFalseOrEmptyTrueAndHouseType(HouseType houseType, HouseType houseType2);

}
