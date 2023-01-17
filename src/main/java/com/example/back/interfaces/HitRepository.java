package com.example.back.interfaces;

import com.example.back.entities.Hit;
import org.springframework.data.repository.CrudRepository;

public interface HitRepository extends CrudRepository<Hit, Long> {
}
