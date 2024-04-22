package com.esdproject.academiq.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    private static final Logger logger = LogManager.getLogger(MovieController.class);

    @Autowired
    private MovieService service;


@PostMapping("/upload")
public ResponseEntity<String> uploadFile(@RequestParam(value = "file") MultipartFile file) {
    logger.debug("Received request to upload file.");
    String response = service.uploadFile(file);
    logger.info("File upload completed.");
    return new ResponseEntity<>(response, HttpStatus.OK);
}

    @GetMapping("/fetchGenre/{genre}")
    public ResponseEntity<Optional<List<GenreResponse>>> fetchByGenre(@PathVariable String genre) {
        logger.debug("Received request to fetch movies by genre: {}", genre);
        Optional<List<GenreResponse>> responses = service.fetchByGenre(genre);
        logger.info("Fetch completed.");
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/fetchMovieName/{moviename}")
    public ResponseEntity<Optional<List<MovieNameResponse>>> fetchByMovieName(@PathVariable String moviename) {
        logger.debug("Received request to fetch movies by name: {}", moviename);
        Optional<List<MovieNameResponse>> responses = service.fetchByTitle(moviename);
        logger.info("Fetch completed for movie name: {}", moviename);
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/fetchMovieBylanguage/{language}")
    public ResponseEntity<Optional<List<GenreResponse>>> fetchMovieByLanguage(@PathVariable String language) {
        logger.debug("Received request to fetch movies by language: {}", language);
        Optional<List<GenreResponse>> responses = service.fetchMovieByLanguage(language);
        logger.info("Fetch completed for language: {}", language);
        return ResponseEntity.ok(responses);
    }
}
