package com.nemeantalestudios.didemo.services;

import org.springframework.stereotype.Service;

/**
 * @author kevin
 */

@Service
public class GreetingServiceImpl implements GreetingService {

    public static final String HELLO = "Hello there - Original Implementation";

    @Override
    public String sayGreeting() {
        return HELLO;
    }
}
