package net.rizz.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.rizz.model.Greetings;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/hello")
    public Greetings greetings(@RequestParam(value = "name", defaultValue = "World") String name){

        return new Greetings(counter.incrementAndGet(), String.format(template, name));
    }

}
