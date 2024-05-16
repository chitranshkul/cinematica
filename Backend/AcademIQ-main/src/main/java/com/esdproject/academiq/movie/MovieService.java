package com.esdproject.academiq.movie;


import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MovieService {

    private static final Logger logger = LogManager.getLogger(MovieService.class);
    private final MovieRepository movieRepository;

    @Value("${application.bucket.name}")
    private String bucketName;

    @Autowired
    private AmazonS3 s3Client;

    public String uploadFile(MultipartFile file) {
        logger.debug("Uploading file...");
        File fileObj = convertMultiPartFileToFile(file);
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        s3Client.putObject(new PutObjectRequest(bucketName, fileName, fileObj));
        fileObj.delete(); //delete from the s3 bucket
        logger.debug("File uploaded : {}", fileName);
        return "File uploaded : " + fileName;
        //return generatePresignedUrl((fileName));
    }

    private File convertMultiPartFileToFile(MultipartFile file) {
        File convertedFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        } catch (IOException e) {
            logger.error("Error converting multipartFile to file", e);
        }
        return convertedFile;
    }

    public String generatePresignedUrl(String fileName) {
        Date expiration = new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24)); // URL expiration time (24 hours)
        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucketName, fileName)
                .withMethod(HttpMethod.GET)
                .withExpiration(expiration);

        URL url = s3Client.generatePresignedUrl(generatePresignedUrlRequest);
        return url.toString();
    }

    public Optional<List<GenreResponse>> fetchByGenre(String genre) {
        try {
            Optional<List<Movie>> optionalMovies = movieRepository.findByGenre(genre);
            List<GenreResponse> genreResponses = new ArrayList<>();

            if (optionalMovies.isPresent()) {
                List<Movie> movies = optionalMovies.get();
                for (Movie movie : movies) {
                    String posterLink = generatePresignedUrl(movie.getPosterfilename());
                    GenreResponse response = GenreResponse.builder()
                            .id(movie.getId())
                            .title(movie.getTitle())
                            .posterlink(posterLink)
                            .build();
                    genreResponses.add(response);
                }
            }
            logger.info("Fetch by genre '{}' completed successfully.", genre);
            return Optional.of(genreResponses);
        } catch (Exception e) {
            logger.error("Error occurred while fetching movies by genre '{}': {}", genre, e.getMessage());
            return Optional.empty();
        }
    }

    public Optional<List<MovieNameResponse>> fetchByTitle(String moviename) {
        try {
            Optional<List<Movie>> optionalMovies = movieRepository.findByTitle(moviename);
            List<MovieNameResponse> movieNameResponses = new ArrayList<>();

            if(optionalMovies.isPresent()) {
                List<Movie> movies = optionalMovies.get();
                for (Movie movie : movies) {
                    String movieLink = generatePresignedUrl(movie.getMoviefilename());
                    String posterLink = generatePresignedUrl(movie.getPosterfilename());
                    MovieNameResponse response = MovieNameResponse.builder()
                            .title(movie.getTitle())
                            .movielink(movieLink)
                            .posterlink(posterLink)
                            .Description(movie.getDescription())
                            .rating(movie.getRating())
                            .genre(movie.getGenre())
                            .language(movie.getLanguage())
                            .duration(movie.getDuration())
                            .releaseDate(movie.getReleaseDate())
                            .build();
                    movieNameResponses.add(response);
                }
            }
            logger.info("Fetch by title '{}' completed successfully.", moviename);
            return Optional.of(movieNameResponses);
        } catch (Exception e) {
            logger.error("Error occurred while fetching movies by title '{}': {}", moviename, e.getMessage());
            return Optional.empty();
        }
    }

    public Optional<List<GenreResponse>> fetchMovieByLanguage(String language) {
        try {
            Optional<List<Movie>> optionalMovies = movieRepository.findByLanguage(language);
            List<GenreResponse> genreResponses = new ArrayList<>();

            if (optionalMovies.isPresent()) {
                List<Movie> movies = optionalMovies.get();
                for (Movie movie : movies) {
                    String posterLink = generatePresignedUrl(movie.getPosterfilename());
                    GenreResponse response = GenreResponse.builder()
                            .id(movie.getId())
                            .title(movie.getTitle())
                            .posterlink(posterLink)
                            .build();
                    genreResponses.add(response);
                }
            }
            logger.info("Fetch by language '{}' completed successfully.", language);
            return Optional.of(genreResponses);
        } catch (Exception e) {
            logger.error("Error occurred while fetching movies by language '{}': {}", language, e.getMessage());
            return Optional.empty();
        }
    }

    public Movie addMovie(MovieRequest movieRequest) throws IOException {
        Movie movie = new Movie();
        movie.setTitle(movieRequest.getTitle());
        movie.setDescription(movieRequest.getDescription());
        movie.setRating(movieRequest.getRating());
        movie.setGenre(movieRequest.getGenre());
        movie.setLanguage(movieRequest.getLanguage());
        movie.setDuration(movieRequest.getDuration());
        movie.setReleaseDate(movieRequest.getReleaseDate());
        movie.setMoviefilename(movieRequest.getMoviefilename());
        movie.setPosterfilename(movieRequest.getPosterfilename());
        movie.setTrending(movieRequest.isTrending());

        return movieRepository.save(movie);
    }
}


