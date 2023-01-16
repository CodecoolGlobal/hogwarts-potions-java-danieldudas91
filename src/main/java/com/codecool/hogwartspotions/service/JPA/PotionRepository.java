package com.codecool.hogwartspotions.service.JPA;

import com.codecool.hogwartspotions.model.Potion;
import org.springframework.data.repository.CrudRepository;

public interface PotionRepository extends CrudRepository<Potion, Long> {
}
