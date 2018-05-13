package com.nemeantalestudios.didemo.controllers;

import com.nemeantalestudios.didemo.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Qualifier("greetingServiceImpl")
    public GreetingService greetingService;

    public String sayHello() {
        return greetingService.sayGreeting();
    }

}
