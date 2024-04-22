package com.esdproject.academiq.wishList;

import com.amazonaws.services.dynamodbv2.xspec.L;
import com.amazonaws.services.dynamodbv2.xspec.S;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.esdproject.academiq.movie.Movie;
import com.esdproject.academiq.movie.MovieRepository;
import com.esdproject.academiq.user.User;
import com.esdproject.academiq.user.UserRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Builder
@RequiredArgsConstructor
@Service
public class WishListService {

    @Autowired
    private final WishListRepository wishListRepository;
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    private static final Logger logger = LogManager.getLogger(WishListService.class);

    public String addToWishList(int userId, int movieId) {
        try {
            // Find the user by ID
            Optional<User> optionalUser = userRepository.findById(userId);
            if (optionalUser.isEmpty()) {
                logger.warn("Unable to add: User not found with ID: {}", userId);
                return "Unable to add: User not found with ID: " + userId;
            }
            User user = optionalUser.get();

            // Find the movie by ID
            Optional<Movie> optionalMovie = movieRepository.findById(movieId);
            if (optionalMovie.isEmpty()) {
                logger.warn("Unable to add: Movie not found with ID: {}", movieId);
                return "Unable to add: Movie not found with ID: " + movieId;
            }
            Movie movie = optionalMovie.get();

            WishList existingWishList = wishListRepository.findByUserIDAndMovieID(userId, movieId);
            if (existingWishList != null) {
                logger.info("Already added to WishList. UserID: {}, MovieID: {}", userId, movieId);
                return "Already added to WishList";
            }

            // Create a new wish list item using the builder pattern
            WishList wishList = WishList.builder()
                    .UserID(user)
                    .movieID(movie)
                    .build();

            // Save the wish list item
            wishListRepository.save(wishList);

            logger.info("Movie added successfully to wishlist. UserID: {}, MovieID: {}", userId, movieId);
            return "Movie added successfully to wishlist";
        } catch (Exception e) {
            logger.error("Failed to add movie to wishlist: {}", e.getMessage());
            return "Failed to add movie to wishlist: " + e.getMessage();
        }
    }

    // removefromWishList method

    public String removefromWishList(int userId, int movieId) {
        try {
            // Print userId and movieId for debugging
            logger.debug("Removing movie from wishlist. UserID: {}, MovieID: {}", userId, movieId);

            // Find the wishlist item associated with the user and movie
            WishList wishList = wishListRepository.findByUserIDAndMovieID(userId, movieId);

            // Check if the wishlist item is found
            if (wishList != null) {
                // Print the wishlist item's ID for debugging
                logger.debug("Wishlist item found. ID: {}", wishList.getId());

                // Delete the wishlist item
                wishListRepository.delete(wishList);

                logger.info("Movie removed from wishlist. UserID: {}, MovieID: {}", userId, movieId);
                return "Movie removed from wishlist";
            } else {
                // Print a message if the wishlist item is not found
                logger.warn("Wishlist item not found for UserID: {} and MovieID: {}", userId, movieId);
                return "Failed to remove movie from wishlist. Wishlist item not found.";
            }
        } catch (Exception e) {
            logger.error("Failed to remove movie from wishlist: {}", e.getMessage());
            return "Failed to remove movie from wishlist: " + e.getMessage();
        }
    }

    // listMoviesInWishlist method

    public List<Movie> listMoviesInWishlist(int userId) {
        try {
            // Initialize the list to store movies
            List<Movie> movies = new ArrayList<>();

            // Retrieve the wishlist entries for the given user ID
            List<WishList> wishlistEntries = wishListRepository.findByUserID(userId);

            // Check if wishlist entries are found for the user
            if (!wishlistEntries.isEmpty()) {
                // Iterate through each wishlist entry
                for (WishList wishlistEntry : wishlistEntries) {
                    // Get the movie from the wishlist entry
                    Movie movie = wishlistEntry.getMovieID();
                    movies.add(movie);
                }
            } else {
                // Log a message if wishlist entries are not found for the user
                logger.info("No wishlist entries found for user ID: {}", userId);
            }

            return movies;
        } catch (Exception e) {
            logger.error("Error listing movies in wishlist for user ID {}: {}", userId, e.getMessage());
            return new ArrayList<>();
        }
    }

}
