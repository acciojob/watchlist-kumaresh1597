package com.driver;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    private MovieService movieService = new MovieService();
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.addmovie(movie);
        return new ResponseEntity<>("New Movie added Successfully", HttpStatus.CREATED);
    }
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieService.adddirector(director);
        return new ResponseEntity<>("New director added Successfully",HttpStatus.CREATED);
    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movieName, @RequestParam String directorName){
        movieService.addMovieDirectorPair(movieName,directorName);
        return  new ResponseEntity<>("New Pair added Successfully",HttpStatus.CREATED);
    }
    @GetMapping("/get-movie-by-name/{movieName}")
   public ResponseEntity<Movie> getMovieByName(@PathVariable String movieName){
        Movie mve = movieService.getMovieByName(movieName);
        return new ResponseEntity<>(mve,HttpStatus.CREATED);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name) {
        Director dir = movieService.getDirectorByName(name);
        return new ResponseEntity<>(dir, HttpStatus.CREATED);
    }
    @GetMapping("/get-movies-by-director-name/{directorName}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String directorName){
        List<String> mveList = movieService.getMovieListByDirector(directorName);
        return new ResponseEntity<>(mveList,HttpStatus.CREATED);
    }
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> mveList = movieService.getAllMovies();
        return new ResponseEntity<>(mveList,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String name){
        movieService.deleteDirector(name);
        return new ResponseEntity<>(name +" removed successfully",HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.delAll();
        return new ResponseEntity<>("All Directors deleted Successfully",HttpStatus.CREATED);
    }
}
