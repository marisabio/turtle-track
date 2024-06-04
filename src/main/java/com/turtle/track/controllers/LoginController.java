package com.turtle.track.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping({"/login"})
    public String login() {

        return "login"; // be same as the template file name (without suffix)
    }
}

