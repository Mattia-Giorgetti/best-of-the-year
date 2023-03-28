package com.lessons.bestoftheyear.controller;

import com.lessons.bestoftheyear.model.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @GetMapping
    public String movies(Model model){
        List<Movie> bestmovies = getBestMovies();
//        String movieList = bestmovies.stream().map(Movie::getTitle).collect(Collectors.joining(", "));
        model.addAttribute("movieslist",bestmovies);
        return "movies";
    }

    @GetMapping("/{id}")
    public String movieDetails(Model model, @PathVariable int id){
        List<Movie> bestmovies = getBestMovies();
        Optional<Movie> movie = bestmovies.stream().filter((m) -> m.getId() == id).findFirst();
        if(movie.isEmpty()){
            return "redirect:/movies";
        } else {
            model.addAttribute("movie",  movie.get());
        }
        return "singleMovie";
    }
    private List<Movie> getBestMovies(){
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Avengers:Endgame", 1));
        movies.add(new Movie("The Batman", 2));
        movies.add(new Movie("Il signore degli anelli", 3));
        movies.add(new Movie("Harry Potter", 4));
        movies.add(new Movie("BladeRunner", 5));
        return movies;
    }
}
