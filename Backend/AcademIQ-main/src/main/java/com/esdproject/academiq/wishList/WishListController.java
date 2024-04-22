package com.esdproject.academiq.wishList;

import com.amazonaws.services.dynamodbv2.xspec.S;
import com.esdproject.academiq.movie.Movie;
import com.esdproject.academiq.token.Token;
import com.esdproject.academiq.token.TokenRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.Key;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/wishlist")
public class WishListController {
    private static final Logger logger = LogManager.getLogger(WishListController.class);
     @Autowired
    private final WishListService wishListService;
    private final TokenRepository tokenRepository;
    private final Key signingKey = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);

    @PostMapping("/AddtoWishList/{Mid}")
    public ResponseEntity<String> addtoWishList(
            @RequestHeader("Authorization") String token,
            @PathVariable Integer Mid) {
        try {
            String jwtToken = token.substring(7); // Extract JWT part from token
            logger.info("Token before substring: {}", token);
            logger.info("JWT part after substring: {}", jwtToken);

            int userId = getUserIdFromToken(jwtToken); // Extract user ID from token

            String str = wishListService.addToWishList(userId, Mid);
            return ResponseEntity.ok(str);
        } catch (Exception e) {
            logger.error("Failed to add to wish list: {}", e.getMessage());
            return ResponseEntity.badRequest().body("Failed to add to wish list: " + e.getMessage());
        }
    }

    // Method to extract user ID from token
    private int getUserIdFromToken(String jwtToken) {
        // Query the database to find the Token entity associated with the provided JWT token
        Optional<Token> tokenOptional = tokenRepository.findByToken(jwtToken);

        // Check if the token entity is found
        if (tokenOptional.isPresent()) {
            Token tokenEntity = tokenOptional.get();
            // Check if the token is revoked or expired
            if (!tokenEntity.isRevoked() && !tokenEntity.isExpired()) {
                // If not revoked and not expired, return the user ID associated with the token
                return tokenEntity.getUser().getId();
            } else {
                // Token is either revoked or expired, return -1 or handle accordingly
                return -1; // Or handle differently based on your requirements
            }
        } else {
            // Token not found in the table
            return -1; // Return an error value or handle differently based on your requirements
        }
    }

    @PostMapping("/RemovefromWishList/{Mid}")
    public ResponseEntity<String> removefromWishlist(
            @RequestHeader("Authorization") String token,
            @PathVariable Integer Mid) {
        try {
            String jwtToken = token.substring(7); // Extract JWT part from token
            logger.info("Token before substring: {}", token);
            logger.info("JWT part after substring: {}", jwtToken);

            int userId = getUserIdFromToken(jwtToken); // Extract user ID from token

            wishListService.removefromWishList(userId, Mid); // Pass userId and Mid to the service method
            return ResponseEntity.ok("Removed from Wishlist successfully");
        } catch (Exception e) {
            logger.error("Failed to remove from wish list: {}", e.getMessage());
            return ResponseEntity.badRequest().body("Failed to remove from wish list: " + e.getMessage());
        }
    }

    @GetMapping("/ListMoviesinWishlist")
    public ResponseEntity<List<Movie>> listMoviesInWishlist(
            @RequestHeader("Authorization") String token) {
        try {
            String jwtToken = token.substring(7); // Extract JWT part from token
            logger.info("Token before substring: {}", token);
           // logger.info("JWT part after substring: {}", jwtToken);

            int userId = getUserIdFromToken(jwtToken); // Extract user ID from token

            List<Movie> movies = wishListService.listMoviesInWishlist(userId); // Use the correct method

            return ResponseEntity.ok(movies);
        } catch (Exception e) {
            logger.error("Error listing movies in wishlist: {}", e.getMessage());
            return ResponseEntity.badRequest().body(null); // Return an empty list or handle the error differently
        }
    }
}
