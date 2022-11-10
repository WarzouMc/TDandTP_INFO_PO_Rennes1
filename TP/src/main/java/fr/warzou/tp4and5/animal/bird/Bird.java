package fr.warzou.tp4and5.animal.bird;

import fr.warzou.tp4and5.animal.Animal;

public abstract class Bird extends Animal {
    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return super.toString() + ", Type oiseau";
    }
}
