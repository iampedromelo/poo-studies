package org.example;

public class Zoo {
    private final Animal[] animals;

    public Zoo() {
        this.animals = createCages(10);
    }

    private Animal[] createCages(int n){
        Animal[] cages = new Animal[n];

        for (int i = 0; i < cages.length; i++) {

            if(i%3 == 0){
                cages[i] = new Owl( "Owl " + i);
            } else if (i % 3 == 1){
                cages[i] = new Lion( "Lion " + i);
            } else{
                cages[i] = new Wolf("Wolf " + i);
            }
        }

        return cages;
    }

    public Animal[] getAnimals() {
        return animals;
    }
}
