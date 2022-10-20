package com.novare.natflixbackend.repositories;

import com.novare.natflixbackend.models.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContentRepository extends JpaRepository<Content, Integer> {
    List<Content> findByTypeId(int type_id);
}
