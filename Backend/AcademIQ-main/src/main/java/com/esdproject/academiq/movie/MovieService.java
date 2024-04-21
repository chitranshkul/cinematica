package com.esdproject.academiq.movie;


import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    private final MovieRepository movieRepository;

    @Value("${application.bucket.name}")
    private String bucketName;

    @Autowired
    private AmazonS3 s3Client;

    public String uploadFile(MultipartFile file) {
        File fileObj = convertMultiPartFileToFile(file);
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        s3Client.putObject(new PutObjectRequest(bucketName, fileName, fileObj));
        fileObj.delete(); //delete from the s3 bucket
         return "File uploaded : " + fileName;
        //return generatePresignedUrl((fileName));
    }

    private File convertMultiPartFileToFile(MultipartFile file) {
        File convertedFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        } catch (IOException e) {
            log.error("Error converting multipartFile to file", e);
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
                    String Posterink = generatePresignedUrl(movie.getPosterfilename());
                    GenreResponse response = GenreResponse.builder()
                            .id(movie.getId())
                            .title(movie.getTitle())
                            .posterlink(Posterink)
                            .build();
                    genreResponses.add(response);
                }
            }
            return Optional.of(genreResponses);
        } catch (Exception e) {
            // Log the exception or handle it as needed
            e.printStackTrace(); // Print stack trace for debugging
            return Optional.empty(); // Return an empty Optional
        }
    }

    public Optional<List<MovieNameResponse>> fetchByTitle(String moviename) {
        Optional<List<Movie>> optionalMovies = movieRepository.findByTitle(moviename);
        List<MovieNameResponse> movieNameResponses = new ArrayList<>();

        try {
            if(optionalMovies.isPresent()) {
                List<Movie> movies = optionalMovies.get();
                for (Movie movie : movies) {
                    String Movelink = generatePresignedUrl(movie.getMoviefilename());
                    String Posterink = generatePresignedUrl(movie.getPosterfilename());
                    MovieNameResponse response = MovieNameResponse.builder()
                            .title(movie.getTitle())
                            .movielink(Movelink)
                            .posterlink(Posterink)
                            .Description(movie.getDescription())
                            .rating(movie.getRating())
                            .genre(movie.getGenre())
                            .language(movie.getLanguage())
                            .duration(movie.getDuration())
                            .releaseDate(movie.getReleaseDate())
                            //.trending(movie.getTrending())
                            .build();
                    movieNameResponses.add(response);
                }
            }
        } catch (Exception e) {
            // Log the exception or handle it accordingly
            e.printStackTrace(); // For demonstration purpose, you might want to handle it differently in a real application
            return Optional.empty(); // Return empty optional indicating failure
        }

        return Optional.of(movieNameResponses);
    }

    public Optional<List<GenreResponse>> fetchMovieByLanguage(String language) {
        try {
            Optional<List<Movie>> optionalMovies = movieRepository.findByLanguage(language);
            List<GenreResponse> genreResponses = new ArrayList<>();

            if (optionalMovies.isPresent()) {
                List<Movie> movies = optionalMovies.get();
                for (Movie movie : movies) {
                    String Posterlink = generatePresignedUrl(movie.getPosterfilename());
                    GenreResponse response = GenreResponse.builder()
                            .id(movie.getId())
                            .title(movie.getTitle())
                            .posterlink(Posterlink)
                            .build();
                    genreResponses.add(response);
                }
            }
            return Optional.of(genreResponses);
        } catch (Exception e) {
            // Log the exception or handle it as needed
            e.printStackTrace(); // Print stack trace for debugging
            return Optional.empty(); // Return an empty Optional
        }
    }
}


