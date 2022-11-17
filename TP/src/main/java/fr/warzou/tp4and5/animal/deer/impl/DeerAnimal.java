package fr.warzou.tp4and5.animal.deer.impl;

import fr.warzou.tp4and5.animal.Animal;
import fr.warzou.tp4and5.animal.deer.Deer;

public class DeerAnimal extends Deer {
    public DeerAnimal(Animal parent, String name, int age) {
        super(parent, name, age);
    }

    @Override
    public String toString() {
        return super.toString() + ", cerf";
    }
}
