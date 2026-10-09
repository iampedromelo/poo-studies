package org.example;

public final class Wolf extends Animal {
    public Wolf(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println("Auuuuuu!");
    }

    void run(){
        System.out.println("Wolf is running!");
    }
}
