package com.novare.natflixbackend.repositories;

import com.novare.natflixbackend.models.Type;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TypeRepository extends JpaRepository<Type, Integer> {
}
