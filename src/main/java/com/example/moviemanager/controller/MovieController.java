package com.example.moviemanager.controller;


import com.example.moviemanager.model.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/movies")
public class MovieController {

    // Array Operation: Initialize a fixed-size array (new Movie[5])
   private Movie [] topMovies= new Movie[5];// Fixed-size array to store 5 movies

    //Fixed-size array to store 5 movies
    private int currentSize  = 0; //Fixed-size array to store 5 movies

    //Fixed-size array to store 5 movies
    @PostMapping
    public ResponseEntity<?> addMovie(@RequestBody Movie movie) {
       // Fixed-size array to store 5 movies
        if (currentSize == topMovies.length) {
            return ResponseEntity.badRequest().body ("Movie List is Full");
        }
        topMovies[currentSize] = movie;
        currentSize++;// Increment size after adding
        return ResponseEntity.ok ("Movie added at position: " + currentSize);
}
// Clear all movies
@DeleteMapping
public ResponseEntity<String> clearAllMovies() {
    // Array Operation: Initialize a fixed-size array (new Movie[5]) to reset
    topMovies = new Movie[5];
    // Array Operation: Track size manually (currentSize)
    currentSize = 0;
    return ResponseEntity.ok("Movie List is Empty");
}
}
