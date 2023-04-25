package com.example.block5commandlinerunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class thirdClass implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hi, I'm the third class");
        //modifico función para que en caso de recibir parametros imprima los valores al ejecutar el programa
        for(String arg : args){
            System.out.println(arg);
        }
    }
}
