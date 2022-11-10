package fr.warzou.tp4and5.animal.bird.impl;

import fr.warzou.tp4and5.animal.bird.Bird;

public class Falcon extends Bird {
    public Falcon(String name, int age) {
        super(name, age);
    }

    @Override
    public int getLiveTime() {
        return 13;
    }

    @Override
    public String toString() {
        return super.toString() + ", Vraicon";
    }
}
