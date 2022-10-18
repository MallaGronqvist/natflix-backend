package com.novare.natflixbackend.repositories;

import com.novare.natflixbackend.models.Series;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeriesRepository extends JpaRepository<Series, Integer> {
}
