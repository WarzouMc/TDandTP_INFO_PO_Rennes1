package fr.warzou.tp4and5.animal.felin;

import fr.warzou.tp4and5.animal.Animal;

public abstract class Feline extends Animal {
    public Feline(Animal parent, String name, int age) {
        super(parent, name, age);
    }

    @Override
    public String toString() {
        return super.toString() + ", Type Felin";
    }
}
