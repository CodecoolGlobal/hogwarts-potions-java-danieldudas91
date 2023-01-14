package com.codecool.hogwartspotions.data_sample;

import com.codecool.hogwartspotions.model.Student;
import com.codecool.hogwartspotions.model.types.HouseType;
import com.codecool.hogwartspotions.model.types.PetType;
import com.codecool.hogwartspotions.service.DAO.StudentMemory;
import com.codecool.hogwartspotions.service.JPA.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;
@Component
public class StudentCreator {
    private static final List<String> FIRST_NAMES = List.of("Jakab", "Pál", "Ivette", "Sándor",
                                                    "Ajándék", "Oszkár", "Arisztid", "Erzsébet",
                                                    "Tasziló", "Anna", "Vilmos", "Júlia");
    private static final List<String> LAST_NAMES = List.of("Gipsz", "Németh", "Rónaszéky",
                                                    "Ilosvai", "Kovács", "Szűcs", "Horváth",
                                                    "Nagy", "Kis", "Molnár", "Egerszalóki", "Jónás");
    private static final Random RANDOM = new Random();
    private static final int NUMBER_OF_STUDENTS = 10;
    private static final int MAX_AGE = 18;
    private static final int MIN_AGE = 7;

    @Autowired
    private StudentRepository studentRepository;

    public StudentCreator() {
    }

    public Student createRandomStudent(){
        return new Student(generateRandomName(), getRandomAge(), getRandomPetType(), getRandomHouseType());
    }

    private static HouseType getRandomHouseType() {
        return HouseType.values()[RANDOM.nextInt(HouseType.values().length)];
    }

    private static int getRandomAge() {
        return RANDOM.nextInt(MAX_AGE - MIN_AGE) + MIN_AGE;
    }

    private static PetType getRandomPetType() {
        return PetType.values()[RANDOM.nextInt(PetType.values().length)];
    }

    private static String generateRandomName() {
        String randomFirstName = FIRST_NAMES.get(RANDOM.nextInt(FIRST_NAMES.size()));
        String randomLastName = LAST_NAMES.get(RANDOM.nextInt(LAST_NAMES.size()));
        return randomFirstName + " " + randomLastName;
    }


    @PostConstruct
    public void initStudents(){
        if(!studentRepository.findAll().iterator().hasNext()){
            for (int i = 0; i < NUMBER_OF_STUDENTS; i++) {
                studentRepository.save(createRandomStudent());
            }
        }
    }

}
