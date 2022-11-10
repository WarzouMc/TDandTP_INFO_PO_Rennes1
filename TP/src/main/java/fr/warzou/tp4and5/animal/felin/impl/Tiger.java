package fr.warzou.tp4and5.animal.felin.impl;

import fr.warzou.tp4and5.animal.felin.Feline;

public class Tiger extends Feline {
    public Tiger(String name, int age) {
        super(name, age);
    }

    @Override
    public int getLiveTime() {
        return 23;
    }

    @Override
    public String toString() {
        return super.toString() + ", tigre";
    }
}
