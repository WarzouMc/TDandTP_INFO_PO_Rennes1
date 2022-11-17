package fr.warzou.tp4and5.animal.bird.impl;

import fr.warzou.tp4and5.animal.Animal;
import fr.warzou.tp4and5.animal.bird.Bird;

public class Eagle extends Bird {
    public Eagle(Animal parent, String name, int age) {
        super(parent, name, age);
    }

    @Override
    public int getLiveTime() {
        return 14;
    }

    @Override
    public String toString() {
        return super.toString() + ", aigle";
    }
}
