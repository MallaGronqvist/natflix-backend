package com.novare.natflixbackend.repositories;

import com.novare.natflixbackend.models.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Integer> {
}
