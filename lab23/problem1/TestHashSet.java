package lab23.problem1;

import java.util.HashSet;

public class TestHashSet {
    public static void main(String[] args) {

        
        System.out.println("=== Animal HashSet Test ===");
        HashSet<Animal> animals = new HashSet<>();

        Animal a1 = new Animal("Leo", "Lion");
        Animal a2 = new Animal("Bella", "Dog");
        Animal a3 = new Animal("Leo", "Lion"); 

        animals.add(a1);
        animals.add(a2);
        animals.add(a3); 

        System.out.println("HashSet size " + animals.size());
        System.out.println("Contents: " + animals);

        HashSet<Pet> pets = new HashSet<>();

        Pet p1 = new Pet("Max", "Dog", "Alice");
        Pet p2 = new Pet("Max", "Dog", "Bob");   
        Pet p3 = new Pet("Max", "Dog", "Alice"); 

        pets.add(p1);
        pets.add(p2);
        pets.add(p3);

        System.out.println("HashSet size " + pets.size());
        System.out.println("Contents: " + pets);
    }
}
