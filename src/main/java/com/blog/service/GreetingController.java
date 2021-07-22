package com.blog.service;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static String template="Hellow world, %s";
    private final AtomicLong coutner= new AtomicLong();

    @GetMapping("/greeting")
    public  Greeting greeting(@RequestParam(value="name",defaultValue = "World") String name)
    {

        return  new Greeting(coutner.incrementAndGet(),String.format(template,name));
    }
    @PostMapping("/greeting")
    public  Greeting eco(@RequestBody Greeting greeting)
    {
        return  new Greeting(coutner.incrementAndGet(),greeting.getContent());
    }
}
