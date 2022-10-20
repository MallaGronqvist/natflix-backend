package com.novare.natflixbackend.repositories;

import com.novare.natflixbackend.models.Series;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeriesRepository extends JpaRepository<Series, Integer> {
    List<Series> findByContentId(Integer content_id);
}
