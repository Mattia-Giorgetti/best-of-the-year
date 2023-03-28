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
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home(Model model){
        String userName = "Mattia";
        model.addAttribute("name", userName);
        return "home";
    }
}
