package com.turtle.track.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/home", "/"})
    public String home() {

        return "home"; // be same as the template file name (without suffix)
    }
}
