package org.example;

public final class Lion extends Animal {
    public Lion(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println("Rrrrrwaarrr!");
    }

    void run(){
        System.out.println("Lion is running");
    }
}
