package com.nemeantalestudios.didemo.controllers;

import com.nemeantalestudios.didemo.services.GreetingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author kevin
 *
 * This is a bad pattern don't use this.
 *
 */

@Controller
public class PropertyInjectedController {

    @Autowired
    public GreetingServiceImpl greetingService;

    public String sayHello() {
        return greetingService.sayGreeting();
    }

}
