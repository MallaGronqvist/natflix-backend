package com.novare.natflixbackend.repositories;

import com.novare.natflixbackend.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
