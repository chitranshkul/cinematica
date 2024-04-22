package com.esdproject.academiq.wishList;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class WishListResponseBody {


    @JsonProperty("movie-id")
    private Integer id;

    @JsonProperty("movie_title")
    private String title;

    @JsonProperty("poster")
    private String poster;
}
