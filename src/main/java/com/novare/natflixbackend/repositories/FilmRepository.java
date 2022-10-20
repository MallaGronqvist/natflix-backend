package com.novare.natflixbackend.repositories;

import com.novare.natflixbackend.models.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Integer> {
    Film findByContentId(Integer content_id);
}
