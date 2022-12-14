package com.codecool.hogwartshouses.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@Builder
public class Room {
    private UUID id;
    private Set<Student> students;

}
