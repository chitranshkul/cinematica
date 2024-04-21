package com.esdproject.academiq.movie;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Mid")
    private Integer id;

    @Column(name="movie_title")
    private String title;

    @Column(name="Description")
    private String Description;

    @Column(name="rating")
    private Integer rating;

    @Column(name="genre")
    private String genre;

    @Column(name="language")
    private String language;

    @Column(name="duration")
    private String duration;

    @Column(name="release_date")
    private String releaseDate;

    @Column(name="moviefilename")
    private String moviefilename;

    @Column(name="posterfilename")
    private String posterfilename;

    @Column(name="trending")
    private boolean trending;
}
