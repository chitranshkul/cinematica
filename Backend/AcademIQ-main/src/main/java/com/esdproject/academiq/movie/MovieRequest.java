package com.esdproject.academiq.movie;


import lombok.Data;

@Data
public class MovieRequest {
    private String title;
    private String description;
    private int rating;
    private String genre;
    private String language;
    private String duration;
    private String releaseDate;
    private String moviefilename;
    private String posterfilename;
    private boolean trending;
}
