package com.nemeantalestudios.didemo.controllers;

import com.nemeantalestudios.didemo.services.GreetingService;

/**
 * @author kevin
 */
public class SetterInjectedController {

    private GreetingService greetingService;

    public String sayHello() {
        return greetingService.sayGreeting();
    }

    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

}
