package com.lessons.bestoftheyear.controller;

import com.lessons.bestoftheyear.model.Movie;
import com.lessons.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home(Model model){
        String userName = "Mattia";
        model.addAttribute("name", userName);
        return "home";
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
    private List<Song> getBestSongs(){
        List<Song> songs = new ArrayList<>();
        songs.add(new Song("Yellow Submarine",1));
        songs.add(new Song("Imagine",2));
        songs.add(new Song("Dust in the wind",3));
        songs.add(new Song("Somewhere over the rainbow",4));
        songs.add(new Song("Satisfaction",5));
        return songs;
    }

    @GetMapping("/movies")
    public String movies(Model model){
        List<Movie> bestmovies = getBestMovies();
        String movieList = "";
        for(Movie m:bestmovies){
            movieList += m.getTitle() + ", ";
        }
        movieList = movieList.substring(0,movieList.length()-2);
        model.addAttribute("movieslist",movieList);
        return "movies";
    }

    @GetMapping("/songs")
    public String songs(Model model){
        List<Song> bestsongs = getBestSongs();
        String songList = "";
        for (Song s : bestsongs){
            songList += s.getTitle() + ", ";
        }
        songList = songList.substring(0,songList.length()-2);
        model.addAttribute("songslist", songList);
        return "songs";
    }

//    BONUS

    @GetMapping("/movies/{id}")
    public String movieDetails(Model model, @PathVariable int id){
        List<Movie> bestmovies = getBestMovies();
        Optional<Movie> movie = bestmovies.stream().filter((m) -> m.getId() == id).findFirst();
        model.addAttribute("movie",  movie.get());
        return "singleMovie";
    }

    @GetMapping("/songs/{id}")
    public String songDetails(Model model, @PathVariable int id){
        List<Song> bestsongs = getBestSongs();
        Optional<Song> song = bestsongs.stream().filter((s) -> s.getId() == id).findFirst();
        model.addAttribute("song", song.get());
        return "singleSong";
    }

}
