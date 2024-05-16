package com.esdproject.academiq.wishList;

import com.esdproject.academiq.movie.GenreResponse;
import com.esdproject.academiq.movie.Movie;
import com.esdproject.academiq.movie.MovieRepository;
import com.esdproject.academiq.movie.MovieService;
import com.esdproject.academiq.user.User;
import com.esdproject.academiq.user.UserRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Builder
@RequiredArgsConstructor
@Service
public class WishListService {
    private static final Logger logger = LogManager.getLogger(WishListService.class);

    @Autowired
    private final WishListRepository wishListRepository;
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;
    private final MovieService movieService;

    public String addToWishList(int userId, int movieId) {
        try {
            Optional<User> optionalUser = userRepository.findById(userId);
            if (optionalUser.isEmpty()) {
                return "Unable to add: User not found with ID: " + userId;
            }
            User user = optionalUser.get();

            Optional<Movie> optionalMovie = movieRepository.findById(movieId);
            if (optionalMovie.isEmpty()) {
                return "Unable to add: Movie not found with ID: " + movieId;
            }
            Movie movie = optionalMovie.get();

            WishList existingWishList = wishListRepository.findByUserIDAndMovieID(userId, movieId);
            if (existingWishList != null) {
                return "Already added to WishList";
            }

            WishList wishList = WishList.builder()
                    .UserID(user)
                    .movieID(movie)
                    .build();

            wishListRepository.save(wishList);

            return "Movie added successfully to wishlist";
        } catch (Exception e) {
            logger.error("Failed to add movie to wishlist: {}", e.getMessage());
            return "Failed to add movie to wishlist";
        }
    }

    public String removefromWishList(int userId, int movieId) {
        try {
            WishList wishList = wishListRepository.findByUserIDAndMovieID(userId, movieId);

            if (wishList != null) {
                wishListRepository.delete(wishList);
                return "Movie removed from wishlist";
            } else {
                logger.warn("Wishlist item not found for UserID: {} and MovieID: {}", userId, movieId);
                return "Failed to remove movie from wishlist. Wishlist item not found.";
            }
        } catch (Exception e) {
            logger.error("Failed to remove movie from wishlist: {}", e.getMessage());
            return "Failed to remove movie from wishlist";
        }
    }

    public List<GenreResponse> listMoviesInWishlist(int userId) {
        try {
            List<Movie> movies = new ArrayList<>();
            List<GenreResponse> mv = new ArrayList<>();

            List<WishList> wishlistEntries = wishListRepository.findByUserID(userId);

            if (!wishlistEntries.isEmpty()) {
                for (WishList wishlistEntry : wishlistEntries) {
                    Movie movie = wishlistEntry.getMovieID();
                    String Posterlink = movieService.generatePresignedUrl(movie.getPosterfilename());
                    GenreResponse response = GenreResponse.builder()
                            .id(movie.getId())
                            .title(movie.getTitle())
                            .posterlink(Posterlink)
                            .build();
                    mv.add(response);
                }
            } else {
                logger.info("No wishlist entries found for user ID: {}", userId);
            }

            return mv;
        } catch (Exception e) {
            logger.error("Error listing movies in wishlist: {}", e.getMessage());
            return new ArrayList<>();
        }
    }
}
