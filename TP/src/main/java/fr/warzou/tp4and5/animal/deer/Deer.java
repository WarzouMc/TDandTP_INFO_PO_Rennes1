package fr.warzou.tp4and5.animal.deer;

import fr.warzou.tp4and5.animal.Animal;

public abstract class Deer extends Animal {
    public Deer(Animal parent, String name, int age) {
        super(parent, name, age);
    }

    @Override
    public int getLiveTime() {
        return 20;
    }

    @Override
    public String toString() {
        return super.toString() + ", Type cervidae";
    }
}
