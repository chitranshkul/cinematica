package com.esdproject.academiq.wishList;

import com.amazonaws.services.dynamodbv2.xspec.L;
import com.amazonaws.services.dynamodbv2.xspec.S;
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

    // Constructor injection
//    public WishListService(WishListRepository wishListRepository, UserRepository userRepository, MovieRepository movieRepository) {
//        this.wishListRepository = wishListRepository;
//        this.userRepository = userRepository;
//        this.movieRepository = movieRepository;
//    }

    public String addToWishList(int userId, int movieId) {
        // Find the user by ID
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            return "Unable to add: User not found with ID: " + userId;
        }
        User user = optionalUser.get();

        // Find the movie by ID
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
        if (optionalMovie.isEmpty()) {
            return "Unable to add: Movie not found with ID: " + movieId;
        }
        Movie movie = optionalMovie.get();

        WishList existingWishList = wishListRepository.findByUserIDAndMovieID(userId, movieId);
        if (existingWishList != null) {
            return "Already added to WishList";
        }
        // Create a new wish list item using the builder pattern
        WishList wishList = WishList.builder()
                .UserID(user)
                .movieID(movie)
                .build();

        // Save the wish list item
        wishListRepository.save(wishList);

        return "Movie added successfully to wishlist";
    }

    public String removefromWishList(int userId, int movieId) {
        // Print userId and movieId for debugging
        System.out.println("Removing movie from wishlist. UserID: " + userId + ", MovieID: " + movieId);

        // Find the wishlist item associated with the user and movie
        WishList wishList = wishListRepository.findByUserIDAndMovieID(userId, movieId);

        // Check if the wishlist item is found
        if (wishList != null) {
            // Print the wishlist item's ID for debugging
            System.out.println("Wishlist item found. ID: " + wishList.getId());

            // Delete the wishlist item
            wishListRepository.delete(wishList);
            return "Movie removed from wishlist";
        } else {
            // Print a message if the wishlist item is not found
            System.out.println("Wishlist item not found for UserID: " + userId + " and MovieID: " + movieId);
            return "Failed to remove movie from wishlist. Wishlist item not found.";
        }
    }



    public List<Movie> listMoviesInWishlist(int userId) {
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
            System.out.println("No wishlist entries found for user ID: " + userId);
        }

        return movies;
    }




}
