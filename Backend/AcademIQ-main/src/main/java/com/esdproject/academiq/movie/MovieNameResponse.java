package com.esdproject.academiq.movie;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieNameResponse {
    @JsonProperty("movie_title")
    private String title;

    @JsonProperty("movielink")
    private String movielink;

    @JsonProperty("posterlink")
    private String posterlink;

    @JsonProperty("Description")
    private String Description;

    @JsonProperty("rating")
    private Integer rating;

    @JsonProperty("genre")
    private String genre;

    @JsonProperty("Language")
    private String language;

    @JsonProperty("duration")
    private String duration;

    @JsonProperty("release_date")
    private String releaseDate;

    @JsonProperty("trending")
    private Boolean trending;

}
