package com.esdproject.academiq.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService service;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam(value = "file") MultipartFile file) {
        return new ResponseEntity<>(service.uploadFile(file) , HttpStatus.OK);
    }

    @GetMapping("/fetchGenre/{genre}")
    public ResponseEntity< Optional<List<GenreResponse>> > fetchByGenre(@PathVariable String genre) {
        Optional<List<GenreResponse>> responses = service.fetchByGenre(genre);
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/fetchMovieName/{moviename}")
    public ResponseEntity<Optional<List<MovieNameResponse>>> fetchByMovieName(@PathVariable String moviename) {
        System.out.println("***************** I got the Movie Name as "+moviename);
        Optional<List<MovieNameResponse>> responses = service.fetchByTitle(moviename);
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/fetchMovieBylanguage/{language}")
    public ResponseEntity< Optional<List<GenreResponse>> > fetchMovieByLanguage(@PathVariable String language) {
        Optional<List<GenreResponse>> responses = service.fetchMovieByLanguage(language);
        return ResponseEntity.ok(responses);
    }


    @PostMapping("/addMovie")
    public ResponseEntity<Movie> addMovie(@RequestBody MovieRequest movieRequest) throws IOException {
        Movie movie = service.addMovie(movieRequest);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }
}
