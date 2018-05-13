package com.nemeantalestudios.didemo.services;

import org.springframework.stereotype.Service;

/**
 * @author kevin
 */

@Service
public class ConstructorGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello - I was injected via the constructor";
    }
}
