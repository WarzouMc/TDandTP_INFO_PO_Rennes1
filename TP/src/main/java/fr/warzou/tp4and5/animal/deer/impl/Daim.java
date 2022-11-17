package fr.warzou.tp4and5.animal.deer.impl;

import fr.warzou.tp4and5.animal.Animal;
import fr.warzou.tp4and5.animal.deer.Deer;

public class Daim extends Deer {
    public Daim(Animal parent, String name, int age) {
        super(parent, name, age);
    }

    @Override
    public String toString() {
        return super.toString() + ", daim";
    }
}
