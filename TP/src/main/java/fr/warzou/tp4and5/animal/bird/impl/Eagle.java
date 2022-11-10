package fr.warzou.tp4and5.animal.bird.impl;

import fr.warzou.tp4and5.animal.bird.Bird;

public class Eagle extends Bird {
    public Eagle(String name, int age) {
        super(name, age);
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
