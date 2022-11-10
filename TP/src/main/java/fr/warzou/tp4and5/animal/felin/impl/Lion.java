package fr.warzou.tp4and5.animal.felin.impl;

import fr.warzou.tp4and5.animal.felin.Feline;

public class Lion extends Feline {
    public Lion(String name, int age) {
        super(name, age);
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
