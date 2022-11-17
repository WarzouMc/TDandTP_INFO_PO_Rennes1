package fr.warzou.tp4and5;

import fr.warzou.tp4and5.animal.Animal;
import fr.warzou.tp4and5.animal.bird.Bird;
import fr.warzou.tp4and5.animal.bird.impl.Falcon;
import fr.warzou.tp4and5.animal.deer.impl.DeerAnimal;
import fr.warzou.tp4and5.animal.felin.impl.Lion;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

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
        Zoo zoo = new Zoo("OwO le Zoo", 10);
        zoo.addAnimal(new Lion(null, "Wsh Simba", 61));
        zoo.addAnimal(new Falcon(null, "Vrai con", 15));
        zoo.addAnimal(new Lion(null, "Wsh Zimba", 62));
        zoo.addAnimal(new DeerAnimal(null, "Coucouuuu", 10));
        System.out.println(zoo.especeLaPlusPresente());
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

    public Class<? extends Animal> especeLaPlusPresente() {
        Map<Class<? extends Animal>, Integer> superClasses = new HashMap<>();
        for (Animal animal : this.population) {
            if (animal == null)
                continue;

            Class<? extends Animal> clazz = animal.getClass().getSuperclass().asSubclass(Animal.class);
            if (superClasses.containsKey(clazz))
                continue;
            superClasses.put(clazz, countSpecies(clazz));
        }
        return superClasses.entrySet().stream().min(new Comparator<Map.Entry<Class<? extends Animal>, Integer>>() {
            @Override
            public int compare(Map.Entry<Class<? extends Animal>, Integer> o1, Map.Entry<Class<? extends Animal>, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        }).orElseThrow(NoSuchElementException::new).getKey();
    }

    private int countSpecies(Class<? extends Animal> clazz) {
        return (int) Arrays.stream(this.population).filter(clazz::isInstance).count();
    }

    public void creerSpectacle(Bird bird) {
        bird.addSpectacle();
        System.out.println("'" + bird + "' participera...");
    }

    public Bird trouverOiseauLeMoinsFatigue() {
        AtomicReference<Bird> birdAtomicReference = new AtomicReference<>();
        Arrays.stream(this.population).filter(animal -> animal instanceof Bird).map(animal -> (Bird) animal).forEach(bird -> {
            Bird minBird = birdAtomicReference.get();
            if (minBird == null)
                birdAtomicReference.set(bird);
            else if (minBird.getSpectacle() < bird.getSpectacle())
                birdAtomicReference.set(bird);
        });
        return birdAtomicReference.get();
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
