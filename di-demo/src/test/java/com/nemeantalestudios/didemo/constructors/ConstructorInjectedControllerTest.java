package com.nemeantalestudios.didemo.constructors;

import com.nemeantalestudios.didemo.controllers.ConstructorInjectedController;
import com.nemeantalestudios.didemo.services.GreetingServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * @author kevin
 */
public class ConstructorInjectedControllerTest {

    private ConstructorInjectedController constructorInjectedController;

    @Before
    public void setUp() throws Exception {
        this.constructorInjectedController = new ConstructorInjectedController(new GreetingServiceImpl());
    }

    @Test
    public void testGreeting() {
        assertEquals(GreetingServiceImpl.HELLO, constructorInjectedController.sayHello() );
    }
}
