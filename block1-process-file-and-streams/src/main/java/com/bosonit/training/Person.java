package com.bosonit.training;

public class Person {
    private String name;
    private String town;
    private int age;

    //constructor
    public  Person(String name,String town, int age){
        this.name = name;
        this.town = town;
        this.age = age;
    }
    // Métodos getter y setter
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getTown(){
        return town;
    }
    public void setTown(String town){
        this.town = town;
    }
    public int getAge(){
        return age;
    }
    public void setAge(){
        this.age = age;
    }

    @Override
    public String toString(){
        return "Person{" +
                "name='" + name + '\'' +
                ", town='" + town + '\'' +
                ", age=" + age +
                '}';

    }
}
