package com.lessons.bestoftheyear.controller;

import com.lessons.bestoftheyear.model.Song;
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
@RequestMapping("/songs")
public class SongController {

    @GetMapping
    public String songs(Model model){
        List<Song> bestsongs = getBestSongs();
//        String songList = bestsongs.stream().map(Song::getTitle).collect(Collectors.joining(", "));
        model.addAttribute("songslist", bestsongs);
        return "songs";
    }

    @GetMapping("/{id}")
    public String songDetails(Model model, @PathVariable int id){
        List<Song> bestsongs = getBestSongs();
        Optional<Song> song = bestsongs.stream().filter((s) -> s.getId() == id).findFirst();
        if (song.isEmpty()){
            return "redirect:/songs";
        } else {
            model.addAttribute("song", song.get());
        }
        return "singleSong";
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

}
