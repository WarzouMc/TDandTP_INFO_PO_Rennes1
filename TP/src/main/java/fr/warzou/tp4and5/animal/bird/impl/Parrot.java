package fr.warzou.tp4and5.animal.bird.impl;

import fr.warzou.tp4and5.animal.Animal;
import fr.warzou.tp4and5.animal.bird.Bird;

public class Parrot extends Bird {
    public Parrot(Animal parent, String name, int age) {
        super(parent, name, age);
    }

    @Override
    public int getLiveTime() {
        return 45;
    }

    @Override
    public String toString() {
        return super.toString() + ", perroquet";
    }
}
