package com.esdproject.academiq.movie;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenreResponse {
    @JsonProperty("movie_id")
    private Integer id;

    @JsonProperty("movie_title")
    private String title;

    @JsonProperty("posterlink")
    private String posterlink;


}
