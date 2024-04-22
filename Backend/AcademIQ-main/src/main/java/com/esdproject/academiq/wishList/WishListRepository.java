package com.esdproject.academiq.wishList;

import com.esdproject.academiq.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface WishListRepository extends JpaRepository<WishList, Integer> {
    // Spring Data JPA naming convention
//    WishList findByUserIDAndMovieID(int userID, int movieID);

    // JPQL query with @Query annotation
    @Query("SELECT w FROM WishList w WHERE w.UserID.id = :userId AND w.movieID.id = :movieId")
    WishList findByUserIDAndMovieID(@Param("userId") int userId, @Param("movieId") int movieId);


    // You can uncomment these methods if needed
    // WishList findByUserID(User user);
    // WishList findByMovieID(Movie movie);
    // WishList findByUserIDAndMovieID(User user, Movie movie);
    @Query("SELECT w FROM WishList w WHERE  w.UserID.id=:userId")
    List<WishList> findByUserID(@Param("userId") int userId);


}

