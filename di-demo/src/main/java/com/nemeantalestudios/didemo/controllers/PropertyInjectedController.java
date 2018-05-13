package com.nemeantalestudios.didemo.controllers;

import com.nemeantalestudios.didemo.services.GreetingServiceImpl;

/**
 * @author kevin
 */
public class PropertyInjectedController {

    public GreetingServiceImpl greetingService;

    public String sayHello() {
        return greetingService.sayGreeting();
    }

}
