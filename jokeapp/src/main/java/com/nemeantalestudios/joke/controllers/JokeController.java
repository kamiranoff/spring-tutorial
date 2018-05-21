package com.nemeantalestudios.joke.controllers;

import com.nemeantalestudios.joke.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kevin
 */

@Controller
public class JokeController {

    private JokeService jokeService;

    @Autowired
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping("/")
    public String showJoke(Model model) {
        model.addAttribute("joke", jokeService.getJoke());

        // Name of the template/ html file
        return "chucknorris";
    }
}
