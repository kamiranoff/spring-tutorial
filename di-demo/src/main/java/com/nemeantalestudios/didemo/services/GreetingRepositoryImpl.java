package com.nemeantalestudios.didemo.services;

import org.springframework.stereotype.Component;

/**
 * @author kevin
 */

@Component
public class GreetingRepositoryImpl implements GreetingRepository {

    @Override
    public String getEnglishGreeting() {
        return "Hello - From Greeting Repository";
    }

    @Override
    public String getFrenchGreeting() {
        return "Bonjour - From Greeting Repository";
    }

    @Override
    public String getSpanishhGreeting() {
        return "Buenos dias - From Greeting Repository";
    }
}
