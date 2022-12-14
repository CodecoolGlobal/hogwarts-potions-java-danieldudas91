package com.codecool.hogwartshouses.data_sample;

import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.model.types.PetType;
import com.codecool.hogwartshouses.service.DAO.StudentMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;
@Component
public class StudentCreator {
    private static final List<String> STUDENT_NAMES = List.of("Gipsz Jakab", "Kala Pál", "Rónaszéky Ivette",
            "Ilosvai Arisztid", "Kovács Zoárd", "Szűcs Sándor", "Horváth Ajándék");
    private static final Random RANDOM = new Random();
    private static final int NUMBER_OF_STUDENTS = 10;
    @Autowired
    private StudentMemory studentMemory;

    public StudentCreator() {
    }

    public Student createRandomStudent(){
        String randomName = STUDENT_NAMES.get(RANDOM.nextInt(STUDENT_NAMES.size()));
        PetType randomPetType = PetType.values()[RANDOM.nextInt(PetType.values().length)];
        int randomAge = RANDOM.nextInt(18 - 7) + 7;
        return new Student(randomName, randomAge, randomPetType);
    }
    @PostConstruct
    public void initStudents(){
        for (int i = 0; i < NUMBER_OF_STUDENTS; i++) {
            studentMemory.addStudent(createRandomStudent());
        }
    }

}
