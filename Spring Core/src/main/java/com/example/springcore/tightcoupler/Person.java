package com.example.springcore.tightcoupler;

public class Person {

    //tight coupling
    Animal animal=new Animal();
    public void play(){
        animal.play();
    }
}
