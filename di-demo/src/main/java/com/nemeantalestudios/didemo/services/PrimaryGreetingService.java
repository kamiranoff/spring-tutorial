package com.nemeantalestudios.didemo.services;

/**
 * @author kevin
 */

//@Service
//@Primary
//@Profile({"en", "default"})
public class PrimaryGreetingService implements GreetingService {


    private GreetingRepository greetingRepository;

    public PrimaryGreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public String sayGreeting() {
        return "Hello - From the primary greeting service";
    }
}
