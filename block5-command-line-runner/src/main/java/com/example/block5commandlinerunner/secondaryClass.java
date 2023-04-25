package com.example.block5commandlinerunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class secondaryClass implements CommandLineRunner {
    public void secondaryClass(){
        System.out.println("Hi from secondary class");
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
