package org.example;

public abstract class Animal {
    private String name;

    protected Animal(String name) {
        this.name = name;
    }

    abstract void makeSound();
}
