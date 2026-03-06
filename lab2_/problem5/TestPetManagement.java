public class TestPetManagement {
    public static void main(String[] args) {
        System.out.println("=== Pet Management System ===\n");

        // Create people
        Person john = new Employee("John", 30, "Engineer");
        Person alice = new PhDStudent("Alice", 26, "Comp. Science", "AI");
        Person bob = new Student("Bob", 22, "Biology");

        // Create animals
        Animal murka = new Cat("Murka", 5);
        Animal rex = new Dog("Rex", 3);
        Animal tweety = new Bird("Tweety", 2);
        Animal nemo = new Fish("Nemo", 1);

        // Assign pets
        john.assignPet(murka);
        bob.assignPet(rex);

        // Try to give Alice a Dog - should be rejected
        System.out.println("\n--- Trying to assign Dog to PhD student ---");
        alice.assignPet(rex);  // Should print error

        // Give Alice a Cat instead
        alice.assignPet(tweety);

        // Register people
        PersonRegistry registry = new PersonRegistry();
        registry.addPerson(john);
        registry.addPerson(alice);
        registry.addPerson(bob);

        System.out.println("\n--- Initial State ---");
        System.out.println(registry);

        // John goes on vacation, leaves Murka with Alice
        System.out.println("\n--- John goes on vacation ---");
        john.leavePetWith(alice);
        // Alice already has Tweety, but we're overwriting (simplified)
        System.out.println(registry);

        // John returns and gets his cat back
        System.out.println("--- John returns from vacation ---");
        john.retrievePetFrom(alice);
        System.out.println(registry);

        // Test: Bob tries to leave Rex with Alice - PhD student can't take dogs
        System.out.println("\n--- Bob tries to leave Rex with Alice ---");
        bob.leavePetWith(alice);
        System.out.println(registry);

        // Test: person without a pet tries to leave a pet
        System.out.println("\n--- Alice (no pet) tries to leave a pet ---");
        alice.leavePetWith(bob);

        // Registry with/without pets
        System.out.println("\n--- People with pets ---");
        for (Person p : registry.getPeopleWithPets()) {
            System.out.println("  " + p);
        }
        System.out.println("--- People without pets ---");
        for (Person p : registry.getPeopleWithoutPets()) {
            System.out.println("  " + p);
        }

        // Animals making sounds
        System.out.println("\n--- Animal sounds ---");
        Animal[] animals = { murka, rex, tweety, nemo };
        for (Animal a : animals) {
            System.out.printf("%s says: %s%n", a.getName(), a.getSound());
        }
    }
}
