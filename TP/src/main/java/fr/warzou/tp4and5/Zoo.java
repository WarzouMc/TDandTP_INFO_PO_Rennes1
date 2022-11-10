package fr.warzou.tp4and5;

import fr.warzou.tp4and5.animal.Animal;
import fr.warzou.tp4and5.animal.felin.impl.Lion;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Zoo {
    private String name;
    private int maxSize;
    private Animal[] population;

    public Zoo(String name, int maxSize) {
        this.name = name;
        this.maxSize = maxSize;
        this.population = new Animal[this.maxSize];
    }

    public static void main(String[] args) {
        System.out.println(new Lion("Wsh Simba", 3783));
    }

    public Animal oldest() {
        if (this.population.length == 0) return null;
        Animal oldest = this.population[0];
        for (Animal animal : this.population)
            if (oldest.getAge() < animal.getAge()) oldest = animal;

        return oldest;
    }

    public double mediumAge() {
        int ageSum = 0;
        for (Animal animal : this.population)
            if (animal != null)  ageSum += animal.getAge();

        return (ageSum + 0.0d) / animalCount();
    }

    public Animal[] childs() {
        return (Animal[]) Arrays.stream(this.population)
                .filter(animal -> animal != null && animal.getAge() <= animal.getLiveTime() * 0.25).toArray();
    }

    /**
     * Un while sinon genre
     * tant que i < population.size && population[i] == null faire i++; setAnimal(i, animal);
     */
    public void addAnimal(@NotNull Animal animal) {
        findFirst(null).ifPresent(i -> setAnimal(i, animal));
    }

    public void removeAnimal(@NotNull Animal animal) {
        findFirst(animal).ifPresent(i -> setAnimal(i, null));
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "name='" + name + '\'' +
                ", maxSize=" + maxSize +
                ", population=" + Arrays.toString(population) +
                '}';
    }

    private int animalCount() {
        return (int) Arrays.stream(this.population).filter(Objects::nonNull).count();
    }

    //def le .equal partout mais flm hein
    private OptionalInt findFirst(Animal animal) {
        return IntStream.range(0, this.population.length).filter(i ->
            (this.population[i] == null && animal == null) || this.population[i].equals(animal)).findFirst();
    }

    private void setAnimal(int index, Animal animal) {
        this.population[index] = animal;
    }
}
