package fr.warzou.tp4and5.animal.bird;

import fr.warzou.tp4and5.animal.Animal;

public abstract class Bird extends Animal {

    private int spectacle = 0;

    public Bird(Animal parent, String name, int age) {
        super(parent, name, age);
    }

    @Override
    public String toString() {
        return super.toString() + ", Type oiseau, " + this.spectacle + " spectacle...";
    }

    public int getSpectacle() {
        return this.spectacle;
    }

    public void addSpectacle() {
        this.spectacle++;
    }
}
