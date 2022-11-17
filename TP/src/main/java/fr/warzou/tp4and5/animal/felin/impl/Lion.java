package fr.warzou.tp4and5.animal.felin.impl;

import fr.warzou.tp4and5.animal.Animal;
import fr.warzou.tp4and5.animal.felin.Feline;

public class Lion extends Feline {
    public Lion(Animal parent, String name, int age) {
        super(parent, name, age);
    }

    @Override
    public int getLiveTime() {
        return 12;
    }

    @Override
    public String toString() {
        return super.toString() + ", lion";
    }
}
