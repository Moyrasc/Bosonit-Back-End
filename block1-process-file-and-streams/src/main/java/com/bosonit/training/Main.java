package com.bosonit.training;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException, InvalidLineFormatException {
        // la variable people es una lista de obj. con las personas que se leyeron en el csv
        List<Person> people = readCSV();
        System.out.println("*** Person List ***");
        for(Person per : people){
            System.out.println(per);
        }
        //Expresión para validar si es menor de 25 años
        Predicate<Person> isUnder25 = per -> per.getAge() > 0 && per.getAge() < 25;
        List<Person> isUnder25Person = filterPeople(people, isUnder25);
        //Expresión para validar que el nombre comience por la letra A
        Predicate<Person> startWithA = per -> per.getName().toUpperCase().startsWith("A") || per.getName().toUpperCase().startsWith("Á");
        List<Person> startWithAPerson = filterPeople(people, startWithA);
        for (Person per : startWithAPerson) {
            System.out.println(per);
        }
        //Obtener primer elemento cuya ciudad sea Madrid siendo menor de 25 y lo mismo con Bcn.
        Optional<Person> inMadrid = isUnder25Person.stream()
                .filter(per -> per.getTown().equals("Madrid"))
                .findFirst();
        Optional<Person> inBarcelona = isUnder25Person.stream()
                .filter(per -> per.getTown().equals("Barcelona"))
                .findFirst();
        if (inMadrid.isPresent()) {
            System.out.println("Person under 25 age from Madrid: " + inMadrid.get());
        } else {
            System.out.println("No person under 25 age from Madrid found");
        }
        if (inBarcelona.isPresent()) {
            System.out.println("Person under 25 age from Barcelona: " + inBarcelona.get());
        } else {
            System.out.println("No person under 25 age from Barcelona found");
        }

    }

    //Leer fichero csv
    public static List<Person> readCSV() throws IOException,InvalidLineFormatException{
        List<Person> people = new ArrayList<>();
        Path path = Paths.get("block1-process-file-and-streams/src/main/resources/people.csv");
        //Lee el archivo
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            //Lee linea de texto
            String line = reader.readLine();
            while (line != null) {
                //Creo el bloque try-catch dentro del while para poder manejar la excepcion sin que el código deje de ejecutarse
                try {
                    String[] data = line.split(":");
                    if (data.length < 2 || data[0].isBlank()) {
                        throw new InvalidLineFormatException("Invalid line format or name can't be blank in: " + line);
                    }
                    String name = data[0];
                    String town = data[1].isBlank() ? "unknown" : data[1];
                    int age = data.length > 2 ? Integer.parseInt(data[2]) : 0;
                    people.add(new Person(name, town, age));
                } catch (InvalidLineFormatException e) {
                    System.out.println(e.getMessage());
                }
                line = reader.readLine();
            }
        } catch (IOException e){

            //captura donde se produce la excepción y en que línea del código
            e.printStackTrace();
        }
        return people;
    }
    /* recibe como arg la lista de obj.Person y la condición de filtrado dada por el Predicate, utilizo un
    método stream para filtrar*/
    public static List<Person> filterPeople(List<Person> people, Predicate<Person> predicate){
        return people.stream()
                .filter(predicate)
                .collect(Collectors.toList()); //Operador final para transformar el flujo modificado a lista

    }


}
