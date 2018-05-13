package com.nemeantalestudios.didemo.controllers;

import com.nemeantalestudios.didemo.services.GreetingService;
import org.springframework.stereotype.Controller;

/**
 * @author kevin
 */

@Controller
public class ConstructorInjectedController {

    private GreetingService greetingService;

    public ConstructorInjectedController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
