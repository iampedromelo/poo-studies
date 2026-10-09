package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Zoo zoo = new Zoo();

        for(Animal animal : zoo.getAnimals()){
            animal.makeSound();
            if(animal instanceof Lion lion){
                lion.run();
            } else if(animal instanceof Wolf wolf){
                wolf.run();
            }
        }
    }
}
