package com.example.block5commandlinerunner;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
//@Component se usa para indicar un componente de Spring,
// marca la clase como un Bean y así podra agregarla al contexto de la app
@Component
public class firstClass {
    //@PostConstruct se ejecuta una vez antes de la inicialización del bean.
    @PostConstruct
    public void hello() {
        System.out.println("Hi from first class");
    }
}
