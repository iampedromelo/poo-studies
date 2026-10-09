package org.example;

public final class Owl extends Animal {
    public Owl(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println("Pruu Pruu!");
    }
}
