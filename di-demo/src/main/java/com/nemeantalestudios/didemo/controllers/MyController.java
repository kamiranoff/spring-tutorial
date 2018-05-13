package com.nemeantalestudios.didemo.controllers;

import com.nemeantalestudios.didemo.services.GreetingService;
import org.springframework.stereotype.Controller;

/**
 * @author kevin
 */

@Controller
public class MyController {


    private GreetingService greetingService;

    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String hello() {
        return greetingService.sayGreeting();
    }

}
