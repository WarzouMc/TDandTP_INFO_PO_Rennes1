package fr.warzou.tp4and5.animal.felin.impl;

import fr.warzou.tp4and5.animal.Animal;
import fr.warzou.tp4and5.animal.felin.Feline;

public class Panther extends Feline {
    public Panther(Animal parent, String name, int age) {
        super(parent, name, age);
    }

    @Override
    public int getLiveTime() {
        return 15;
    }

    @Override
    public String toString() {
        return super.toString() + ", panther";
    }
}
