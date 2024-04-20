package com.esdproject.academiq.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Optional<List<Movie>> findByGenre(String genre);
    Optional<List<Movie>> findByTitle(String title);
    Optional<List<Movie>> findByLanguage(String language);
}
