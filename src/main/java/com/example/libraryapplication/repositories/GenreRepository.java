package com.example.libraryapplication.repositories;

import com.example.libraryapplication.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
