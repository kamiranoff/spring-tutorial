package com.nemeantalestudios.didemo.services;

import org.springframework.stereotype.Service;

/**
 * @author kevin
 */
@Service
public class SetterGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello - I was implemented via a setter";
    }
}
