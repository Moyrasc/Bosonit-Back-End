package com.example.block5commandlinerunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Block5CommandLineRunnerApplication implements CommandLineRunner {
//@Autowired le indica a Spring que busque un @Bean o @Component en el contexto de la aplicación y realice la inyección automaticamente
	@Autowired
	private firstClass firstClass;
	@Autowired
	private secondaryClass secondaryClass;
	@Autowired
	private thirdClass thirdClass;

	public static void main(String[] args) {
		SpringApplication.run(Block5CommandLineRunnerApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

	}
}

/* ¿En qué orden se muestran los mensajes? ¿Por qué?
El primer mensaje que se muestra es el de firstClass(Hi from first class) ya que lleva la anotación @PostConstruct
con lo que le indicamos que debe ejecutarse en el momento que el bean ha sido creado en cambio CommandLineRunner
se ejecutará una vez la aplicación haya arrancado por lo que se ejecutará secondaryClass y por último thirdClass*/