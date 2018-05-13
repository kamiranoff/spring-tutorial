package com.nemeantalestudios.didemo.controllers;

import org.springframework.stereotype.Controller;

/**
 * @author kevin
 */

@Controller
public class MyController {

    public String hello() {
        System.out.println("Hello");
        return "Hello";
    }

}
